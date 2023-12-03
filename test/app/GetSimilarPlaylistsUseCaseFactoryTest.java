package app;

import app.GetSimilarPlaylistsUseCaseFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.getSimilarPlaylists.GetSimilarPlaylistsController;
import interface_adapter.getSimilarPlaylists.GetSimilarPlaylistsViewModel;
import interface_adapter.similarPlaylists.SimilarPlaylistsViewModel;
import org.junit.jupiter.api.Test;
import view.GetSimilarPlaylistsView;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GetSimilarPlaylistsUseCaseFactoryTest {

    @Test
    void create_returnsGetSimilarPlaylistsView() {
        // Arrange
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        GetSimilarPlaylistsViewModel getSimilarPlaylistsViewModel = new GetSimilarPlaylistsViewModel();
        SimilarPlaylistsViewModel similarPlaylistsViewModel = new SimilarPlaylistsViewModel();

        // Act
        GetSimilarPlaylistsView getSimilarPlaylistsView = GetSimilarPlaylistsUseCaseFactory.create(viewManagerModel,
                getSimilarPlaylistsViewModel, similarPlaylistsViewModel);

        // Assert
        assertNotNull(getSimilarPlaylistsView);
    }

    @Test
    void createUserGetSimilarPlaylistsUseCase_returnsGetSimilarPlaylistsController() {
        // Arrange
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SimilarPlaylistsViewModel similarPlaylistsViewModel = new SimilarPlaylistsViewModel();

        // Act
        GetSimilarPlaylistsController getSimilarPlaylistsController = GetSimilarPlaylistsUseCaseFactory
                .createUserGetSimilarPlaylistsUseCase(viewManagerModel, similarPlaylistsViewModel);

        // Assert
        assertNotNull(getSimilarPlaylistsController);
    }
}
