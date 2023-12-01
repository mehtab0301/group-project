package use_case.merge;

import entity.Playlist;

import java.util.ArrayList;

public class MergeInputData {

    final private ArrayList<Playlist> playlistHistory;

    public MergeInputData(ArrayList<Playlist> playlistHistory) {
        this.playlistHistory = playlistHistory;
    }

    ArrayList<Playlist> getPlaylistHistory() { return playlistHistory; }
}
