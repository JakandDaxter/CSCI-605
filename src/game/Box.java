package game;

public class Box {

    private Player owner = Player.NONE;
    private int row;
    private int column;
    private Lines lines;

    public Box(int row, int column, Lines lines) {
        this.row = row;
        this.column = column;
        this.lines = lines;
    }

    public void claim(Player owner){
        if(!allLinesHasOwner()) return;
        this.owner = owner;
    }

    public Player getOwner(){
        return this.owner;
    }

    //getter and setters
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Lines getLines() {
        return lines;
    }

    public void setLines(Lines lines) {
        this.lines = lines;
    }

    public Line getLeftLine(){
        return lines.getLine(row,column,row+1,column);
    }

    public Line getRightLine(){
        return lines.getLine(row,column+1,row+1,column+1);
    }

    public Line getTopLine(){
        return lines.getLine(row,column,row,column+1);
    }
    public Line getBottomLine(){
        return lines.getLine(row+1,column,row+1,column+1);
    }

    public boolean allLinesHasOwner(){
        return getTopLine().hasOwner() &&
               getRightLine().hasOwner() &&
               getBottomLine().hasOwner() &&
               getLeftLine().hasOwner();
    }

    public String toString(){
        return owner.getLabel();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Box box = (Box) o;

        if (row != box.row) return false;
        if (column != box.column) return false;
        if (owner != box.owner) return false;
        return lines.equals(box.lines);
    }

    @Override
    public int hashCode() {
        int result = owner.hashCode();
        result = 31 * result + row;
        result = 31 * result + column;
        result = 31 * result + lines.hashCode();
        return result;
    }
}
