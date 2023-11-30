package use_case.MergePlaylists;

import entity.Playlist;
import entity.PlaylistsHistory;
import data_access.PlaylistHistoryAccess;
import data_access.PlaylistAccess;
import entity.Song;
import DataBase.DataAccessInterface;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public class MergePlaylistInteractor {
    /*
    PRECONDITION: At least 2 playlists exist! I made the if just in case the preconditions do not hold
     */
    public void mergePlaylists(String Username) throws IOException, ParseException {
        DataAccessInterface access = new DataAccessInterface();
        if (access.numberOfPlaylists(Username) > 1) {
            ArrayList<Playlist> playlists = access.getAllPlaylists(Username);
            ArrayList<Song> songs = new ArrayList<>();
            for(Playlist playlist : playlists) {
                songs.addAll(playlist.getSongs());
            }
            Playlist mergedPlaylist = new Playlist(songs);
            access.addPlaylist(mergedPlaylist, Username);
            MergePlaylsitOutputData mergePlaylsitOutputData = new MergePlaylsitOutputData(mergedPlaylist, true);
        }
    }
}
