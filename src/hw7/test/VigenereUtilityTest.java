package hw7.test;

import hw7.main.VigenereUtility;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VigenereUtilityTest {

    private final static String DECODED_STRING = "ATTACKAT DAWN";
    private final static String key = "LEMON";
    private final static String ENCODED_STRING =  "LXFOPVEF RNHR";

    @Test
    public void decodeChar(){
        assertEquals(VigenereUtility.decodeChar(ENCODED_STRING.charAt(0),key.charAt(0)),'A');
    }

    @Test
    public void encodeChar(){
        assertEquals(VigenereUtility.encodeChar(DECODED_STRING.charAt(0),key.charAt(0)),'L');
    }

    @Test
    public void canBeDecoded(){
        assertTrue(!VigenereUtility.canBeDecoded('1'));
        assertTrue(VigenereUtility.canBeDecoded('a'));
        assertTrue(VigenereUtility.canBeDecoded('A'));
    }

    @Test
    public void getDistance(){
        assertEquals(VigenereUtility.getDistance('A'),0);
        assertEquals(VigenereUtility.getDistance('D'),3);
        assertEquals(VigenereUtility.getDistance('L'),11);
        assertEquals(VigenereUtility.getDistance('a'),0);
        assertEquals(VigenereUtility.getDistance('d'),3);
        assertEquals(VigenereUtility.getDistance('l'),11);
    }

    @Test
    public void getKeyChar(){
        assertEquals(VigenereUtility.getKeyChar(key,0),'L');
        assertEquals(VigenereUtility.getKeyChar(key,7),'M');
        assertEquals(VigenereUtility.getKeyChar(key,9),'N');
    }

    @Test
    public void decodeLine(){
        char[] c = ENCODED_STRING.toCharArray();
        char[] c1 = DECODED_STRING.toCharArray();
        assertEquals(VigenereUtility.decodeLine(c,key),c1);
    }

    @Test
    public void encodeLine(){
        char[] c = DECODED_STRING.toCharArray();
        char[] c1 = ENCODED_STRING.toCharArray();
        assertEquals(VigenereUtility.encodeLine(c,key),c1);
    }
}
