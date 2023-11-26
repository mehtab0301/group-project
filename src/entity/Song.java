package entity;

import java.util.ArrayList;

public class Song {

    private final String name;
    private final ArrayList<String> artist;
    private final int popularity;
    private final String link;

    private final ArrayList<SimilarPlaylists> playlists;

    public Song(String name, ArrayList<String> artist, int popularity, String link, ArrayList<SimilarPlaylists> playlists) {
        this.name = name;
        this.artist = artist;
        this.popularity = popularity;
        this.link = link;
        this.playlists = playlists;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getArtist() {
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
