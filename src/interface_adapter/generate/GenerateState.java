package interface_adapter.generate;

public class GenerateState {
    private String genre = "";
    private int popularity = 0;
    private float danceability = 0.0F;
    private float valence = 0.0F;
    private float speechiness = 0.0F;
    private float energy = 0.0F;
    private int numberOfTracks = 0;

    public GenerateState(GenerateState copy) {
        genre = copy.genre;
        popularity = copy.popularity;
        danceability = copy.danceability;
        valence = copy.valence;
        speechiness = copy.speechiness;
        energy = copy.energy;
        numberOfTracks = copy.numberOfTracks;
    }

    public GenerateState() {
    }

    public String getGenre() { return genre; }

    public int getPopularity() { return popularity; }

    public float getDanceability() { return danceability; }

    public float getValence() { return valence; }

    public float getSpeechiness() { return speechiness; }

    public float getEnergy() { return energy; }

    public int getNumberOfTracks() { return numberOfTracks; }

    public void setGenre(String genre) { this.genre = genre; }

    public void setPopularity(int popularity) { this.popularity = popularity; }

    public void setDanceability(float danceability) { this.danceability = danceability; }

    public void setValence(float valence) { this.valence = valence; }

    public void setSpeechiness(float speechiness) { this.speechiness = speechiness; }

    public void setEnergy(float energy) { this.energy = energy; }

    public void setNumberOfTracks(int numberOfTracks) { this.numberOfTracks = numberOfTracks; }
}
