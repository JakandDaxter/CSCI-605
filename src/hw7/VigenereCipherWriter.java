package hw7;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class VigenereCipherWriter extends Writer {

    private String filename;

    public VigenereCipherWriter(String filename) {
        super(filename);
        this.filename = filename;
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws VigenereException {
        try {
            Writer w = new FileWriter("output.txt");
            String content = "I love my country";
            w.write(content);
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void flush() throws VigenereException {

    }

    @Override
    public void close() throws VigenereException {

    }
}
