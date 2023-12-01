package interface_adapter.output;

import entity.Playlist;

import java.util.ArrayList;

public class OutputViewState {
    private Playlist generatedPlaylist = new Playlist(new ArrayList<>());

    public OutputViewState(OutputViewState copy) {
        generatedPlaylist = copy.generatedPlaylist;
    }

    public OutputViewState() {}

    public Playlist getGeneratedPlaylist() { return generatedPlaylist; }
    public int getNumOfTracks() { return generatedPlaylist.getLength(); }

    public void setGeneratedPlaylist(Playlist generatedPlaylist) {
        this.generatedPlaylist = generatedPlaylist;
    }
}
