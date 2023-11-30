package use_case.MergePlaylists;

import entity.Playlist;

public class MergePlaylsitOutputData {
    final private Playlist mergedPlaylist;
    final private boolean mergeSuccess;

    public MergePlaylsitOutputData(Playlist mergedPlaylist, boolean mergeSuccess) {
        this.mergedPlaylist = mergedPlaylist;
        this.mergeSuccess = mergeSuccess;
    }

    public Playlist getMergedPlaylist() {
        return mergedPlaylist;
    }

    public boolean isMergeSuccess() {
        return mergeSuccess;
    }
}
