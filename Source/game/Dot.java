package game;

public class Dot {

	public String DOT = ".";
	
	// Represents a single dot in the game 
	
	public int row;
	public int column;
	
	//Constructor
	
	Dot (int row, int column) {
		assert row >= 0 && column >= 0;
		this.row = row;
		this.column = column;
	}
	
	//Get the row
	
	public int getRow() {
		return this.row;
	}
	
	// Get the column
	
	public int getColumn() {
		return this.column;
		
	}
	
	// Return the string representation of a dot
	
	public String toString() {
		return DOT;	
	}
	
	// Two dots are equal if they have the same row and column
	
	public boolean equals(Object other) {
		Dot Dot2 = (Dot) other;
		return this.row == Dot2.row && this.column == Dot2.column;
	}
	public static void main (String[] arg) {
		System.out.println("Hello World");
	}
}