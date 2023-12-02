package use_case.generate;

import entity.Playlist;

public class GenerateOutputData {

    private final Playlist playlist;

    public GenerateOutputData(Playlist playlist) {
        this.playlist = playlist;
    }

    public Playlist getTrackList() { return playlist; }
}
