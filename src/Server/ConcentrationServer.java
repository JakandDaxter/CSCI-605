package Server;

import game.ConcentrationGame;

import java.io.IOException;
import java.net.ServerSocket;

public class ConcentrationServer {

    private static int clientNumber=1;

    public static void main(String[] args){
        //Making sure 2 arguments are interred in command line
        if (args.length != 2) {
            System.err.println("Usage: java ConcentrationServer <port number> <Board dimension>");
            System.exit(1);
        }
        //getting the port Number
        int portNumber = Integer.parseInt(args[0]);
        //getting the boardDimension
        int boardDim = Integer.parseInt(args[1]);

        //variable to keep listening to the port
        boolean listening = true;
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Concentration server starting on port "+portNumber+" DIM "+boardDim);
            while (listening) {

                //launching a new gameboard for the client connected
                new ConcentrationGame(serverSocket.accept(),boardDim,clientNumber++).start();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
    }

}
