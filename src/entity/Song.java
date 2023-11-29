package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Song {

    private final String name;
    private final List<String> artist;
    private final int popularity;
    private final String link;

    private final String date;

    private final Optional<ArrayList<SimilarPlaylists>> playlists;

    public Song(String name, List<String> artist, int popularity, String link, String date, Optional<ArrayList<SimilarPlaylists>> playlists) {
        this.name = name;
        this.artist = artist;
        this.popularity = popularity;
        this.link = link;
        this.date = date;
        this.playlists = playlists;
    }

    public String getName() {
        return name;
    }

    public List<String> getArtist() {
        return artist;
    }

    public int getPopularity() {
        return popularity;
    }

    public Optional<ArrayList<SimilarPlaylists>> getSimilarPlaylists() {
        return playlists;
    }

    public String getLink(){
        return link;
    }
}
