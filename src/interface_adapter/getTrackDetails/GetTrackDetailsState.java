package interface_adapter.getTrackDetails;

public class GetTrackDetailsState {

    private String songLink = "";

    public GetTrackDetailsState(GetTrackDetailsState copy) {
        songLink = copy.songLink;
    }

    public GetTrackDetailsState() {}

    public String getSongLink() { return songLink; }

    public void setSongLink(String songLink) { this.songLink = songLink; }
}
