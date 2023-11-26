package entity;

import java.util.ArrayList;

public class Playlist {

    /*
    This class refers to OUR generated playlist, which is basically a collection of songs
     */
    private final ArrayList<Song> songs;
    private final String name;

    public Playlist(ArrayList<Song> songs, String name) {
        this.songs = songs;
        this.name = name;
    }

    public ArrayList<Song> getSongs (){
        return songs;
    }

    public int getLength(){
        return songs.size();
    }
}
