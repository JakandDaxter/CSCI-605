package game;

import common.ConcentrationException;
import common.ConcentrationProtocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ConcentrationGame extends Thread {

    private Socket socket = null;
    private int boardDimension;
    private ConcentrationBoard board;
    private int clientNumber;

    public ConcentrationGame(Socket socket, int boardDimension, int clientNumber){
        super("ConcentrationGame");
        this.socket = socket;
        this.boardDimension = boardDimension;
        this.clientNumber = clientNumber;
    }

    public void run() {
        try (
                //Initializing the input and output streams
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            try {
                //Initializing the game
                System.out.println("Client #"+clientNumber+" : Client "+clientNumber+" connected: Socket[addr="+
                        socket.getInetAddress()+",port="+socket.getPort()+",localport="+socket.getLocalPort());

                //logging solution
                System.out.println(new ConcentrationBoard(boardDimension,true).toString());

                //Initializing the client's game with the dimension
                System.out.println("Client #"+clientNumber+": Client started...");
                board = new ConcentrationBoard(boardDimension);
                //Sending the board's dimension to the client
                out.println(String.format(ConcentrationProtocol.BOARD_DIM_MSG,this.boardDimension));
                //initializing an input and output String
                String inputLine, outputLine;

                //Keep the stream between the client and the server
                while ((inputLine = in.readLine()) != null) {
                    //log client request
                    System.out.println("Client #"+clientNumber+": received: "+inputLine);

                    //process the client request
                    outputLine = this.processRequest(inputLine);

                    if(outputLine.equals(ConcentrationProtocol.GAME_OVER_MSG)){
                        out.println(outputLine);
                        break;
                    }

                    //log server response
                    System.out.println("Client #"+clientNumber+": sending: "+outputLine);

                    //log board state
                    System.out.println("Client #"+clientNumber);
                    System.out.println(board.toString());
                    //sent the output to the client
                    out.println(outputLine);
                    //if the game is over, stop the stream between the client
                }
                //client ending
                System.out.println("Client #"+clientNumber+": Client ending...");
                //close the socket
                socket.close();

            } catch (ConcentrationException e) {
                //log server response
                System.out.println("Client #"+clientNumber+": sending: "+e.getMessage());
                out.println(e.getMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String processRequest(String request){
        //making sure the the protocol is respected
        if(request.startsWith(ConcentrationProtocol.REVEAL)){
            try {
                //check if the game is not over yet.
                if (board.gameOver()) {
                    return ConcentrationProtocol.GAME_OVER;
                }

                //getting row and column from the request
                String numberOnly= request.replaceAll("[^0-9]", "");
                int row = (int)(numberOnly.charAt(0)-'0');
                int col = (int)(numberOnly.charAt(1)-'0');

                //getting the match
                ConcentrationBoard.CardMatch match = board.reveal(row,col);
                //return response to the client based on the match
                if(!match.isReady()){
                    return String.format(ConcentrationProtocol.CARD_MSG,row,col,this.board.getCard(row,col).getLetter());
                }else if(match.isMatch()){
                    return String.format(ConcentrationProtocol.MATCH_MSG,
                            match.getCard1().getRow(),match.getCard1().getCol(),
                            match.getCard2().getRow(),match.getCard2().getCol());
                }else{
                    return String.format(ConcentrationProtocol.MISMATCH_MSG,
                            match.getCard1().getRow(),match.getCard1().getCol(),
                            match.getCard2().getRow(),match.getCard2().getCol());
                }
            } catch (ConcentrationException e) {
                //return the exception message in case there is an exception
                return e.getMessage();
            } catch (Exception e){
                return String.format(ConcentrationProtocol.ERROR_MSG," Cannot process request");
            }
        }
        return null;
    }
}
