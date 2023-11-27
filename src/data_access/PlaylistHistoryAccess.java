package data_access;

import entity.Playlist;

import java.util.ArrayList;

public class PlaylistHistoryAccess {

    private static ArrayList<Playlist> generatedPlaylists = new ArrayList<>();

    public void addToHistory(Playlist playlist) {
        generatedPlaylists.add(playlist);
    }

    public static void setHistory(ArrayList<Playlist> playlists){
        generatedPlaylists = playlists;
    }

    public static ArrayList<Playlist> getPlaylists(){
        return generatedPlaylists;
    }
    public static Boolean isMergeable(){
        return generatedPlaylists.size() > 1;
    }
}
