package interface_adapter.getSimilarPlaylists;

public class GetSimilarPlaylistsState {
    private String songName;

    public GetSimilarPlaylistsState(GetSimilarPlaylistsState copy) { songName = copy.songName; }

    public GetSimilarPlaylistsState() {}

    public String getSongName() { return songName; }

    public void setSongName(String name) { this.songName = name; }
}
