package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.getTrackDetails.GetTrackDetailsController;
import interface_adapter.getTrackDetails.GetTrackDetailsViewModel;
import interface_adapter.trackDetails.TrackDetailsViewModel;
import org.junit.jupiter.api.Test;
import view.GetTrackDetailsView;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GetTrackDetailsUseCaseFactoryTest {

    @Test
    void create_returnsGetTrackDetailsView() {
        // Arrange
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        GetTrackDetailsViewModel getTrackDetailsViewModel = new GetTrackDetailsViewModel();
        TrackDetailsViewModel trackDetailsViewModel = new TrackDetailsViewModel();

        // Act
        GetTrackDetailsView getTrackDetailsView = GetTrackDetailsUseCaseFactory.create(viewManagerModel,
                getTrackDetailsViewModel, trackDetailsViewModel);

        // Assert
        assertNotNull(getTrackDetailsView);
    }

    @Test
    void createUserGetTrackDetailsUseCase_returnsGetTrackDetailsController() {
        // Arrange
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TrackDetailsViewModel trackDetailsViewModel = new TrackDetailsViewModel();

        // Act
        GetTrackDetailsController getTrackDetailsController = GetTrackDetailsUseCaseFactory
                .createUserGetTrackDetailsUseCase(viewManagerModel, trackDetailsViewModel);

        // Assert
        assertNotNull(getTrackDetailsController);
    }
}