package view.trackDetailsView;

import interface_adapter.ViewManagerModel;
import interface_adapter.generate.GenerateViewModel;
import interface_adapter.getSimilarPlaylists.GetSimilarPlaylistsViewModel;
import interface_adapter.getTrackDetails.GetTrackDetailsViewModel;
import interface_adapter.trackDetails.TrackDetailsState;
import interface_adapter.trackDetails.TrackDetailsViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.MenuView;
import view.TrackDetailsView;

import javax.swing.*;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrackDetailsViewTest implements PropertyChangeListener {

    private TrackDetailsViewModel trackDetailsViewModel;
    private GenerateViewModel generateViewModel;
    private GetSimilarPlaylistsViewModel getSimilarPlaylistsViewModel;
    private GetTrackDetailsViewModel getTrackDetailsViewModel;
    private ViewManagerModel viewManagerModel;
    private MenuView menuView;
    private TrackDetailsView trackDetailsView;

    @BeforeEach
    void setUp() {
        trackDetailsViewModel = new TrackDetailsViewModel();
        viewManagerModel = new ViewManagerModel();
        generateViewModel = new GenerateViewModel();
        getSimilarPlaylistsViewModel = new GetSimilarPlaylistsViewModel();
        getTrackDetailsViewModel = new GetTrackDetailsViewModel();
        menuView = new MenuView(generateViewModel, getSimilarPlaylistsViewModel, getTrackDetailsViewModel,
                viewManagerModel);
        trackDetailsView = new TrackDetailsView(trackDetailsViewModel, viewManagerModel, menuView);
    }

    @Test
    void propertyChange() {
        // Arrange
        TrackDetailsState state = new TrackDetailsState();
        ArrayList<Object> list = new ArrayList<>();
        list.add(75);
        list.add("2022-01-01");
        state.setTrackInfo(list);

        // Act
        trackDetailsView.propertyChange(new PropertyChangeEvent(this, "trackDetailsViewModel", null, state));

        // Assert
        Component[] components = trackDetailsView.getComponents();

        // Assuming the first component is the title label
        JLabel titleLabel = (JLabel) components[0];
        assertEquals(TrackDetailsViewModel.TITLE_LABEL, titleLabel.getText());

        // Assuming the second component is the popularity panel
        JPanel popularityPanel = (JPanel) components[1];
        JLabel popularityInfo = (JLabel) popularityPanel.getComponents()[0];
        assertEquals("The popularity of this song is: 75", popularityInfo.getText());

        // Assuming the third component is the release date panel
        JPanel releaseDatePanel = (JPanel) components[2];
        JLabel releaseDateInfo = (JLabel) releaseDatePanel.getComponents()[0];
        assertEquals("The release date of this song is: 2022-01-01", releaseDateInfo.getText());

        // Assuming the last component is the back button
        JButton backButton = (JButton) components[3];
        assertEquals("Back", backButton.getText());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

}