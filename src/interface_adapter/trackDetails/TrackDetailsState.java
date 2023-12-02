package interface_adapter.trackDetails;

import java.util.List;

public class TrackDetailsState {
    private List<Object> trackInfo;

    public TrackDetailsState(TrackDetailsState copy) {
        trackInfo = copy.trackInfo;
    }

    public TrackDetailsState() {}

    public List<Object> getTrackInfo() { return trackInfo; }

    public int getNumOfInfo() { return trackInfo.size(); }

    public void setTrackInfo(List<Object> trackInfo) { this.trackInfo = trackInfo; }
}
