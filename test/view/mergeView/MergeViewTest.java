package view.mergeView;

import interface_adapter.ViewManagerModel;
import interface_adapter.generate.GenerateViewModel;
import interface_adapter.getSimilarPlaylists.GetSimilarPlaylistsViewModel;
import interface_adapter.getTrackDetails.GetTrackDetailsViewModel;
import interface_adapter.merge.MergeController;
import interface_adapter.output.OutputViewModel;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.MenuView;
import view.MergeView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

class MergeViewTest {

    private OutputViewModel outputViewModel;
    private ViewManagerModel viewManagerModel;
    private GenerateViewModel generateViewModel;
    private MergeController mergeController;
    private MenuView menuView;
    private MergeView mergeView;

    @BeforeEach
    void setUp() {
        OutputViewModel outputViewModel = new OutputViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        GenerateViewModel generateViewModel = new GenerateViewModel();
        MergeController mergeController = new MergeController(null);
        MenuView menuView = new MenuView(generateViewModel,
                new GetSimilarPlaylistsViewModel(),
                new GetTrackDetailsViewModel(),
                viewManagerModel);

        mergeView = new MergeView(outputViewModel, viewManagerModel, generateViewModel, mergeController, menuView);
    }

    @Test
    void testBackButtonAction() {
        JButton backButton = findButton(mergeView, "Back");
        Assert.assertNotNull(backButton);

        // Simulate a button click
        backButton.doClick();
    }

    @Test
    void testMergeButtonAction() throws IOException {
        JButton mergeButton = findButton(mergeView, "Merge with previous playlist(s)");
        Assert.assertNotNull(mergeButton);

        // Simulate a button click
        mergeButton.doClick();
    }

    @Test
    void testGenerateAgainButtonAction() {
        JButton generateAgainButton = findButton(mergeView, OutputViewModel.GENERATE_ANOTHER_BUTTON_LABEL);
        Assert.assertNotNull(generateAgainButton);

        // Simulate a button click
        generateAgainButton.doClick();
    }

    // Helper method to find a button in the MergeView
    private JButton findButton(Container container, String buttonText) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                if (button.getText().equals(buttonText)) {
                    return button;
                }
            } else if (component instanceof Container) {
                JButton button = findButton((Container) component, buttonText);
                if (button != null) {
                    return button;
                }
            }
        }
        return null;
    }
}

