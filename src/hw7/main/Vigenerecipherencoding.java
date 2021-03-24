package hw7.main;

public interface Vigenerecipherencoding{

    void write(char[] cbuf, int off, int len) throws VigenereException;
    void flush() throws VigenereException;
    void close() throws VigenereException;
}
