package interface_adapter.output;

import entity.Playlist;

public class OutputViewState {
    private Playlist generatedPlaylist;

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
