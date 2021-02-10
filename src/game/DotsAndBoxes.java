package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DotsAndBoxes {

    public String PROMPT = "Enter Coordinates for your Move";


    GameBoard gameBoard;

    public DotsAndBoxes(int rows, int columns) {
        gameBoard =  new GameBoard(rows,columns);
    }

    //prompts the user for the coordinates to put the line down on the grid
    public Boolean MakeMove(int row, int column){
        //we are going to take it in as a string but have
        // to make it a int array later for make move in game board
        Scanner scan = new Scanner(System.in);
        int valid = 0;
        String[] coordinatesString;
        int[] coordinates;
        System.out.println(this.PROMPT);
        List<Integer> list = new ArrayList<>();
        coordinatesString = scan.nextLine().split(" ");
        //check if given coordinates are valid
        // pass to Gameboard
        //have to know which lines have been taken
        //but for right now just know if the coordinates are valid
        if(valid == 1)
        {return true;}
        else{return false;}
    }

    //this is the game loop
    //the user will be in this loop until someone wins the game
    public static void play(){


    }

    //program asks user for grid size here
    public static void main(String[] args) {
        int row = 0, column = 0;
        boolean check = true;
        String dummycheck;
        Scanner scan = new Scanner(System.in);
        System.out.println("Dots and Boxes\n\n\n\n");
        System.out.println("Please Enter Rows by Columns Grid Size\n\n\n");
        do {
            System.out.print("Enter Row: ");
            while (!scan.hasNextInt()) {
                dummycheck = scan.next();
                System.out.println(dummycheck + " Is not a valid input, Please Enter a valid input");
            }
            row = scan.nextInt();
            if (row >0) {
                check = false;
            }
        } while (check);

        do {
            System.out.print("Enter Column: ");
            while (!scan.hasNextInt()) {
                dummycheck = scan.next();
                System.out.println(dummycheck + " Is not a valid input, Please Enter a valid input");
            }
                column = scan.nextInt();
            if (column >0) {
                check = false;
            }
            }while (check);

            new DotsAndBoxes(row, column);
        }
    }

