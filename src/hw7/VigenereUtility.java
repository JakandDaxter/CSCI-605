package hw7;

public class VigenereUtility {

    public static char getCodedChar(char ch, char key){
        if(!canBeDecoded(ch)) return ch;
        return (char) (ch+getDistance(key));
    }

    public static char getDecodedChar(char ch, char key){
        if(!canBeDecoded(ch)) return ch;
        return (char)((ch-getDistance(key)+26)%26);
    }

    public static boolean canBeDecoded(char ch){
        return Character.isLetter(ch);
    }

    public static int getDistance(char key){
        return (Character.isUpperCase(key)) ? (int)(key-'A') : (key-'a');
    }
}
