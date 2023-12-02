package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.getSimilarPlaylists.GetSimilarPlaylistsController;
import interface_adapter.getSimilarPlaylists.GetSimilarPlaylistsPresenter;
import interface_adapter.getSimilarPlaylists.GetSimilarPlaylistsViewModel;
import interface_adapter.similarPlaylists.SimilarPlaylistsViewModel;
import use_case.getSimilarPlaylists.GetSimilarPlaylistsInputBoundary;
import use_case.getSimilarPlaylists.GetSimilarPlaylistsInteractor;
import use_case.getSimilarPlaylists.GetSimilarPlaylistsOutputBoundary;
import view.GetSimilarPlaylistsView;

public class GetSimilarPlaylistsUseCaseFactory {

    public static GetSimilarPlaylistsView create(ViewManagerModel viewManagerModel,
                                              GetSimilarPlaylistsViewModel getSimilarPlaylistsViewModel,
                                              SimilarPlaylistsViewModel similarPlaylistsViewModel) {
        GetSimilarPlaylistsController getSimilarPlaylistsController = createUserGetSimilarPlaylistsUseCase(
                viewManagerModel, similarPlaylistsViewModel);
        return new GetSimilarPlaylistsView(getSimilarPlaylistsController, getSimilarPlaylistsViewModel);
    }

    private static GetSimilarPlaylistsController createUserGetSimilarPlaylistsUseCase(
            ViewManagerModel viewManagerModel, SimilarPlaylistsViewModel similarPlaylistsViewModel
    ) {
        GetSimilarPlaylistsOutputBoundary getSimilarPlaylistsOutputBoundary = new GetSimilarPlaylistsPresenter(
                viewManagerModel, similarPlaylistsViewModel);

        GetSimilarPlaylistsInputBoundary getSimilarPlaylistsInteractor = new GetSimilarPlaylistsInteractor(
                getSimilarPlaylistsOutputBoundary);

        return new GetSimilarPlaylistsController(getSimilarPlaylistsInteractor);
    }
}
