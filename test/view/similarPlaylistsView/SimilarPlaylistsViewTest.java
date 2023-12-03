package view.similarPlaylistsView;

import entity.SimilarPlaylists;
import interface_adapter.ViewManagerModel;
import interface_adapter.generate.GenerateViewModel;
import interface_adapter.getSimilarPlaylists.GetSimilarPlaylistsViewModel;
import interface_adapter.getTrackDetails.GetTrackDetailsViewModel;
import interface_adapter.similarPlaylists.SimilarPlaylistsState;
import interface_adapter.similarPlaylists.SimilarPlaylistsViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.MenuView;
import view.SimilarPlaylistsView;

import javax.swing.*;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimilarPlaylistsViewTest implements PropertyChangeListener {

    private SimilarPlaylistsViewModel similarPlaylistsViewModel;
    private GenerateViewModel generateViewModel;
    private GetSimilarPlaylistsViewModel getSimilarPlaylistsViewModel;
    private GetTrackDetailsViewModel getTrackDetailsViewModel;
    private ViewManagerModel viewManagerModel;
    private MenuView menuView;
    private SimilarPlaylistsView similarPlaylistsView;

    @BeforeEach
    void setUp() {
        generateViewModel = new GenerateViewModel();
        getSimilarPlaylistsViewModel = new GetSimilarPlaylistsViewModel();
        getTrackDetailsViewModel = new GetTrackDetailsViewModel();
        similarPlaylistsViewModel = new SimilarPlaylistsViewModel();
        viewManagerModel = new ViewManagerModel();
        menuView = new MenuView(generateViewModel, getSimilarPlaylistsViewModel, getTrackDetailsViewModel,
                viewManagerModel);
        similarPlaylistsView = new SimilarPlaylistsView(similarPlaylistsViewModel, viewManagerModel, menuView);
    }

    @Test
    void propertyChange() {
        // Arrange
        SimilarPlaylistsState state = new SimilarPlaylistsState();
        ArrayList<String> list = new ArrayList<>();
        list.add("link1");
        list.add("link2");
        list.add("link3");
        SimilarPlaylists similarPlaylists = new SimilarPlaylists(list);
        state.setSimilarPlaylists(similarPlaylists);

        // Act
        similarPlaylistsView.propertyChange(new PropertyChangeEvent(this, "similarPlaylistsViewModel", null, state));

        // Assert
        Component[] components = similarPlaylistsView.getComponents();

        // Assuming the first component is the title label
        JLabel titleLabel = (JLabel) components[0];
        assertEquals(SimilarPlaylistsViewModel.TITLE_LABEL, titleLabel.getText());

        // Assuming the rest of the components are similar playlists
        for (int i = 1; i < components.length - 1; i++) {
            JPanel playlistPanel = (JPanel) components[i];
            JLabel playlistLink = (JLabel) playlistPanel.getComponents()[0];
            assertEquals("Playlist " + i, playlistLink.getText());
        }

        // Assuming the last component is the back button
        JButton backButton = (JButton) components[components.length - 1];
        assertEquals("Back", backButton.getText());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

}
