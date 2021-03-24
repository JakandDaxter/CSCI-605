package hw7.main;

import java.io.IOException;
import java.io.Writer;

public class VigenereCipherWriter extends Writer implements Vigenerecipherencoding {

    private Writer baseWriter;
    private String key;

    public VigenereCipherWriter(Writer baseWriter,String key) {
        this.baseWriter = baseWriter;
        this.key = key;
    }

    @Override
    public void write(char[] cbuf, int off, int len) {
        try {
            baseWriter.write(VigenereUtility.encodeLine(cbuf,key),off,len);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void flush() {
        try {
            baseWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            baseWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
