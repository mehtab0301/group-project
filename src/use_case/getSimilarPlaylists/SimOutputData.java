package use_case.getSimilarPlaylists;
import java.util.List;

public class SimOutputData {

    private final List<String> similar_playlists;

    public SimOutputData(List<String> similarPlaylists) {
        similar_playlists = similarPlaylists;
    }

    public List<String> getsimilarList() { return similar_playlists; }
}
