package entity;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SimilarPlaylistsTest {
    @Test
    public void getSimilarPlaylists() {
        String link1 = "link1";
        String link2 = "link2";
        String link3 = "link3";
        ArrayList<String> list = new ArrayList<>();
        list.add(link1);
        list.add(link2);
        list.add(link3);
        SimilarPlaylists similarPlaylists = new SimilarPlaylists(list);
        Assert.assertNotNull(similarPlaylists.getSimilarPlaylists());
    }

    @Test
    public void getSimilarPlaylistsLength() {
        String link1 = "link1";
        String link2 = "link2";
        String link3 = "link3";
        ArrayList<String> list = new ArrayList<>();
        list.add(link1);
        list.add(link2);
        list.add(link3);
        SimilarPlaylists similarPlaylists = new SimilarPlaylists(list);
        Assert.assertEquals(3, similarPlaylists.getSimilarPlaylistsLength());
    }
}