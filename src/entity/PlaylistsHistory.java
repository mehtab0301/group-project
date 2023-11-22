package entity;

import data_access.PlaylistHistoryAccess;

import java.util.ArrayList;

public class PlaylistsHistory {
    /*
    This class refers to the collection of ALL OUR generated playlists.
    This class exists for the only purpose of storing the history, and combining historical playlists together.
     */
    private static ArrayList<Playlist> generatedPlaylists = new ArrayList<>();

    public PlaylistsHistory(ArrayList<Playlist> generatedPlaylists) {
        PlaylistsHistory.generatedPlaylists = generatedPlaylists;
    }


    public static ArrayList<Playlist> getPlaylists(){
        return generatedPlaylists;
    }

    public static void setHistory(ArrayList<Playlist> playlists){
        generatedPlaylists = playlists;
    }
}
