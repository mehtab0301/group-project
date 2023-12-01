package use_case.merge;

import entity.Playlist;
import entity.Song;

import java.io.IOException;
import java.util.ArrayList;

public class MergeInteractor implements MergeInputBoundary {

    final MergeOutputBoundary mergePresenter;

    public MergeInteractor(MergeOutputBoundary mergeOutputBoundary) {
        this.mergePresenter = mergeOutputBoundary;
    }

    @Override
    public void execute(MergeInputData mergeInputData) throws IOException {
        ArrayList<Playlist> playlistHistory = mergeInputData.getPlaylistHistory();
        // Now will merge all the existing Playlists into one
        ArrayList<Song> listedSongs = new ArrayList<>();
        for (Playlist playlist : playlistHistory) {
            ArrayList<Song> songs = playlist.getSongs();
            listedSongs.addAll(songs);
        }

        Playlist mergedPlaylist = new Playlist(listedSongs);
        MergeOutputData mergeOutputData = new MergeOutputData(mergedPlaylist);
        mergePresenter.prepareSuccessView(mergeOutputData);
    }
}
