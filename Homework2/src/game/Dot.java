package game;

import MyException.DotException;

public class Dot {


    public final static String DOT = ".";

    // Represents a single dot in the game

    private int row;
    private int column;

    //Constructor
    public Dot (int row, int column){

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dot dot = (Dot) o;

        if (row != dot.row) return false;
        return column == dot.column;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + column;
        return result;
    }
}
