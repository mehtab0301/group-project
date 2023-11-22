package use_case.MergePlaylists;

import entity.Playlist;
import entity.PlaylistsHistory;
import data_access.PlaylistHistoryAccess;
import data_access.PlaylistAccess;
import entity.Song;

import java.util.ArrayList;

public class MergePlaylistInteractor {

    ArrayList<Playlist> playlistHistory = PlaylistHistoryAccess.getPlaylists();
    int size = playlistHistory.size();

    //Now will merge all the existing Playlists into one
    ArrayList<Song> listedSongs = new ArrayList<>();
    for(int i = 0; i < size; i++) {
        ArrayList<Song> songs = playlistHistory.get(i).getSongs();
        listedSongs.addAll(songs);
    }

    Playlist newPlaylist = new Playlist(listedSongs);
    PlaylistHistoryAccess.setHistory(newPlaylist);
}
