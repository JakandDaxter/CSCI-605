package game;

import java.util.ArrayList;

public class Lines {

    public int rows;
    public int columns;
    public Dot[][] dots;
    ArrayList<Line> lines = new ArrayList<>();

    // Constructor

    public Lines (int rows, int columns, Dot[][] dots){
        this.rows = rows;
        this.columns = columns;

        }

    }

    public Line getLine (int row1, int column1, int row2, int column2){
        return null;
    }

    public int size(){
        int i = this.rows;
        int j = this.columns;
        int allLines = (2 * (i * j) - i - j);
        return allLines;
    }
}
