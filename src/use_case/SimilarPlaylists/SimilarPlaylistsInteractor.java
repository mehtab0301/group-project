package use_case.SimilarPlaylists;

import API_calls.GetSimilarPlaylists;
import entity.Song;

public class SimilarPlaylistsInteractor {
    private final String username;
    private final String songName;

    public SimilarPlaylistsInteractor(String username, String songName) {
        this.username = username;
        this.songName = songName;
    }

}
