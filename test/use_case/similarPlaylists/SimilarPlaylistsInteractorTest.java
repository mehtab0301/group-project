package use_case.similarPlaylists;

import org.junit.Assert;
import org.junit.Test;
import use_case.getSimilarPlaylists.*;
import use_case.getTrackDetails.*;

import java.io.IOException;

public class SimilarPlaylistsInteractorTest {
    @Test
    public void GetSimilarPlaylistsTestSuccess() throws IOException {
        GetSimilarPlaylistsInputData getSimilarPlaylistsInputDataInputData = new GetSimilarPlaylistsInputData("Another Brick in the Wall");
        //Song: Another Brick in the Wall Pt.2
        GetSimilarPlaylistsOutputBoundary successPresenter = new GetSimilarPlaylistsOutputBoundary() {
            @Override
            public void prepareSuccessView(GetSimilarPlaylistsOutputData getSimilarPlaylistsOutputData) {
                Assert.assertEquals(3, getSimilarPlaylistsOutputData.getSimilarPlaylists().getSimilarPlaylistsLength());
            }
        };

        GetSimilarPlaylistsInputBoundary getTrackDetailsInteractor = new GetSimilarPlaylistsInteractor(successPresenter);
        getTrackDetailsInteractor.execute(getSimilarPlaylistsInputDataInputData);
    }
    @Test
    public void GetSimilarPlaylistsTestFail() throws IOException {
        GetSimilarPlaylistsInputData getSimilarPlaylistsInputDataInputData = new GetSimilarPlaylistsInputData("");
        //Song: Another Brick in the Wall Pt.2
        GetSimilarPlaylistsOutputBoundary successPresenter = new GetSimilarPlaylistsOutputBoundary() {
            @Override
            public void prepareSuccessView(GetSimilarPlaylistsOutputData getSimilarPlaylistsOutputData) {
                try {
                    getSimilarPlaylistsOutputData.getSimilarPlaylists().getSimilarPlaylistsLength();
                    assert false: "Expected Exception";
                }
                catch (ArithmeticException e){
                    assert true: "good";
            }
        };
    };
}}
