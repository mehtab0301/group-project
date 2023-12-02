package interface_adapter.getTrackDetails;

import interface_adapter.trackDetails.TrackDetailsState;
import interface_adapter.trackDetails.TrackDetailsViewModel;
import interface_adapter.ViewManagerModel;
import use_case.getTrackDetails.GetTrackDetailsOutputBoundary;
import use_case.getTrackDetails.GetTrackDetailsOutputData;

public class GetTrackDetailsPresenter implements GetTrackDetailsOutputBoundary {

    private final TrackDetailsViewModel trackDetailsViewModel;

    private ViewManagerModel viewManagerModel;

    public GetTrackDetailsPresenter(ViewManagerModel viewManagerModel,
                                    TrackDetailsViewModel trackDetailsViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.trackDetailsViewModel = trackDetailsViewModel;
    }

    @Override
    public void prepareSuccessView(GetTrackDetailsOutputData getTrackDetailsOutputData) {
        TrackDetailsState trackDetailsState = trackDetailsViewModel.getState();
        trackDetailsState.setTrackInfo(getTrackDetailsOutputData.getTrackInfo());
        this.trackDetailsViewModel.setState(trackDetailsState);
        trackDetailsViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(trackDetailsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
