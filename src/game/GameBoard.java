package game;

public class GameBoard {

    private int rows;
    private  int columns;
    private int redScore;
    private int blueScore;
    private Player player;
    private Lines lines;
    private Dot[][] dots;
    private Box[][] boxes;
    private int moves;

    public GameBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        initBoard(rows,columns);
    }

    public void initBoard(int rows, int columns){

        player = Player.NONE;
        dots = new Dot[rows][columns];

        for(int i = 0 ; i<=rows; i++){
            for(int j=0; j<=columns; j++){
                dots[i][j] = new Dot(i,j);
            }
        }

        lines = new Lines(rows,columns,dots);

        for(int i = 0 ; i<rows; i++){
            for(int j=0; j<columns; j++){

                Box newBox = new Box(i,j,lines);
                boxes[i][j] = newBox;
                lines.getLine(i,j,i+1,j).setBox(newBox);
                lines.getLine(i,j+1,i+1,j+1).setBox(newBox);
                lines.getLine(i,j,i,j+1).setBox(newBox);
                lines.getLine(i+1,j,i+1,j+1).setBox(newBox);
            }
        }
    }

    public boolean hasMoveClaimedBox(Line line){
        boolean isBoxClaimed = false;
        for(Box box : line.boxes){
            if(box.allLinesHasOwner()){
                box.claim(player);
                isBoxClaimed = true;
            }
        }
        return isBoxClaimed;
    }

    public void makeMove(int row1, int column1 , int row2 , int column2){
        if(isLineValid(row1,column1,row2,column2)){
            Line line = lines.getLine(row1,column1,row2,column2);
            if(!line.hasOwner()) {
                line.claim(player);
                moves++;
                if(!hasMoveClaimedBox(line)){
                    changePlayer();
                }
            }
        }
    }

    public void changePlayer(){
        if(player.equals(Player.NONE) || player.equals(Player.BLUE)){
            player = Player.RED;
        }
        player = Player.BLUE;
    }

    public Player whoseTurn(){
        return player;
    }

    public boolean gameOver(){
        return lines.size() == moves;
    }

    public boolean isLineValid(int row1, int column1, int row2, int column2){
        return Utils.isLineValid(row1,column1,row2,column2,rows,columns);
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

}
