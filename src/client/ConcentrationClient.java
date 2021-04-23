package client;

import common.ConcentrationProtocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ConcentrationClient {

    public static void main(String[] args){
        if (args.length != 2) {
            System.err.println(
                    "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }
        //getting hostname and port number
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);
        connectToServer(hostName,portNumber);
    }

    public static void connectToServer(String hostName,int portNumber){
        try (
                //initializing the socket and the input and output streams
                Socket socket = new Socket(hostName, portNumber);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
        ) {
            Scanner stdIn = new Scanner(System.in);
            String fromServer;

            //keep listening to responses from the server
            while ((fromServer = in.readLine()) != null) {
                //displaying response from the server to the client
                System.out.println(fromServer);
                //ending the game when the server responds with game over
                if (fromServer.equals(ConcentrationProtocol.GAME_OVER_MSG)){
                    //display server's game over message
                    System.out.println("You won!");
                    break;
                }
                //request from the client
                boolean colAndRowNotInt = false;
                do{
                    try{
                        System.out.print("> ");
                        int row = stdIn.nextInt();
                        int col = stdIn.nextInt();
                        // send reveal request to server
                        out.println(String.format(ConcentrationProtocol.REVEAL_MSG,row,col));

                    }catch (Exception e){
                        System.out.println("Enter integer values only");
                        colAndRowNotInt = true;
                    }
                }while(colAndRowNotInt);
            }

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        }
    }
}
