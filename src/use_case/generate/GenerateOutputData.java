package use_case.generate;

import entity.Song;

import java.util.List;

public class GenerateOutputData {

    private final List<Object> trackList;

    public GenerateOutputData(List<Object> trackList) {
        this.trackList = trackList;
    }

    public List<Object> getTrackList() { return trackList; }
}
