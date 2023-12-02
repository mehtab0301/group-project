package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.getTrackDetails.GetTrackDetailsController;
import interface_adapter.getTrackDetails.GetTrackDetailsPresenter;
import interface_adapter.getTrackDetails.GetTrackDetailsViewModel;
import interface_adapter.trackDetails.TrackDetailsViewModel;
import use_case.getTrackDetails.GetTrackDetailsInputBoundary;
import use_case.getTrackDetails.GetTrackDetailsInteractor;
import use_case.getTrackDetails.GetTrackDetailsOutputBoundary;
import view.GetTrackDetailsView;

public class GetTrackDetailsUseCaseFactory {

    public static GetTrackDetailsView create(ViewManagerModel viewManagerModel,
                                             GetTrackDetailsViewModel getTrackDetailsViewModel,
                                             TrackDetailsViewModel trackDetailsViewModel) {
        GetTrackDetailsController getTrackDetailsController = createUserGetTrackDetailsUseCase(viewManagerModel,
                trackDetailsViewModel);
        return new GetTrackDetailsView(getTrackDetailsController, getTrackDetailsViewModel);
    }

    private static GetTrackDetailsController createUserGetTrackDetailsUseCase(
            ViewManagerModel viewManagerModel, TrackDetailsViewModel trackDetailsViewModel
    ) {
        GetTrackDetailsOutputBoundary getTrackDetailsOutputBoundary = new GetTrackDetailsPresenter(viewManagerModel,
                trackDetailsViewModel);

        GetTrackDetailsInputBoundary getTrackDetailsInteractor = new GetTrackDetailsInteractor(
                getTrackDetailsOutputBoundary);

        return new GetTrackDetailsController(getTrackDetailsInteractor);
    }
}
