package test;


import main.Song;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class SongTest {

    Song song;
    static final String ARTIST = "Aliana";
    static final String SONG = "Happy New year";
    static final String ARTIST1 = "Sewa";
    static final String SONG1 = "Silent Night";

    @Before
    public void init() {
        song = new Song(ARTIST,SONG);
    }

    @Test
    public void testEquals(){
        Song newSong = new Song(ARTIST,SONG);
        assertEquals(song,newSong);
    }

    @Test
    public void testCompare(){
        Song newSong = new Song(ARTIST1,SONG1);
        int compare = song.compareTo(newSong);
        assertTrue(compare<0);
    }
}
