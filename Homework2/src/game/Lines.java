package game;

import java.util.ArrayList;

public class Lines {

    private int rows;
    private int columns;
    private ArrayList<Line> lines;
    private Dot[][] dots;

    public Lines(int rows , int columns, Dot[][] dots) {
        this.rows = rows;
        this.columns = columns;
        this.dots = dots;
        lines = new ArrayList<>(size());
        initLines();
    }

    private void initLines(){
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
               createLine(i,j,i+1,j);
               createLine(i,j+1,i+1,j+1);
               createLine(i,j,i,j+1);
               createLine(i+1,j,i+1,j+1);
            }
        }
    }

    public void createLine(int row1,int column1, int row2, int column2){
        if(Utils.isLineValid(row1,column1,row2,column2,rows,columns)){
            lines.add(new Line(dots[row1][column1], dots[row2][column2]));
        }
    }
    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Dot[][] getDots() {
        return dots;
    }

    public void setDots(Dot[][] dots) {
        this.dots = dots;
    }

    public Line getLine(int row1, int column1, int row2, int column2){
       if(!Utils.isLineValid(row1,column1,row2,column2,rows,columns)) return null;

       for(Line line : lines){
           if(line.getFirst().getRow() == row1 && line.getFirst().getColumn() == column1
              &&
             line.getSecond().getRow() == row2 && line.getSecond().getColumn() == column2){
               return line;
           }
       }

       return null;
    }

    public int size(){
        int m = rows+1;
        int n = columns+1;
        return 2*(m*n)-m-n;
    }
}
