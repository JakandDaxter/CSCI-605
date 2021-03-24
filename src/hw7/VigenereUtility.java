package hw7;

import java.io.Console;
import java.io.File;
import java.io.FilenameFilter;

public final class VigenereUtility {

    public static File[] listFiles(String pathname, Console console, String directory) throws VigenereException {
        File directoryPath = new File(String.valueOf(pathname));

        FilenameFilter textFilefilter = (dir, name) -> {
            String lowercaseName = name.toLowerCase();
            return lowercaseName.endsWith(".txt");
        };

        //List of all the text files
        File[] filesList = directoryPath.listFiles(textFilefilter);
        console.writer().println("Listing files in " + directory + "...");

        if (filesList != null) {
                return filesList;
        } else {
            throw new VigenereException("Path is not a directory: " + directory);
        }

    }

    public static void encode(String keyword, String targetPath, String destinationPath){

    }

    public static void decode(String keyword, String targetPath, String destinationPath){

    }
}
