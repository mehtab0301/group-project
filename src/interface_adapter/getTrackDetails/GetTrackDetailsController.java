package interface_adapter.getTrackDetails;

import use_case.getTrackDetails.GetTrackDetailsInputBoundary;
import use_case.getTrackDetails.GetTrackDetailsInputData;

import java.io.IOException;

public class GetTrackDetailsController {

    final GetTrackDetailsInputBoundary getTrackDetailsInteractor;

    public GetTrackDetailsController(GetTrackDetailsInputBoundary getTrackDetailsInputBoundary) {
        this.getTrackDetailsInteractor = getTrackDetailsInputBoundary;
    }

    public void execute(String songLink) throws IOException {
        GetTrackDetailsInputData getTrackDetailsInputData = new GetTrackDetailsInputData(songLink);
        getTrackDetailsInteractor.execute(getTrackDetailsInputData);
    }
}
