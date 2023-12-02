package use_case.getSimilarPlaylists;

import entity.SimilarPlaylists;

public class GetSimilarPlaylistsOutputData {
    private final SimilarPlaylists similarPlaylists;

    public GetSimilarPlaylistsOutputData(SimilarPlaylists similarPlaylists) {
        this.similarPlaylists = similarPlaylists;
    }

    public SimilarPlaylists getSimilarPlaylists() { return similarPlaylists; }
}
