package interface_adapter.getSimilarPlaylists;

import entity.SimilarPlaylists;
import interface_adapter.ViewManagerModel;
import interface_adapter.similarPlaylists.SimilarPlaylistsState;
import interface_adapter.similarPlaylists.SimilarPlaylistsViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.getSimilarPlaylists.GetSimilarPlaylistsOutputData;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetSimilarPlaylistsPresenterTest {

    private ViewManagerModel viewManagerModel;
    private SimilarPlaylistsViewModel similarPlaylistsViewModel;
    private GetSimilarPlaylistsPresenter getSimilarPlaylistsPresenter;

    @BeforeEach
    void setUp() {
        viewManagerModel = new ViewManagerModel();
        similarPlaylistsViewModel = new SimilarPlaylistsViewModel();
        getSimilarPlaylistsPresenter = new GetSimilarPlaylistsPresenter(viewManagerModel, similarPlaylistsViewModel);
    }

    @Test
    void prepareSuccessView_updatesViewModelStateAndViewManager() {
        // Arrange
        ArrayList<String> list = new ArrayList<>();
        list.add("Playlist1");
        list.add("Playlist2");
        SimilarPlaylists similarPlaylists = new SimilarPlaylists(list);
        GetSimilarPlaylistsOutputData response = new GetSimilarPlaylistsOutputData(similarPlaylists);

        // Act
        getSimilarPlaylistsPresenter.prepareSuccessView(response);

        // Assert
        SimilarPlaylistsState state = similarPlaylistsViewModel.getState();
        assertEquals(2, state.getSimilarPlaylists().getSimilarPlaylistsLength()); // Assuming it updates an array of playlists

        // Assuming the view manager is correctly updated
        assertEquals(similarPlaylistsViewModel.getViewName(), viewManagerModel.getActiveView());
    }

}
