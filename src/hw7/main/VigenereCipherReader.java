package hw7.main;

import java.io.IOException;
import java.io.Reader;

public class VigenereCipherReader extends Reader implements Vigenerecipherdecoding {

    private Reader baseReader;
    private String key;

    public VigenereCipherReader(Reader baseReader, String key) {
        super();
        this.baseReader = baseReader;
        this.key = key;
    }

    @Override
    public int read(char[] cbuf, int off, int len) {
        try {
            return baseReader.read(VigenereUtility.decodeLine(cbuf,key),off,len);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void close(){
        this.close();
    }
}
