package use_case.getTrackDetails;

import java.util.List;

public class GetTrackDetailsOutputData {

    private final List<Object> trackInfo;

    public GetTrackDetailsOutputData(List<Object> trackInfo) {
        this.trackInfo = trackInfo;
    }

    public List<Object> getTrackInfo() { return trackInfo; }
}
