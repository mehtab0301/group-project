package interface_adapter.similarPlaylists;

import entity.SimilarPlaylists;

public class SimilarPlaylistsState {
    private SimilarPlaylists similarPlaylists;

    public SimilarPlaylistsState(SimilarPlaylistsState copy) { similarPlaylists = copy.similarPlaylists; }

    public SimilarPlaylistsState() {}

    public SimilarPlaylists getSimilarPlaylists() { return similarPlaylists; }

    public void setSimilarPlaylists(SimilarPlaylists similarPlaylists) { this.similarPlaylists = similarPlaylists; }
}
