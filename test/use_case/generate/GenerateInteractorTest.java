package use_case.generate;

import data_access.PlaylistHistoryAccess;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class GenerateInteractorTest {

    @Test
    public void GeneratePlaylistTest() throws IOException {
        GenerateInputData generateInputData = new GenerateInputData("anime",
                10, 0.1F, 0.1F, 0.1F, 0.1F, 3);

        GenerateOutputBoundary successPresenter = new GenerateOutputBoundary() {
            @Override
            public void prepareSuccessView(GenerateOutputData generateOutputData) {
                Assert.assertEquals(3, generateOutputData.getTrackList().getLength());
                Assert.assertNotNull(PlaylistHistoryAccess.getPlaylists());
                Assert.assertEquals(1, PlaylistHistoryAccess.getPlaylists().size());
            }
        };

        GenerateInputBoundary generateInteractor = new GenerateInteractor(successPresenter);
        generateInteractor.execute(generateInputData);
    }
}
