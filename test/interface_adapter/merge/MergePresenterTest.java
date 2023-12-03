package interface_adapter.merge;

import entity.Playlist;
import entity.Song;
import interface_adapter.ViewManagerModel;
import interface_adapter.generate.GenerateViewModel;
import interface_adapter.getSimilarPlaylists.GetSimilarPlaylistsViewModel;
import interface_adapter.getTrackDetails.GetTrackDetailsViewModel;
import interface_adapter.output.OutputViewModel;
import interface_adapter.output.OutputViewState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.merge.MergeOutputData;
import view.MenuView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergePresenterTest {

    private ViewManagerModel viewManagerModel;
    private GenerateViewModel generateViewModel;
    private GetSimilarPlaylistsViewModel getSimilarPlaylistsViewModel;
    private GetTrackDetailsViewModel getTrackDetailsViewModel;
    private OutputViewModel outputViewModel;
    private OutputView outputView;
    private MenuView menuView;
    private MergePresenter mergePresenter;

    @BeforeEach
    void setUp() {
        viewManagerModel = new ViewManagerModel();
        outputViewModel = new OutputViewModel();
        generateViewModel = new GenerateViewModel();
        getSimilarPlaylistsViewModel = new GetSimilarPlaylistsViewModel();
        getTrackDetailsViewModel = new GetTrackDetailsViewModel();
        menuView = new MenuView(generateViewModel, getSimilarPlaylistsViewModel, getTrackDetailsViewModel,
                viewManagerModel);
        outputView = new OutputView(outputViewModel, viewManagerModel, generateViewModel, menuView); // Pass null for simplicity
        mergePresenter = new MergePresenter(viewManagerModel, outputViewModel, outputView);
    }

    @Test
    void prepareSuccessView_updatesViewModelStateAndViewManager() {
        // Arrange
        List<String> songArtists1 = new ArrayList<>();
        songArtists1.add("songArtist1");
        Song song1 = new Song("songName1", songArtists1, 1, "link1", "date1", null);

        List<String> songArtists2 = new ArrayList<>();
        songArtists2.add("songArtist2");
        songArtists2.add("songArtist3");
        Song song2 = new Song("songName2", songArtists2, 100, "link2", "date2", null);

        ArrayList<Song> list1 = new ArrayList<>();
        list1.add(song1);
        list1.add(song2);

        Playlist playlist1 = new Playlist(list1);
        MergeOutputData mergeOutputData = new MergeOutputData(playlist1);

        // Act
        mergePresenter.prepareSuccessView(mergeOutputData);

        // Assert
        OutputViewState state = outputViewModel.getState();
        assertEquals(mergeOutputData.getPlaylist(), state.getGeneratedPlaylist());

        // Assuming the view manager is correctly updated
        assertEquals(outputViewModel.getViewName(), viewManagerModel.getActiveView());
    }

}

