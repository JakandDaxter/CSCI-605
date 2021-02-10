package MyException;

public class BadLineException extends Exception{
    public BadLineException(String errorMessage){
        super(errorMessage);
    }
}
