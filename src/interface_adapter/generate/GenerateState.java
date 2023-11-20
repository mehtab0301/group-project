package interface_adapter.generate;

public class GenerateState {
    private String genre = "";
    private int popularity = 0;
    private int loudness = 0;
    private double valence = 0.0;
    private double speechiness = 0.0;
    private double energy = 0.0;
    private int numberOfTracks = 0;

    public GenerateState(GenerateState copy) {
        genre = copy.genre;
        popularity = copy.popularity;
        loudness = copy.loudness;
        valence = copy.valence;
        speechiness = copy.speechiness;
        energy = copy.energy;
        numberOfTracks = copy.numberOfTracks;
    }

    public GenerateState() {
    }

    public String getGenre() { return genre; }

    public int getPopularity() { return popularity; }

    public int getLoudness() { return loudness; }

    public double getValence() { return valence; }

    public double getSpeechiness() { return speechiness; }

    public double getEnergy() { return energy; }

    public int getNumberOfTracks() { return numberOfTracks; }

    public void setGenre(String genre) { this.genre = genre; }

    public void setPopularity(int popularity) { this.popularity = popularity; }

    public void setLoudness(int loudness) { this.loudness = loudness; }

    public void setValence(double valence) { this.valence = valence; }

    public void setSpeechiness(double speechiness) { this.speechiness = speechiness; }

    public void setEnergy(double energy) { this.energy = energy; }

    public void setNumberOfTracks(int numberOfTracks) { this.numberOfTracks = numberOfTracks; }
}
