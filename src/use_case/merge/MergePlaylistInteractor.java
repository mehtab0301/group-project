package use_case.merge;

import entity.Playlist;
import data_access.PlaylistHistoryAccess;
import entity.Song;

import java.util.ArrayList;

public class MergePlaylistInteractor {
    /*
    PRECONDITION: At least 2 playlists exist! I made the if just in case the preconditions do not hold
     */
    public void mergePlaylists() {
        if (PlaylistHistoryAccess.isMergeable()){
            ArrayList<Playlist> playlistHistory = PlaylistHistoryAccess.getPlaylists();
            // Now will merge all the existing Playlists into one
            ArrayList<Song> listedSongs = new ArrayList<>();
            for (Playlist playlist : playlistHistory) {
                ArrayList<Song> songs = playlist.getSongs();
                listedSongs.addAll(songs);
            }

            Playlist newPlaylist = new Playlist(listedSongs);
            ArrayList<Playlist> changeHistory= new ArrayList<>();
            //Maybe a bit extra, but this is done to ensure that multiple playlists can be added later
            changeHistory.add(newPlaylist);
            PlaylistHistoryAccess.setHistory(changeHistory);
        }

    }
}
