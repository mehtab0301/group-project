package view.outputView;

import entity.Playlist;
import interface_adapter.ViewManagerModel;
import interface_adapter.generate.GenerateViewModel;
import interface_adapter.getSimilarPlaylists.GetSimilarPlaylistsViewModel;
import interface_adapter.getTrackDetails.GetTrackDetailsViewModel;
import interface_adapter.output.OutputViewModel;
import interface_adapter.output.OutputViewState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.MenuView;
import view.OutputView;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputViewTest {

    private OutputViewModel outputViewModel;
    private ViewManagerModel viewManagerModel;
    private GenerateViewModel generateViewModel;
    private GetSimilarPlaylistsViewModel getSimilarPlaylistsViewModel;
    private GetTrackDetailsViewModel getTrackDetailsViewModel;
    private MenuView menuView;
    private OutputView outputView;

    @BeforeEach
    void setUp() {
        outputViewModel = new OutputViewModel();
        viewManagerModel = new ViewManagerModel();
        generateViewModel = new GenerateViewModel();
        getSimilarPlaylistsViewModel = new GetSimilarPlaylistsViewModel();
        getTrackDetailsViewModel = new GetTrackDetailsViewModel();
        menuView = new MenuView(generateViewModel, getSimilarPlaylistsViewModel, getTrackDetailsViewModel,
                viewManagerModel);
        outputView = new OutputView(outputViewModel, viewManagerModel, generateViewModel, menuView);
    }

    @Test
    void actionPerformed_backButtonClicked() {
        // Arrange
        viewManagerModel.setActiveView(outputViewModel.getViewName());

        // Act
        outputView.actionPerformed(new ActionEvent(outputView.back, ActionEvent.ACTION_PERFORMED, null));

        // Assert
        assertEquals(menuView.viewName, viewManagerModel.getActiveView());
    }

    @Test
    void actionPerformed_generateAgainButtonClicked() {
        // Arrange
        viewManagerModel.setActiveView(outputViewModel.getViewName());

        // Act
        outputView.actionPerformed(new ActionEvent(outputView.generateAgain, ActionEvent.ACTION_PERFORMED, null));

        // Assert
        assertEquals(generateViewModel.getViewName(), viewManagerModel.getActiveView());
    }

    @Test
    void propertyChange_emptyPlaylist() {
        // Arrange
        OutputViewState emptyState = new OutputViewState();
        emptyState.setGeneratedPlaylist(new Playlist(new ArrayList<>()));  // Empty playlist
        outputViewModel.setState(emptyState);

        // Act
        outputView.propertyChange(null);

        // Assert
        assertEquals(1, outputView.getComponentCount()); // Only buttons should be present
    }

    @Test
    void propertyChange_nullViewState() {
        // Arrange
        outputViewModel.setState(null);

        // Act
        outputView.propertyChange(null);

        // Assert
        assertEquals(1, outputView.getComponentCount()); // Only buttons should be present
    }

    @Test
    void propertyChange_negativeNumOfTracks() {
        // Arrange
        OutputViewState negativeTracksState = new OutputViewState();
        outputViewModel.setState(negativeTracksState);

        // Act
        outputView.propertyChange(null);

        // Assert
        assertEquals(1, outputView.getComponentCount()); // Only buttons should be present
    }

    @Test
    void propertyChange_errorHandling() throws IOException {
        // Arrange
        OutputViewState errorState = new OutputViewState();
        errorState.setGeneratedPlaylist(new Playlist(new ArrayList<>())); // Non-empty playlist
        outputViewModel.setState(errorState);

        // Simulate an error in propertyChange
        outputView = new OutputView(outputViewModel, viewManagerModel, generateViewModel, menuView) {
            @Override
            public void removeAll() {
                throw new RuntimeException("Simulated error");
            }
        };

        // Act and Assert
        assertDoesNotThrow(() -> outputView.propertyChange(null));
    }

}
