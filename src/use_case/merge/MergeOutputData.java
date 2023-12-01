package use_case.merge;

import entity.Playlist;

public class MergeOutputData {

    private final Playlist playlist;

    public MergeOutputData(Playlist playlist) {
        this.playlist = playlist;
    }

    public Playlist getPlaylist() { return playlist; }
}
