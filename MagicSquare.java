package magicsquare;

public class MagicSquare {
	private int[][] square;
	private int dimension;
	private int row=0,column=0;
	private boolean done = false;
	
	public void setDimension(int dim) {
		square = new int[dim][dim];
		dimension = dim;
	}

	public boolean CheckDimension(int dim) {
		boolean error=false;
		if(dim < 2) error = true;
		if(dim>8) error = true;
		return error;
	}
	
	public void setValue(int input) {
		 
		if (row <=(dimension-1) && column <=(dimension-1)) {
			 square[row][column] = input;
		 }
		 column = column +1;
		 if(column> (dimension-1)) {
			 column=0;
			 row = row +1;
			 }
		 if(row >(dimension-1)) {
			 done = true;
		 }
			
	}
	
	public boolean CheckIfDone() {
		return done;
	}
	
/*	public String nextValue() {
		String label="";
		for(int counter1=0; counter1<=(dimension-1);counter1++) {
			for(int counter2=0; counter2<=(dimension-1); counter2++) {
				label = "Please enter the value for row " + row + " column " + column + ":";
				column = column + 1;
			}
			row = row+1;
		}
		return label;
	}*/


}
