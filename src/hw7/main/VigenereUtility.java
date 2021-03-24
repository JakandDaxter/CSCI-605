package hw7.main;

import java.io.*;

public class VigenereUtility {

    public static char encodeChar(char ch, char key){
        if(!canBeDecoded(ch)) return ch;
        return (char) (ch+getDistance(key));
    }

    public static char decodeChar(char ch, char key){
        if(!canBeDecoded(ch)) return ch;
        return (char)((ch-getDistance(key)+26)%26);
    }

    public static boolean canBeDecoded(char ch){
        return Character.isLetter(ch);
    }

    public static int getDistance(char key){
        return (Character.isUpperCase(key)) ? (int)(key-'A') : (key-'a');
    }

    public static char getKeyChar(String key,int index){
        return key.charAt(index%key.length());
    }

    public static char[] decodeLine(char[] cbuf,String key){
        for(int i=0; i<cbuf.length; i++){
            cbuf[i] = VigenereUtility.decodeChar(cbuf[i],VigenereUtility.getKeyChar(key,i));
        }
        return cbuf;
    }

    public static char[] encodeLine(char[] cbuf,String key){
        for(int i=0; i<cbuf.length; i++){
            cbuf[i] = VigenereUtility.encodeChar(cbuf[i],VigenereUtility.getKeyChar(key,i));
        }
        return cbuf;
    }

    public static void copy(Reader fileReader, Writer fileWriter){
        try {
            char[] buffer = new char[1024];
            int length;
            while ((length = fileReader.read(buffer,0,1024)) > 0) {
                fileWriter.write(buffer, 0, length);
            }
            fileReader.close();
            fileWriter.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static File getSourceFile(String sourceFile) throws VigenereException{
        File src = new File(sourceFile);
        if(!src.exists()){
            throw new VigenereException("Source does not exist: " + sourceFile);
        }
        return src;
    }

    public static File getDestinationFile(String destinationFile) throws VigenereException{
        File dest = new File(destinationFile);
        if(dest.exists()){
            dest.delete();
            try {
                dest.createNewFile();
            } catch (IOException e) {
                throw new VigenereException("Can't create destination file: " + destinationFile);
            }
        }
        return dest;
    }

    public static void decode(String sourceFile, String destinationFile, String key) throws VigenereException {
        try {
            Reader reader = new VigenereCipherReader(new FileReader(getSourceFile(sourceFile)),key);
            Writer writer = new FileWriter(getDestinationFile(destinationFile));
            copy(reader,writer);
        } catch (FileNotFoundException e) {
            throw new VigenereException("Error Occured while creating the VigenereReader");
        } catch (IOException e) {
            throw new VigenereException("can't find the destination file");
        }
    }

    public static void encode(String sourceFile, String destinationFile, String key) throws VigenereException {
        try {
            Reader reader = new FileReader(getSourceFile(sourceFile));
            Writer writer = new VigenereCipherWriter(new FileWriter(getDestinationFile(destinationFile)),key);
            copy(reader,writer);
        } catch (FileNotFoundException e) {
            throw new VigenereException("Error Occured while creating the VigenereReader");
        } catch (IOException e) {
            throw new VigenereException("can't find the destination file");
        }
    }

    public static String listFiles(String pathname, Console console, String directory) throws VigenereException {
        File directoryPath = new File(String.valueOf(pathname));

        FilenameFilter textFilefilter = (dir, name) -> {
            String lowercaseName = name.toLowerCase();
            return lowercaseName.endsWith(".txt");
        };

        //List of all the text files
        File[] filesList = directoryPath.listFiles(textFilefilter);
        console.writer().println("Listing files in " + directory + "...");

        if (filesList != null) {
            for (File file : filesList) {
                return file.getAbsolutePath();
            }
        } else {
            throw new VigenereException("Path is not a directory: " + directory);
        }

        return "";
    }
}
