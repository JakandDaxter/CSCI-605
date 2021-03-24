package testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.Test;

/**
  the purpose of this class is to test if the program works as expected
 the class takes the expected encryption and compared it to the encryption producted by the program
    basically comparing the files in "test" and in "Compare"
 **/

public class Comparator {

    //****Testing AliceChapter1***\\
    @Test
    public void testAliceChapter1() throws FileNotFoundException{
        try{
            Scanner file1 = new Scanner(new FileInputStream("/Users/MS1/Documents/CSCI Homeworks/Homework 7/src/hw7/Compare/AliceChapter1.rabbit.txt"));
            Scanner file2 = new Scanner(new FileInputStream("/Users/MS1/Documents/CSCI Homeworks/Homework 7/src/hw7/test/AliceChapter1.rabbit.txt"));

            int line = 0;

            while(file1.hasNext() && file2.hasNext()) {
                String line1 = file1.nextLine().trim();
                String line2 = file2.nextLine().trim();

                if(!line1.equals(line2)) {
                    System.err.println("Found mismatch on line " + line);
                    System.err.println("  expected: >" + line1 + "<");
                    System.err.println("  actual:   >" + line2 + "<");
                    System.exit(1);
                }
                line++;
            }

            System.out.println("Matched " + line + " lines.");

            if(file1.hasNext()) {
                System.out.println("File 2 ended before File 1.");
            }
            else if(file2.hasNext()) {
                System.out.println("File 1 ended before File 2.");
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File Not Located At Specified Path");
        }
    }

    //****Testing AliceInWonderland***\\
    @Test
    public void testAliceInWonderland() throws FileNotFoundException{
        try{
            Scanner file1 = new Scanner(new FileInputStream("/Users/MS1/Documents/CSCI Homeworks/Homework 7/src/hw7/Compare/AliceInWonderland.caterpillar.txt"));
            Scanner file2 = new Scanner(new FileInputStream("/Users/MS1/Documents/CSCI Homeworks/Homework 7/src/hw7/test/AliceInWonderland.caterpillar.txt"));

            int line = 0;

            while(file1.hasNext() && file2.hasNext()) {
                String line1 = file1.nextLine().trim();
                String line2 = file2.nextLine().trim();

                if(!line1.equals(line2)) {
                    System.err.println("Found mismatch on line " + line);
                    System.err.println("  expected: >" + line1 + "<");
                    System.err.println("  actual:   >" + line2 + "<");
                    System.exit(1);
                }
                line++;
            }

            System.out.println("Matched " + line + " lines.");

            if(file1.hasNext()) {
                System.out.println("File 2 ended before File 1.");
            }
            else if(file2.hasNext()) {
                System.out.println("File 1 ended before File 2.");
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File Not Located At Specified Path");
        }
    }

    //****Testing Condition***\\
    @Test
    public void testkublakhan() throws FileNotFoundException{
        try{
            Scanner file1 = new Scanner(new FileInputStream("/Users/MS1/Documents/CSCI Homeworks/Homework 7/src/hw7/Compare/kublakhan.opium.txt"));
            Scanner file2 = new Scanner(new FileInputStream("/Users/MS1/Documents/CSCI Homeworks/Homework 7/src/hw7/test/kublakhan.opium.txt"));


            int line = 0;

            while(file1.hasNext() && file2.hasNext()) {
                String line1 = file1.nextLine().trim();
                String line2 = file2.nextLine().trim();

                if(!line1.equals(line2)) {
                    System.err.println("Found mismatch on line " + line);
                    System.err.println("  expected: >" + line1 + "<");
                    System.err.println("  actual:   >" + line2 + "<");
                    System.exit(1);
                }
                line++;
            }

            System.out.println("Matched " + line + " lines.");

            if(file1.hasNext()) {
                System.out.println("File 2 ended before File 1.");
            }
            else if(file2.hasNext()) {
                System.out.println("File 1 ended before File 2.");
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File Not Located At Specified Path");
        }
    }

    //****Testing sample_writeup***\\
    @Test
    public void testsample_writeup() throws FileNotFoundException{
        try{

            Scanner file1 = new Scanner(new FileInputStream("/Users/MS1/Documents/CSCI Homeworks/Homework 7/src/hw7/Compare/sample_writeup.Lincoln.txt"));
            Scanner file2 = new Scanner(new FileInputStream("/Users/MS1/Documents/CSCI Homeworks/Homework 7/src/hw7/test/sample_writeup.Lincoln.txt"));

            int line = 0;

            while(file1.hasNext() && file2.hasNext()) {
                String line1 = file1.nextLine().trim();
                String line2 = file2.nextLine().trim();

                if(!line1.equals(line2)) {
                    System.err.println("Found mismatch on line " + line);
                    System.err.println("  expected: >" + line1 + "<");
                    System.err.println("  actual:   >" + line2 + "<");
                    System.exit(1);
                }
                line++;
            }

            System.out.println("Matched " + line + " lines.");

            if(file1.hasNext()) {
                System.out.println("File 2 ended before File 1.");
            }
            else if(file2.hasNext()) {
                System.out.println("File 1 ended before File 2.");
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File Not Located At Specified Path");
        }
    }

}

