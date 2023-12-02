package interface_adapter.getSimilarPlaylists;

import interface_adapter.ViewManagerModel;
import interface_adapter.similarPlaylists.SimilarPlaylistsState;
import interface_adapter.similarPlaylists.SimilarPlaylistsViewModel;
import use_case.getSimilarPlaylists.GetSimilarPlaylistsOutputBoundary;
import use_case.getSimilarPlaylists.GetSimilarPlaylistsOutputData;

public class GetSimilarPlaylistsPresenter implements GetSimilarPlaylistsOutputBoundary {

    private final SimilarPlaylistsViewModel similarPlaylistsViewModel;

    private ViewManagerModel viewManagerModel;

    public GetSimilarPlaylistsPresenter(ViewManagerModel viewManagerModel,
                                        SimilarPlaylistsViewModel similarPlaylistsViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.similarPlaylistsViewModel = similarPlaylistsViewModel;
    }

    @Override
    public void prepareSuccessView(GetSimilarPlaylistsOutputData response) {
        SimilarPlaylistsState similarPlaylistsState = similarPlaylistsViewModel.getState();
        similarPlaylistsState.setSimilarPlaylists(response.getSimilarPlaylists());
        this.similarPlaylistsViewModel.setState(similarPlaylistsState);
        similarPlaylistsViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(similarPlaylistsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
