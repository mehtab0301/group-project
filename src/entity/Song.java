package entity;

import java.util.List;

public class Song {

    private final String name;
    private final String artist;
    private final int popularity;

    Song(String name, String artist, int popularity) {
        this.name = name;
        this.artist = artist;
        this.popularity = popularity;
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

    // {object1: [name(string), artists(list of strings), songLink(string)], object2, object3, ...}
}
