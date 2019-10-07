//Aditya Agrawal
// October 7, 2019
//Magic Square Program
//Magic Square program will take a user input square and output if it is a magic square
package proyecto;

import javax.swing.*;
import BreezySwing.*;

public class GUI extends GBFrame {

	public static void main(String[] args) {
		JFrame frm = new GUI();
		frm.setTitle("Magic Square");
		frm.setSize(800, 800);
		frm.setVisible(true);
	}

	methods sender = new methods();
	JLabel dimensionlabel = addLabel("Please enter the dimension of the square:", 1, 1, 1, 1);
	IntegerField dimension = addIntegerField(0, 1, 2, 1, 1);
	JButton dimensionconfirm = addButton("Confirm Dimension", 3, 1, 1, 1);
	JLabel inputlabel = addLabel("Please enter the number you would like to input:", 2, 1, 1, 1);
	IntegerField input = addIntegerField(0, 2, 2, 1, 1);
	JButton inputnumber = addButton("Input Number", 3, 2, 1, 1);
	JTextArea squareoutput = addTextArea("", 4, 1, 1, 1);
	JButton clearinput = addButton("Clear Input", 3, 3, 1, 1);

	public GUI() {
		input.setEnabled(false);
		inputnumber.setEnabled(false);
		dimension.requestFocus();
	}

	public void buttonClicked(JButton button) {
		if (button == dimensionconfirm) {
			if (sender.CheckDimension(dimension.getNumber()) == false && dimension.isValidNumber()) {
				sender.setDimension(dimension.getNumber());
				dimension.setEnabled(false);
				dimensionconfirm.setEnabled(false);
				input.setEnabled(true);
				inputnumber.setEnabled(true);
				input.requestFocus();
			} else {
				messageBox("Dimension of square can be 2 minimum or 8 maximum.");
			}
		}
		if (button == inputnumber) {
			if (input.getNumber() >= 0 && input.isValidNumber()) {
				sender.setValue(input.getNumber());
			} else {
				messageBox("Invalid input. Number must be a positive integer.");
			}

			if (sender.CheckIfDone()) {
				messageBox("Full square has been input.");
				input.setEnabled(false);
				inputnumber.setEnabled(false);
				if (sender.CheckIfMagic())
					squareoutput.setText(sender.displaySquare()
							+ "\nThis is a magic square with magic square constant: " + sender.getConstant());
				else
					squareoutput.setText(sender.displaySquare() + "\nThis is not a magic square.");
			}
			input.requestFocus();
		}
		if (button == clearinput) {
			dimension.setNumber(0);
			dimension.setEnabled(true);
			input.setNumber(0);
			input.setEnabled(false);
			inputnumber.setEnabled(false);
			dimensionconfirm.setEnabled(true);
			squareoutput.setText("");
			sender.ClearInput();
		}

	}

}