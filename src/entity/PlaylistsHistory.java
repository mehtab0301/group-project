package entity;

import java.util.ArrayList;

public class PlaylistsHistory {
    /*
    This class refers to the collection of ALL OUR generated playlists.
    This class exists for the only purpose of storing the history, and combining historical playlists together.
     */
    private final ArrayList<Playlist> generatedPlaylists;

    public PlaylistsHistory(ArrayList<Playlist> generatedPlaylists) {
        this.generatedPlaylists = generatedPlaylists;
    }

    public ArrayList<Playlist> getSongs (){
        return generatedPlaylists;
    }
}
