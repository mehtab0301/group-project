package use_case.getSimilarPlaylists;

public class GetSimilarPlaylistsInputData {

    final private String songName;

    public GetSimilarPlaylistsInputData(String songName) {
        this.songName = songName;
    }

    String getSongName() { return songName; }
}
