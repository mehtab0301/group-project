package use_case.CreatePlaylist;

public class CreatePlaylistInputData {
    final private int popularity;
    final private float energy;
    final private float speechiness;
    final private float valence;
    final private float danceability;
    final private int numberOfTracks;
    final private String genre;

    public CreatePlaylistInputData(int popularity,
                                   float energy, float speechiness, float valence,
                                   float danceability, int numberOfTracks, String genre, String usernmae) {
        this.popularity = popularity;
        this.energy = energy;
        this.speechiness = speechiness;
        this.valence = valence;
        this.danceability = danceability;
        this.numberOfTracks = numberOfTracks;
        this.genre = genre;
    }
}
