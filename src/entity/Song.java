package entity;

import java.util.ArrayList;

public class Song {

    private final String name;
    private final ArrayList<String> artist;
    private final int popularity;
    private final String link;

    private ArrayList<SimilarPlaylists> playlists;

    public Song(String name, ArrayList<String> artist, int popularity, String link) {
        this.name = name;
        this.artist = artist;
        this.popularity = popularity;
        this.link = link;
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
    public void setPlaylists(ArrayList<SimilarPlaylists> playlists) {
        this.playlists = playlists;
    }
}
