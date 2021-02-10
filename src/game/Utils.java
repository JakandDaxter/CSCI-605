package game;

public class Utils {

    public static boolean isDotValid(Dot dot,int rows, int columns){
        return dot.getRow()>=0 && dot.getRow()<=rows
               &&
               dot.getColumn()>=0 && dot.getColumn()<=columns;
    }

    public static boolean isDotValid(int row, int column,int rows, int columns){
        return row>=0 && row<=rows
                &&
                column>=0 && column<=columns;
    }

    public static boolean isLineValid(Dot first, Dot second,int rows, int columns){
        if(!isDotValid(first,rows,columns)||!isDotValid(second,rows,columns)){
            return false;
        }
        return ((first.getRow() == second.getRow()) && (first.getColumn() == second.getColumn() - 1)
                ||
                (first.getRow() == second.getRow() -1) && (first.getColumn() == second.getColumn()));
    }

    public static boolean isLineValid(int row1, int column1,int row2, int column2,int rows, int columns){
        if(!isDotValid(row1,column1,rows,columns)||!isDotValid(row2,column2,rows,columns)){
            return false;
        }
        return ((row1 == row2) && (column1 == column2 - 1)
                ||
                (row1 == row2 -1) && (column1 == column2));
    }

}
