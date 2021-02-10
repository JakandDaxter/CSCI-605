package game;

import java.util.ArrayList;

public class Line {

    private Player owner;
    private Dot first;
    private Dot second;

    ArrayList<Box> boxes = new ArrayList<Box>();

    public final static String EMPTY= " ";
    public final static String HORI_LINE= "-";
    public final static String VERT_LINE = "|";

    public Line(Dot first, Dot second) {
        this.first = first;
        this.second = second;
        owner = Player.NONE;
    }


    public Dot getFirst() {
        return first;
    }

    public void setFirst(Dot first) {
        this.first = first;
    }

    public Dot getSecond() {
        return second;
    }

    public void setSecond(Dot second) {
        this.second = second;
    }

    public void claim(Player owner){
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (!first.equals(line.first)) return false;
        return second.equals(line.second);
    }

    @Override
    public int hashCode() {
        int result = first.hashCode();
        result = 31 * result + second.hashCode();
        return result;
    }

    public void setBox(Box box){
        boxes.add(box);
    }

    public String toString(){
        if(!hasOwner()){
            return EMPTY;
        }
        if(first.getRow() == second.getRow()){
            return HORI_LINE;
        }
        return VERT_LINE;
    }

    public ArrayList<Box> getBoxes(){
        return boxes;
    }

    public Boolean hasOwner(){
        return !owner.equals(Player.NONE);
    }

    public Player getOwner(){
        return this.owner;
    }

}

