package data_access;

import entity.Song;

import java.util.ArrayList;

public class PlaylistAccess {
    private ArrayList<Song> songs = new ArrayList<>();
    public void Playlist(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public ArrayList<Song> getSongs (){
        return songs;
    }

    public int getLength(){
        return songs.size();
    }
}
