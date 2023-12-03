package view.getSimilarPlaylistsView;

import interface_adapter.getSimilarPlaylists.GetSimilarPlaylistsController;
import interface_adapter.getSimilarPlaylists.GetSimilarPlaylistsViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.getSimilarPlaylists.GetSimilarPlaylistsInputBoundary;
import view.GetSimilarPlaylistsView;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetSimilarPlaylistsViewTest {

    private GetSimilarPlaylistsViewModel getSimilarPlaylistsViewModel;
    private GetSimilarPlaylistsControllerStub getSimilarPlaylistsController;
    private GetSimilarPlaylistsView getSimilarPlaylistsView;

    @BeforeEach
    void setUp() {
        getSimilarPlaylistsViewModel = new GetSimilarPlaylistsViewModel();
        getSimilarPlaylistsController = new GetSimilarPlaylistsControllerStub(null);
        getSimilarPlaylistsView = new GetSimilarPlaylistsView(getSimilarPlaylistsController, getSimilarPlaylistsViewModel);
    }

    @Test
    void actionPerformed_generateButtonClicked() throws IOException {
        // Arrange
        String songName = "Some Song";
        getSimilarPlaylistsViewModel.getState().setSongName(songName);

        // Act
        getSimilarPlaylistsView.actionPerformed(new ActionEvent(getSimilarPlaylistsView.generate, ActionEvent.ACTION_PERFORMED, null));

        // Assert
        assertEquals(songName, getSimilarPlaylistsController.getExecutedSongName());
    }

    @Test
    void keyTyped_updatesViewModelState() {
        // Arrange
        KeyListener keyListener = getSimilarPlaylistsView.songNameField.getKeyListeners()[0];
        KeyEvent keyEvent = new KeyEvent(getSimilarPlaylistsView.songNameField, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'a');

        // Act
        keyListener.keyTyped(keyEvent);

        // Assert
        assertEquals("a", getSimilarPlaylistsViewModel.getState().getSongName());
    }

    // Stub implementation of GetSimilarPlaylistsController for testing
    private static class GetSimilarPlaylistsControllerStub extends GetSimilarPlaylistsController {
        private String executedSongName;

        public GetSimilarPlaylistsControllerStub(GetSimilarPlaylistsInputBoundary userGetSimilarPlaylistsUseCaseInteractor) {
            super(userGetSimilarPlaylistsUseCaseInteractor);
        }

        @Override
        public void execute(String songName) throws IOException {
            executedSongName = songName;
        }

        public String getExecutedSongName() {
            return executedSongName;
        }
    }

    // Add more tests as needed for different scenarios

}