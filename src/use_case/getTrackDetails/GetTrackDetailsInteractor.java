package use_case.getTrackDetails;

import java.io.IOException;
import java.util.List;

public class GetTrackDetailsInteractor implements GetTrackDetailsInputBoundary {

    final GetTrackDetailsOutputBoundary userPresenter;

    public GetTrackDetailsInteractor(GetTrackDetailsOutputBoundary getTrackDetailsOutputBoundary) {
        this.userPresenter = getTrackDetailsOutputBoundary;
    }

    @Override
    public void execute(GetTrackDetailsInputData getTrackDetailsInputData) throws IOException {
        List<Object> output = GetTrackDetailsHelper.createTrackDetails(getTrackDetailsInputData.getSongLink());

        GetTrackDetailsOutputData getTrackDetailsOutputData = new GetTrackDetailsOutputData(output);
        userPresenter.prepareSuccessView(getTrackDetailsOutputData);
    }
}
