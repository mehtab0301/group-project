package use_case.getSimilarPlaylists;

import org.junit.Assert;
import org.junit.Test;
import use_case.generate.GenerateInputBoundary;
import use_case.generate.GenerateInteractor;

import java.io.IOException;

public class getSimilarPlaylistsInteractorTest {

    @Test
    public void getSimilarPlaylistsTest() throws IOException {
        GetSimilarPlaylistsInputData getSimilarPlaylistsInputData = new GetSimilarPlaylistsInputData(
                "Bite Me");

        GetSimilarPlaylistsOutputBoundary successPresenter = new GetSimilarPlaylistsOutputBoundary() {
            @Override
            public void prepareSuccessView(GetSimilarPlaylistsOutputData getSimilarPlaylistsOutputData) {
                Assert.assertNotNull(getSimilarPlaylistsOutputData.getSimilarPlaylists());
                Assert.assertEquals(3,
                        getSimilarPlaylistsOutputData.getSimilarPlaylists().getSimilarPlaylistsLength());
            }
        };

        GetSimilarPlaylistsInputBoundary getSimilarPlaylistsInteractor = new GetSimilarPlaylistsInteractor(
                successPresenter);
        getSimilarPlaylistsInteractor.execute(getSimilarPlaylistsInputData);
    }
}
