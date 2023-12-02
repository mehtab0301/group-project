package use_case.getSimilarPlaylists;

import entity.SimilarPlaylists;

import java.io.IOException;

public class GetSimilarPlaylistsInteractor implements GetSimilarPlaylistsInputBoundary {

    final GetSimilarPlaylistsOutputBoundary getSimilarPlaylistsPresenter;

    public GetSimilarPlaylistsInteractor(GetSimilarPlaylistsOutputBoundary getSimilarPlaylistsOutputBoundary) {
        this.getSimilarPlaylistsPresenter = getSimilarPlaylistsOutputBoundary;
    }

    @Override
    public void execute(GetSimilarPlaylistsInputData getSimilarPlaylistsInputData) throws IOException {
        SimilarPlaylists output = GetSimilarPlaylistsHelper.createSimilarPlaylists(
                getSimilarPlaylistsInputData.getSongName());

        GetSimilarPlaylistsOutputData getSimilarPlaylistsOutputData = new GetSimilarPlaylistsOutputData(output);
        getSimilarPlaylistsPresenter.prepareSuccessView(getSimilarPlaylistsOutputData);
    }
}
