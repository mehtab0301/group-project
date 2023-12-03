package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.generate.GenerateController;
import interface_adapter.generate.GenerateViewModel;
import interface_adapter.getSimilarPlaylists.GetSimilarPlaylistsViewModel;
import interface_adapter.getTrackDetails.GetTrackDetailsViewModel;
import interface_adapter.merge.MergeController;
import interface_adapter.output.OutputViewModel;
import interface_adapter.similarPlaylists.SimilarPlaylistsViewModel;
import org.junit.jupiter.api.Test;
import view.GenerateView;
import view.MenuView;
import view.MergeView;

import javax.swing.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GenerateUseCaseFactoryTest {

    @Test
    void create_returnsGenerateView() {
        // Arrange
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        GenerateViewModel generateViewModel = new GenerateViewModel();
        OutputViewModel outputViewModel = new OutputViewModel();
        GetTrackDetailsViewModel getTrackDetailsViewModel = new GetTrackDetailsViewModel();
        GetSimilarPlaylistsViewModel getSimilarPlaylistsViewModel = new GetSimilarPlaylistsViewModel();
        MergeController mergeController = new MergeController(null);
        MenuView menuView = new MenuView(generateViewModel, getSimilarPlaylistsViewModel,getTrackDetailsViewModel,
                viewManagerModel);
        MergeView mergeView = new MergeView(outputViewModel, viewManagerModel, generateViewModel,
                mergeController, menuView);

        // Act
        GenerateView generateView = GenerateUseCaseFactory.create(viewManagerModel, generateViewModel,
                outputViewModel, mergeView);

        // Assert
        assertNotNull(generateView);
    }

    @Test
    void create_handlesIOException() {
        // Arrange
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        GenerateViewModel generateViewModel = new GenerateViewModel();
        OutputViewModel outputViewModel = new OutputViewModel();
        GetTrackDetailsViewModel getTrackDetailsViewModel = new GetTrackDetailsViewModel();
        GetSimilarPlaylistsViewModel getSimilarPlaylistsViewModel = new GetSimilarPlaylistsViewModel();
        MergeController mergeController = new MergeController(null);
        MenuView menuView = new MenuView(generateViewModel, getSimilarPlaylistsViewModel,getTrackDetailsViewModel,
                viewManagerModel);
        MergeView mergeView = new MergeView(outputViewModel, viewManagerModel, generateViewModel,
                mergeController, menuView);

        // Act and Assert
        assertThrows(RuntimeException.class, () -> GenerateUseCaseFactory.create(viewManagerModel, generateViewModel,
                outputViewModel, mergeView));
    }

    @Test
    void createUserGenerateUseCase_returnsGenerateController() {
        // Arrange
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        OutputViewModel outputViewModel = new OutputViewModel();
        GenerateViewModel generateViewModel = new GenerateViewModel();
        GetTrackDetailsViewModel getTrackDetailsViewModel = new GetTrackDetailsViewModel();
        GetSimilarPlaylistsViewModel getSimilarPlaylistsViewModel = new GetSimilarPlaylistsViewModel();
        MergeController mergeController = new MergeController(null);
        MenuView menuView = new MenuView(generateViewModel, getSimilarPlaylistsViewModel,getTrackDetailsViewModel,
                viewManagerModel);
        MergeView mergeView = new MergeView(outputViewModel, viewManagerModel, generateViewModel,
                mergeController, menuView);

        // Act
        GenerateController generateController = null;
        try {
            generateController = GenerateUseCaseFactory.createUserGenerateUseCase(viewManagerModel, outputViewModel,
                    mergeView);
        } catch (IOException e) {
            // IOException is not expected in this test case
        }

        // Assert
        assertNotNull(generateController);
    }

    @Test
    void createUserGenerateUseCase_handlesIOException() {
        // Arrange
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        OutputViewModel outputViewModel = new OutputViewModel();
        GenerateViewModel generateViewModel = new GenerateViewModel();
        GetTrackDetailsViewModel getTrackDetailsViewModel = new GetTrackDetailsViewModel();
        GetSimilarPlaylistsViewModel getSimilarPlaylistsViewModel = new GetSimilarPlaylistsViewModel();
        MergeController mergeController = new MergeController(null);
        MenuView menuView = new MenuView(generateViewModel, getSimilarPlaylistsViewModel,getTrackDetailsViewModel,
                viewManagerModel);
        MergeView mergeView = new MergeView(outputViewModel, viewManagerModel, generateViewModel,
                mergeController, menuView);

        // Act and Assert
        assertThrows(IOException.class, () -> GenerateUseCaseFactory.createUserGenerateUseCase(viewManagerModel,
                outputViewModel, mergeView));
    }
}
