package entity;

import java.util.ArrayList;

public class Song {

    private final String name;
    private final String artist;
    private final int popularity;
    private final String link;

    private final ArrayList<SimilarPlaylists> playlists;

    Song(String name, String artist, int popularity, String link, ArrayList<SimilarPlaylists> playlists) {
        this.name = name;
        this.artist = artist;
        this.popularity = popularity;
        this.link = link;
        this.playlists = playlists;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public int getPopularity() {
        return popularity;
    }

    public ArrayList<SimilarPlaylists> getSimilarPlaylists() {
        return playlists;
    }

    public String getLink(){
        return link;
    }
}
