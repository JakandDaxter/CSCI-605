package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Jukebox {

    //ArrayList to contains all the songs
    static ArrayList<Song> listOfSongs = new ArrayList<>();
    //HashMap to handle played songs per frequency and also keeping track of added songs
    static HashMap<Song,Integer> songPlayed = new HashMap<>();
    //HashMap That keeps track of every artist and their songs
    static HashMap<String, PriorityQueue<Song>> artistSongs = new HashMap<>();
    //Keep the first five songs played
    static Song[] first5Played = new Song[5];
    //Random generator
    static Random random = new Random();
    //Random seed
    static int seed;
    //total list of songs
    static int totalSongsPlayed=0;

    //keeping track of the non duplicate songs played
    static int nonDuplicateCount = 0;
    //keeping track of duplicate songs played
    static int duplicateCount=0;
    //Keeping track of most played song
    static Song mostPlayedSong;
    //keeping track of most played song's frequency
    static int mostPlayedSongFrequency = 0;
    //Keeping track of simulation duration
    static long simulationDuration = 0;

    //The number of times to run simulation
    static final int NUMBER_TIMES_RUN = 50000;
    //The String used as a splitter for the lines in the files
    static final String SPLITTER = "<SEP>";

    public static void main(String[] args){
        //Get the file name from the command line
        String fileName = args[0];
        try{
            //Trying to parse the seed into integer
            seed = Integer.parseInt(args[1]);
        }catch (NumberFormatException e){
            //Return and error in case the parsing throws an exception
            System.out.println("Usage: java Jukebox filename seed");
        }
        //loading the songs
        loadSongs(fileName);
        //Running the simulation
        runSimulation();
        //Display the statistics
        displayStatistics();
    }

    public static void runSimulation(){
        long startTime = System.currentTimeMillis();
        //declaring a local variable to keep trac of the iterator
        int i = 0;
        //do a while loop 50000 times
        while(i<NUMBER_TIMES_RUN){
            //Getting a random index
            int randomIndex = getRandomNumber();
            //Play the music
            playSong(randomIndex);

            i++;
        }
        simulationDuration = System.currentTimeMillis()-startTime;
    }

    public static void playSong(int randomIndex){
        //Getting the song to play
        Song song = listOfSongs.get(randomIndex);
        //getting this song's old frequency and increasing it by 1
        int freq = songPlayed.get(song)+1;
        //if the frequency is greater than 1 then it's a duplicate
        if(freq > 1){
            //update the duplicateCount
            duplicateCount++;
        }else{
            //update the non duplicateCount
            nonDuplicateCount ++;
        }
        //update most played song
        if(mostPlayedSongFrequency<freq){
            //Updating most payed song frequency
            mostPlayedSongFrequency = freq;
            //update most played song
            mostPlayedSong = song;
        }
        //increase this song's played frequency number
        songPlayed.put(song,freq);
        //add songs to first 5 played if possible
        if(totalSongsPlayed<5){
            first5Played[totalSongsPlayed] = song;
        }
        //increase the totalNumber of song played
        totalSongsPlayed++;
    }

    public static void loadSongs(String fileName){
        //Reading the file in a buffer
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            //Reading the file line by line
            while ((line = br.readLine()) != null) {
                //splitting the line into an array
                String[] arr = line.split(SPLITTER,4);
                //Getting the artist
                String artist = arr[2];
                //Getting the song
                String song = arr[3];
                //Creating a new song to be inserted into the
                Song s = new Song(artist,song);
                //Checking if the current song was al
                if(!songPlayed.containsKey(s)){
                    //inserting the song in the map in order to keep track
                    addSongToList(s);
                }
            }
        } catch (IOException e) {
            //Print error in case the file cannot be processed
            System.out.println("File not found");
        }
    }

    public static void addSongToList(Song song){
        //add song to the list of songs
        listOfSongs.add(song);
        //addSong to to the map of played songs
        songPlayed.put(song,0);
        //map artist with songs;
        PriorityQueue<Song> PriorityQueue = artistSongs.getOrDefault(song.getArtist(),new PriorityQueue<>());
        //adding the song to the artist songs
        PriorityQueue.offer(song);
        //updating the list of songs in the map
        artistSongs.put(song.getArtist(),PriorityQueue);
    }

    public static int getRandomNumber(){
        //Getting the next random number bet
        return random.nextInt(listOfSongs.size()-seed)+seed;
    }

    public static void displayStatistics(){

        System.out.println("JukeboxTest of "+listOfSongs.size()+" songs starts rockin'...");
        System.out.println("Printing first 5 songs played...");
        //Displaying the first 5 songs
        for(Song s : first5Played){
            System.out.println("\t "+s.toString());
        }
        //Displaying the duration of simulation
        System.out.println("Simulation took "+simulationDuration/1000+" second/s");
        //Displaying the number of simulation
        System.out.println("Number of simulations run: "+NUMBER_TIMES_RUN);
        //Total number of songs played
        System.out.println("Total number of songs played: "+totalSongsPlayed);
        //Total number of songs played
        System.out.println("Average number of songs played per simulation to get duplicate: "+nonDuplicateCount/duplicateCount);
        //MostPlayed main.Song
        System.out.println("Most played song: "+ "\""+mostPlayedSong.getSong()+"\" By \""+mostPlayedSong.getArtist()+"\"");
        //Displaying all songs played by the most played song's artist
        System.out.println("All songs alphabetically by \""+mostPlayedSong.getArtist()+"\":");
        //getting the songs of the artist
        PriorityQueue<Song> mostPlayedArtistSongs= artistSongs.get(mostPlayedSong.getArtist());
        //Loop through the songs
        while(!mostPlayedArtistSongs.isEmpty()){
            //remove the one on top
            Song currSong = mostPlayedArtistSongs.poll();
            //Get the number of times it was played
            int frequency= songPlayed.get(currSong);
            //Displaying the song with the number of times it was played
            System.out.println("\t \""+mostPlayedSong.getSong()+"\" with "+frequency+" plays");
        }
    }
}
