package hw7.main;

import java.io.Console;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

public class VigenereCipher {
    public static void main(String[] args) throws IOException{
        Console console = System.console();
        if(console != null){
            console.writer().println("Welcome to the Vigenere Cipher!");
            do{
            Scanner scanner = new Scanner(console.reader());
            String option = scanner.nextLine();
            switch(option) {
                case "help":
                 /*   console.writer().println("""
                              Enter one of the following commands:                           
                                list <directory> - lists the files in the specified directory
                                encode <key> <input-file> <output-file> - encode the input file into the output file using the key indicated.
                                decode <key> <input-file> <output-file> - decode the input file into the output file using the key indicated.
                                quit - quits the Vigenere Cipher.""");*/
                    break;
                case "list":
                    File directoryPath = new File("D:/Users/MS1/Documents/CSCI Homeworks/Homework 7/provided_files/data");
                    FilenameFilter textFilefilter = new FilenameFilter(){
                        public boolean accept(File dir, String name) {
                            String lowercaseName = name.toLowerCase();
                            if (lowercaseName.endsWith(".txt")) {
                                return true;
                            } else {
                                return false;
                            }
                        }
                    };
                    //List of all the text files
                    String filesList[] = directoryPath.list(textFilefilter);
                    System.out.println("List of the text files in the specified directory:");
                    for(String fileName : filesList) {
                        System.out.println(fileName);
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
                    console.writer().println("Please Choose From Allowed Commands");
                    break;
            }
        }while(true);
        }
        else{
            System.out.println("Please Run In Console....");
        }
    }
}
