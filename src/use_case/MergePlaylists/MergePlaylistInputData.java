package use_case.MergePlaylists;

public class MergePlaylistInputData {
    final private String Username;

    public MergePlaylistInputData(String username) {
        Username = username;
    }

    String getUsername() {return Username;}
}
