package use_case.SimilarPlaylists;

import API_calls.GetTrackDetails;

public class SimilarPlaylistsInteractor {
    private final String username;
    private final String songLink;

    public SimilarPlaylistsInteractor(String username, String songLink) {
        this.username = username;
        this.songLink = songLink;
    }
    public void execute() {
        GetTrackDetails apiAccess = new GetTrackDetails(songLink);

    }

}
