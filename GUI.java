package magicsquare;

import javax.swing.*;
import BreezySwing.*;

public class GUI extends GBFrame {
	public static void main(String[] args) {
		JFrame frm = new GUI();
		frm.setTitle("Magic Square");
		frm.setSize(1000, 800);
		frm.setVisible(true);
	}

	MagicSquare sender = new MagicSquare();
	JLabel dimensionlabel = addLabel("Please enter the size of the square:", 1, 1, 1, 1);
	IntegerField dimension = addIntegerField(0, 1, 2, 1, 1);
	JButton dimensionconfirm = addButton("Confirm", 3, 1, 1, 1);
	JLabel inputlabel = addLabel("Please enter the number you would like to input:", 2, 1, 1, 1);
	IntegerField input = addIntegerField(0, 2, 2, 1, 1);
	JButton inputnumber = addButton("Input Number", 3, 2, 1, 1);

	public GUI() {
		inputlabel.setVisible(false);
		input.setVisible(false);
		inputnumber.setVisible(false);
	}

	public void buttonClicked(JButton button) {
		if (button == dimensionconfirm) {
			if (sender.CheckDimension(dimension.getNumber()) == false && dimension.isValidNumber()) {
				sender.setDimension(dimension.getNumber());
				dimension.setEnabled(false);
				dimensionconfirm.setVisible(false);
				inputlabel.setVisible(true);
				input.setVisible(true);
				inputnumber.setVisible(true);
			} else {
				messageBox("Dimension of square can be 2 minimum or 8 maximum.");
			}
		}
		if(button==inputnumber) {
			sender.setValue(input.getNumber());
			if(sender.CheckIfDone()) {
				messageBox("Full square has been input.");
				input.setEnabled(false);
			}
			input.requestFocus();
			
		}
		

	
	}
	

}
