package hw7.main;

public interface Vigenerecipherdecoding{

    int read(char[] cbuf, int off, int len) throws VigenereException;
    void close() throws VigenereException;
}
