package use_case.getSimilarPlaylists;

import use_case.generate.GenerateOutputData;

import java.io.IOException;
import java.util.List;

public class SimPlaylistInteractor implements SimInputBoundary{

    final CreateSimPlaylistsInteractor simplaylists;

    final SimOutputBoundary output;

    public SimPlaylistInteractor(CreateSimPlaylistsInteractor simplaylists, SimOutputBoundary output) {
        this.simplaylists = simplaylists;
        this.output = output;
    }

    @Override
    public void execute(SimInputData SiminputData) throws IOException {
        List<String> output = simplaylists.createSimilarPlaylists(SiminputData.name);

        SimOutputData similar = new SimOutputData(output);
        //userPresenter.prepareSuccessView(generateOutputData);


    }
}
