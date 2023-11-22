package entity;

import java.util.ArrayList;

public class Playlist {

    /*
    This class refers to OUR generated playlist, which is basically a collection of songs
     */
    private final ArrayList<Song> songs;


    public Playlist(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public ArrayList<Song> getSongs (){
        return songs;
    }
}
