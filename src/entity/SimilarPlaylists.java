package entity;

import java.util.ArrayList;

public class SimilarPlaylists {

    /*
    Names are a bit confusing, so they can be changed.
    This class refers to the generated playlist links by Spotify that correspond to some song.
    This is why you will see it referred in the song class.
    */
    private final ArrayList<String> similarPlaylists;


    public SimilarPlaylists(ArrayList<String> similarPlaylists) {
        this.similarPlaylists = similarPlaylists;
    }

    public ArrayList<String> getSimilarPlaylists() {
        return similarPlaylists;
    }

}
