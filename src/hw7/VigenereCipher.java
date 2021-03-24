package hw7;

import java.io.Console;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

import static java.lang.System.exit;

public class VigenereCipher {
    public static void main(String[] args){
        Console console = System.console();
        if(console != null){
            console.writer().println("Welcome to the Vigenere Cipher!");
            do{
            Scanner scanner = new Scanner(console.reader());
            String option = scanner.nextLine();
            String[] splited = option.split("\\s+");
            switch(splited[0]) {
                case "help":
                    console.writer().println(""" 
                              Enter one of the following commands:                           
                                list <directory> - lists the files in the specified directory
                                encode <key> <input-file> <output-file> - encode the input file into the output file using the key indicated.
                                decode <key> <input-file> <output-file> - decode the input file into the output file using the key indicated.
                                quit - quits the Vigenere Cipher.""");
                    break;
                case "list":
                    StringBuilder sb=new StringBuilder("/Users/MS1/Documents/CSCI Homeworks/Homework 7/src/hw7/");
                    try{
                        sb.append(splited[1]);
                        File directoryPath = new File(String.valueOf(sb));
                        FilenameFilter textFilefilter = (dir, name) -> {
                            String lowercaseName = name.toLowerCase();
                            return lowercaseName.endsWith(".txt");
                        };
                        //List of all the text files
                        File[] filesList = directoryPath.listFiles(textFilefilter);
                        try{
                            console.writer().println("Listing files in "+ splited[1] +"...");
                            assert filesList != null;
                            for(File file : filesList) {
                                console.writer().println("\t"+file.getAbsolutePath());
                            }
                        }catch(NullPointerException e){
                            console.writer().println("Path is not a directory: " + splited[1]);
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        console.writer().println("Error processing most recent command!");
                    }
                    break;
                case "encode":
                    break;
                case "decode":
                    break;
                case "quit":
                    console.writer().println("Quitting...");
                    exit(0);
                    break;
                default:
                    console.writer().println("Error processing most recent command!");
                    break;
            }
        }while(true);
        }
        else{
            System.out.println("Please Run In Console....");
        }
    }
}
