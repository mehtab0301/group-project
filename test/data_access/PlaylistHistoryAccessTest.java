package data_access;

import entity.Playlist;
import entity.Song;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PlaylistHistoryAccessTest {

    @Test
    public void isMergeable() {
        List<String> songArtists1 = new ArrayList<>();
        songArtists1.add("songArtist1");
        Song song1 = new Song("songName1", songArtists1, 1, "link1", "date1", null);

        List<String> songArtists2 = new ArrayList<>();
        songArtists2.add("songArtist2");
        songArtists2.add("songArtist3");
        Song song2 = new Song("songName2", songArtists2, 100, "link2", "date2", null);

        List<String> songArtists3 = new ArrayList<>();
        songArtists3.add("songArtist4");
        songArtists3.add("songArtist5");
        Song song3 = new Song("songName3", songArtists3, 50, "link3", "date3", null);

        List<String> songArtists4 = new ArrayList<>();
        songArtists3.add("songArtist6");
        songArtists3.add("songArtist7");
        Song song4 = new Song("songName4", songArtists4, 29, "link4", "date4", null);

        ArrayList<Song> list1 = new ArrayList<>();
        list1.add(song1);
        list1.add(song2);

        ArrayList<Song> list2 = new ArrayList<>();
        list2.add(song3);

        ArrayList<Song> list3 = new ArrayList<>();
        list3.add(song4);

        Playlist playlist1 = new Playlist(list1);
        Playlist playlist2 = new Playlist(list2);
        Playlist playlist3 = new Playlist(list2);

        ArrayList<Playlist> playlistsHistory = new ArrayList<>();
        playlistsHistory.add(playlist1);
        PlaylistHistoryAccess.setHistory(playlistsHistory);
        PlaylistHistoryAccess.addToHistory(playlist2);
        PlaylistHistoryAccess.addToHistory(playlist3);

        Assert.assertEquals(true, PlaylistHistoryAccess.isMergeable());
    }
}