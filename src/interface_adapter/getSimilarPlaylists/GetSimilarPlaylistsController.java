package interface_adapter.getSimilarPlaylists;

import use_case.getSimilarPlaylists.GetSimilarPlaylistsInputBoundary;
import use_case.getSimilarPlaylists.GetSimilarPlaylistsInputData;

import java.io.IOException;

public class GetSimilarPlaylistsController {

    final GetSimilarPlaylistsInputBoundary userGetSimilarPlaylistsUseCaseInteractor;

    public GetSimilarPlaylistsController(GetSimilarPlaylistsInputBoundary userGetSimilarPlaylistsUseCaseInteractor) {
        this.userGetSimilarPlaylistsUseCaseInteractor = userGetSimilarPlaylistsUseCaseInteractor;
    }

    public void execute(String songName) throws IOException {
        GetSimilarPlaylistsInputData getSimilarPlaylistsInputData = new GetSimilarPlaylistsInputData(songName);

        userGetSimilarPlaylistsUseCaseInteractor.execute(getSimilarPlaylistsInputData);
    }
}
