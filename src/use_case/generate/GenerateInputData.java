package use_case.generate;

public class GenerateInputData {

    final private String genre;
    final private int popularity;
    final private float danceability;
    final private float valence;
    final private float speechiness;
    final private float energy;
    final private int numberOfTracks;

    public GenerateInputData(String genre, int popularity, float danceability, float valence, float speechiness,
                             float energy, int numberOfTracks) {
        this.genre = genre;
        this.popularity = popularity;
        this.danceability = danceability;
        this.valence = valence;
        this.speechiness = speechiness;
        this.energy = energy;
        this.numberOfTracks = numberOfTracks;
    }

    String getGenre() { return genre; }

    int getPopularity() { return popularity; }

    float getDanceability() { return danceability; }

    float getValence() { return valence; }

    float getSpeechiness() { return speechiness; }

    float getEnergy() { return energy; }

    int getNumberOfTracks() { return numberOfTracks; }
}
