package hw7;

import java.io.Console;
import java.io.File;
import java.util.Scanner;


import static java.lang.System.exit;

public class VigenereCipher {

    VigenereUtility util;

    public static void main(String[] args){

        Console console = System.console();

        if(console != null){
            console.writer().println("Welcome to the Vigenere Cipher!");
            do{
            Scanner scanner = new Scanner(console.reader());
            String option = scanner.nextLine();
            String[] splited = option.split("\\s+");
                switch (splited[0]) {
                    case "help" -> console.writer().println(""" 
                            Enter one of the following commands:                           
                              list <directory> - lists the files in the specified directory
                              encode <key> <input-file> <output-file> - encode the input file into the output file using the key indicated.
                              decode <key> <input-file> <output-file> - decode the input file into the output file using the key indicated.
                              quit - quits the Vigenere Cipher.""");
                    case "list" -> {
                        StringBuilder sb = new StringBuilder("/Users/MS1/Documents/CSCI Homeworks/Homework 7/src/hw7/");
                        try {
                            sb.append(splited[1]);
                            for (File file : VigenereUtility.listFiles(String.valueOf(sb), console, splited[1])) {
                                console.writer().println(" "+ file.getAbsolutePath());
                            }
                        } catch (ArrayIndexOutOfBoundsException | VigenereException e) {
                            console.writer().println("Error processing most recent command!");
                        }
                    }
                    case "encode" -> VigenereUtility.encode(splited[1], splited[2], splited[3]);
                    case "decode" -> VigenereUtility.decode(splited[1], splited[2], splited[3]);
                    case "quit" -> {
                        console.writer().println("Quitting...");
                        exit(0);
                    }
                    default -> console.writer().println("Error processing most recent command!");
                }
        }while(true);
        }
        else{
            System.out.println("Please Run In Console....");
        }
    }
}
