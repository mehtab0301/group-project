package interface_adapter.generate;

public class GenerateState {
    private String genre = "";
    private int numberOfTracks = 0;

    public GenerateState(GenerateState copy) {
        genre = copy.genre;
        numberOfTracks = copy.numberOfTracks;;
    }

    public GenerateState() {
    }

    public String getGenre() { return genre; }

    public int getNumberOfTracks() { return numberOfTracks; }

    public void setGenre(String genre) { this.genre = genre; }

    public void setNumberOfTracks(int numberOfTracks) { this.numberOfTracks = numberOfTracks; }
}
