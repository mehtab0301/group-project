package view.getTrackDetailsView;

import interface_adapter.getTrackDetails.GetTrackDetailsController;
import interface_adapter.getTrackDetails.GetTrackDetailsViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.getTrackDetails.GetTrackDetailsInputBoundary;
import view.GetTrackDetailsView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetTrackDetailsViewTest implements ActionListener {

    private GetTrackDetailsViewModel getTrackDetailsViewModel;
    private GetTrackDetailsController getTrackDetailsController;
    private GetTrackDetailsView getTrackDetailsView;

    @BeforeEach
    void setUp() {
        getTrackDetailsViewModel = new GetTrackDetailsViewModel();
        getTrackDetailsController = new GetTrackDetailsController(null);
        getTrackDetailsView = new GetTrackDetailsView(getTrackDetailsController, getTrackDetailsViewModel);
    }

    @Test
    void actionPerformed_generateButtonClicked() throws IOException {
        // Arrange
        String songLink = "https://example.com/song";
        getTrackDetailsViewModel.getState().setSongLink(songLink);

        // Act
        getTrackDetailsView.actionPerformed(new ActionEvent(getTrackDetailsView.generate, ActionEvent.ACTION_PERFORMED, null));

        getTrackDetailsController.execute(songLink);
    }

    @Test
    void keyTyped_updatesViewModelState() {
        // Arrange
        KeyListener keyListener = getTrackDetailsView.songLinkField.getKeyListeners()[0];
        KeyEvent keyEvent = new KeyEvent(getTrackDetailsView.songLinkField, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'a');

        // Act
        keyListener.keyTyped(keyEvent);

        // Assert
        assertEquals("a", getTrackDetailsViewModel.getState().getSongLink());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    // Stub implementation of GetTrackDetailsController for testing
    private static class GetTrackDetailsControllerStub extends GetTrackDetailsController {
        private String executedSongLink;

        public GetTrackDetailsControllerStub(GetTrackDetailsInputBoundary getTrackDetailsInputBoundary) {
            super(getTrackDetailsInputBoundary);
        }

        @Override
        public void execute(String songLink) throws IOException {
            executedSongLink = songLink;
        }

        public String getExecutedSongLink() {
            return executedSongLink;
        }
    }
}