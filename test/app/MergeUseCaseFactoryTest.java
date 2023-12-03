package app;

import app.MergeUseCaseFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.generate.GenerateViewModel;
import interface_adapter.getSimilarPlaylists.GetSimilarPlaylistsViewModel;
import interface_adapter.getTrackDetails.GetTrackDetailsViewModel;
import interface_adapter.output.OutputViewModel;
import org.junit.jupiter.api.Test;
import use_case.merge.*;
import view.GetSimilarPlaylistsView;
import view.MenuView;
import view.MergeView;
import view.OutputView;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class MergeUseCaseFactoryTest {

    @Test
    void create_returnsMergeView() {
        // Arrange
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        GenerateViewModel generateViewModel = new GenerateViewModel();
        GetSimilarPlaylistsViewModel getSimilarPlaylistsViewModel = new GetSimilarPlaylistsViewModel();
        GetTrackDetailsViewModel getTrackDetailsViewModel = new GetTrackDetailsViewModel();
        OutputViewModel outputViewModel = new OutputViewModel();
        MenuView menuView = new MenuView(generateViewModel, getSimilarPlaylistsViewModel, getTrackDetailsViewModel,
                viewManagerModel);
        OutputView outputView = new OutputView(outputViewModel, viewManagerModel, generateViewModel, menuView);

        // Act
        MergeView mergeView = MergeUseCaseFactory.create(viewManagerModel, generateViewModel, outputViewModel, outputView, menuView);

        // Assert
        assertNotNull(mergeView);
    }

    // This is a simple fake implementation for testing purposes
    private static class FakeMergeOutputBoundary implements MergeOutputBoundary {
        @Override
        public void prepareSuccessView(MergeOutputData mergeOutputData) {
            // Simulate success view preparation
            JOptionPane.showMessageDialog(null, "Merge success");
        }
    }

    // This is a simple fake implementation for testing purposes
    private static class FakeMergeInputBoundary implements MergeInputBoundary {
        @Override
        public void execute(MergeInputData mergeInputData) {
            // Simulate merge execution
        }
    }
}
