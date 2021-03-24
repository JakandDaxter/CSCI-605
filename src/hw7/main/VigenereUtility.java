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
}
