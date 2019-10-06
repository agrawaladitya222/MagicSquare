package proyecto;

public class methods {
	private int[][] square;
	private int row = 0, column = 0, dimension;
	private boolean done = false;

	public void setDimension(int dim) {
		square = new int[dim][dim];
		dimension = dim;
	}

	public boolean CheckDimension(int dim) {
		boolean error = false;
		if (dim < 2)
			error = true;
		if (dim > 8)
			error = true;
		return error;
	}

	public void setValue(int input) {

		if (row <= (dimension - 1) && column <= (dimension - 1)) {
			square[row][column] = input;
		}
		column = column + 1;
		if (column > (dimension - 1)) {
			column = 0;
			row = row + 1;
		}
		if (row > (dimension - 1)) {
			done = true;
		}

	}

	public boolean CheckIfDone() {
		return done;
	}

	public String displaySquare() {
		String output = "";
		for (int rowcounter = 0; rowcounter <= (dimension - 1); rowcounter++) {
			for (int columncounter = 0; columncounter <= (dimension - 1); columncounter++) {
				output = output + square[rowcounter][columncounter] + "\t";
			}
			output = output + "\n";
		}

		return output;
	}

	public boolean CheckIfMagic() {
		boolean magicsquare = true;
		int constant = 0, test = 0;
		// get first sum
		for (int testcounter = 0; testcounter <= (dimension - 1); testcounter++) {
			test = test + square[0][testcounter];
		}

		// check rows
		for (int rowcounter = 1; rowcounter <= (dimension - 1); rowcounter++) {
			for (int columncounter = 0; columncounter <= (dimension - 1); columncounter++) {
				constant = constant + square[rowcounter][columncounter];
			}
			if (test != constant)
				magicsquare = false;
			constant = 0;
		}

		// check columns
		for (int columncounter = 0; columncounter <= (dimension - 1); columncounter++) {
			for (int rowcounter = 0; rowcounter <= (dimension - 1); rowcounter++) {
				constant = constant + square[rowcounter][columncounter];
			}
			if (test != constant)
				magicsquare = false;
			constant = 0;
		}

		// check first diagonal
		for (int counter = 0; counter <= (dimension - 1); counter++) {
			constant = constant + square[counter][counter];
		}
		if (constant != test)
			magicsquare = false;
		constant = 0;

		// check second diagonal
		int diagonalrowcounter = 0;
		for (int columncounter = (dimension - 1); columncounter >= 0; columncounter--) {
			constant = constant + square[diagonalrowcounter][columncounter];
			diagonalrowcounter = diagonalrowcounter + 1;
		}
		if (constant != test)
			magicsquare = false;

		return magicsquare;
	}

	public int getConstant() {
		int constant = 0;
		for (int counter = 0; counter <= (dimension - 1); counter++) {
			constant = constant + square[0][counter];
		}
		return constant;
	}

	public void ClearInput() {
		done = false;
		row = 0;
		column = 0;
	}

}
