package game;

public class Box {

    // Create the box and associate each line with this box

    public int row;
    public int column;

    // Constructor

    public Box (int row, int column, Lines lines){
        this.row = row;
        this.column = column;

    }

    // Get the row

    public int getRow(){
        return this.row;

    }

    //Get the column

    public int getColumn(){
        return this.column;

    }

    // Get the owner of the box

    public Player getOwner(){
        return null;
    }

    // Get top line

    public Line getTopLine(){
        return null;

    }

    // Get right line

    public Line getRightLine(){
        return null;

    }

    // Get bottom line

    public Line getBottomLine(){
        return null;
    }

    // Get left line

    public Line getLeftLine(){
        return null;

    }

    // Attempt to claim a box

    public void claim (Player owner){

    }

    // Returns the label of the boxes owner
    public String toString(){
        return null;

    }

    // Two boxes are equal if the boxes have the same row, column, owner and 4 lines

    public boolean equals(Object other) {
        Box Box2 = (Box) other;
        return this.row == Box2.row && this.column == Box2.column;
    }

}
