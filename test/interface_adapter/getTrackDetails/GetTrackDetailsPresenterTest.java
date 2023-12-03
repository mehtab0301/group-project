package interface_adapter.getTrackDetails;

import interface_adapter.trackDetails.TrackDetailsState;
import interface_adapter.trackDetails.TrackDetailsViewModel;
import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.getTrackDetails.GetTrackDetailsOutputData;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetTrackDetailsPresenterTest {

    private ViewManagerModel viewManagerModel;
    private TrackDetailsViewModel trackDetailsViewModel;
    private GetTrackDetailsPresenter getTrackDetailsPresenter;

    @BeforeEach
    void setUp() {
        viewManagerModel = new ViewManagerModel();
        trackDetailsViewModel = new TrackDetailsViewModel();
        getTrackDetailsPresenter = new GetTrackDetailsPresenter(viewManagerModel, trackDetailsViewModel);
    }

    @Test
    void prepareSuccessView_updatesViewModelStateAndViewManager() {
        // Arrange
        List<Object> info = new ArrayList<>();
        info.add("info1");
        info.add("info2");

        GetTrackDetailsOutputData outputData = new GetTrackDetailsOutputData(info);

        // Act
        getTrackDetailsPresenter.prepareSuccessView(outputData);

        // Assert
        TrackDetailsState state = trackDetailsViewModel.getState();
        assertEquals("Track Information", state.getTrackInfo());

        // Assuming the view manager is correctly updated
        assertEquals(trackDetailsViewModel.getViewName(), viewManagerModel.getActiveView());
    }
}