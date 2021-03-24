import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        //Creating a File object for directory
        File directoryPath = new File("/Users/MS1/Documents/CSCI Homeworks/Homework 7/src/hw7/data");
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
    }
}

