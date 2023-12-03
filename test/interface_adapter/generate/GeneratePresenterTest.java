package interface_adapter.generate;

import data_access.PlaylistHistoryAccess;
import entity.Playlist;
import entity.Song;
import interface_adapter.ViewManagerModel;
import interface_adapter.getSimilarPlaylists.GetSimilarPlaylistsViewModel;
import interface_adapter.getTrackDetails.GetTrackDetailsViewModel;
import interface_adapter.merge.MergeController;
import interface_adapter.output.OutputViewModel;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.generate.GenerateOutputData;
import use_case.merge.*;
import view.MenuView;
import view.MergeView;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GeneratePresenterTest {

    private OutputViewModel outputViewModel;
    private GenerateViewModel generateViewModel;
    private GetTrackDetailsViewModel getTrackDetailsViewModel;
    private GetSimilarPlaylistsViewModel getSimilarPlaylistsViewModel;
    private MenuView menuView;
    private MergeView mergeView;
    private ViewManagerModel viewManagerModel;
    private GeneratePresenter generatePresenter;
    private MergeController mergeController;

    @BeforeEach
    void setUp() throws IOException {
        List<String> songArtists1 = new ArrayList<>();
        songArtists1.add("songArtist1");
        Song song1 = new Song("songName1", songArtists1, 1, "link1", "date1", null);

        List<String> songArtists2 = new ArrayList<>();
        songArtists2.add("songArtist2");
        songArtists2.add("songArtist3");
        Song song2 = new Song("songName2", songArtists2, 100, "link2", "date2", null);

        List<String> songArtists3 = new ArrayList<>();
        songArtists3.add("songArtist4");
        songArtists3.add("songArtist5");
        Song song3 = new Song("songName3", songArtists3, 50, "link3", "date3", null);

        List<String> songArtists4 = new ArrayList<>();
        songArtists3.add("songArtist6");
        songArtists3.add("songArtist7");
        Song song4 = new Song("songName4", songArtists4, 29, "link4", "date4", null);

        ArrayList<Song> list1 = new ArrayList<>();
        list1.add(song1);
        list1.add(song2);

        ArrayList<Song> list2 = new ArrayList<>();
        list2.add(song3);

        ArrayList<Song> list3 = new ArrayList<>();
        list3.add(song4);

        Playlist playlist1 = new Playlist(list1);
        Playlist playlist2 = new Playlist(list2);
        Playlist playlist3 = new Playlist(list2);

        ArrayList<Playlist> playlistsHistory = new ArrayList<>();
        playlistsHistory.add(playlist1);
        PlaylistHistoryAccess.setHistory(playlistsHistory);
        PlaylistHistoryAccess.addToHistory(playlist2);
        PlaylistHistoryAccess.addToHistory(playlist3);

        ArrayList<Playlist> playlistsHistoryUpdate = new ArrayList<>();
        playlistsHistoryUpdate.add(playlist3);

        MergeInputData mergeInputData = new MergeInputData(playlistsHistoryUpdate);
        MergeOutputBoundary successPresenter = new MergeOutputBoundary() {
            @Override
            public void prepareSuccessView(MergeOutputData mergeOutputData) {
                Assert.assertNotNull(mergeOutputData.getPlaylist());
                Assert.assertEquals(3, PlaylistHistoryAccess.getPlaylists().size());
            }
        };

        MergeInputBoundary mergeInteractor = new MergeInteractor(successPresenter);
        mergeInteractor.execute(mergeInputData);

        mergeController = new MergeController(mergeInteractor);

        outputViewModel = new OutputViewModel();
        generateViewModel = new GenerateViewModel();
        getSimilarPlaylistsViewModel = new GetSimilarPlaylistsViewModel();
        getTrackDetailsViewModel = new GetTrackDetailsViewModel();
        menuView = new MenuView(generateViewModel, getSimilarPlaylistsViewModel, getTrackDetailsViewModel,
                viewManagerModel);
        mergeView = new MergeView(outputViewModel, viewManagerModel, generateViewModel, mergeController, menuView);
        viewManagerModel = new ViewManagerModel();
        generatePresenter = new GeneratePresenter(viewManagerModel, outputViewModel, mergeView);
    }

    @Test
    void prepareSuccessView() {
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

        // Arrange
        GenerateOutputData generateOutputData = new GenerateOutputData(playlist1);

        // Act
        generatePresenter.prepareSuccessView(generateOutputData);

        // Assert
        assertEquals(generateOutputData.getTrackList(), outputViewModel.getState().getGeneratedPlaylist());

        if (PlaylistHistoryAccess.isMergeable()) {
            assertEquals("merge", viewManagerModel.getActiveView());
        } else {
            assertEquals(outputViewModel.getViewName(), viewManagerModel.getActiveView());
        }
    }
}
