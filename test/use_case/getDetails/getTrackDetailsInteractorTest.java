package use_case.getDetails;

import data_access.PlaylistHistoryAccess;
import org.junit.Assert;
import org.junit.Test;
import use_case.generate.*;
import use_case.getTrackDetails.*;

import java.io.IOException;

public class getTrackDetailsInteractorTest {

    @Test
    public void GetTrackDetailsTestSuccess() throws IOException {
        GetTrackDetailsInputData generateInputData = new GetTrackDetailsInputData("https://open.spotify.com/track/4gMgiXfqyzZLMhsksGmbQV");
        //Song: Another Brick in the Wall Pt.2
        GetTrackDetailsOutputBoundary successPresenter = new GetTrackDetailsOutputBoundary() {
            @Override
            public void prepareSuccessView(GetTrackDetailsOutputData getTrackDetailsOutputData) {
                Assert.assertEquals(79, getTrackDetailsOutputData.getTrackInfo().get(0));
                Assert.assertEquals("1979-11-30", getTrackDetailsOutputData.getTrackInfo().get(1));
            }
        };

        GetTrackDetailsInputBoundary getTrackDetailsInteractor = new GetTrackDetailsInteractor(successPresenter);
        getTrackDetailsInteractor.execute(generateInputData);
    }
    @Test
    public void GetTrackDetailsTestFail() throws IOException {
        GetTrackDetailsInputData generateInputData = new GetTrackDetailsInputData("https://invalid_link");
        //Song: Another Brick in the Wall Pt.2
        GetTrackDetailsOutputBoundary successPresenter = new GetTrackDetailsOutputBoundary() {
            @Override
            public void prepareSuccessView(GetTrackDetailsOutputData getTrackDetailsOutputData) {
                try {
                    getTrackDetailsOutputData.getTrackInfo().get(0);
                    assert false: "Expected Exception";
                }
                catch (ArithmeticException e){
                    assert true: "good";
            }
        };
    };
}}
