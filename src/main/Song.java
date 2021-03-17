package main;

public class Song implements Comparable<Song>{

    private String artist;
    private String song;

    public Song(){

    }

    public Song(String artist,String song){
        this.artist = artist;
        this.song = song;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song1 = (Song) o;

        if (artist != null ? !artist.equals(song1.artist) : song1.artist != null) return false;
        return song != null ? song.equals(song1.song) : song1.song == null;
    }

    @Override
    public int hashCode() {
        int result = artist != null ? artist.hashCode() : 0;
        result = 31 * result + (song != null ? song.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Song s) {
        return this.getSong().compareTo(s.getSong());
    }

    @Override
    public String toString() {
        return "Artist: "+ artist +", main.Song= "+song ;
    }
}
