package use_case.getTrackDetails;

public class GetTrackDetailsInputData {

    final private String songLink;

    public GetTrackDetailsInputData(String songLink) {
        this.songLink = songLink;
    }

    String getSongLink() { return songLink; }
}
