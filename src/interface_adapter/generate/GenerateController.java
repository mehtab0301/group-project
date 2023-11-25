package interface_adapter.generate;

import use_case.generate.GenerateInputBoundary;
import use_case.generate.GenerateInputData;

import java.io.IOException;

public class GenerateController {

    final GenerateInputBoundary userGenerateUseCaseInteractor;

    public GenerateController(GenerateInputBoundary userGenerateUseCaseInteractor) {
        this.userGenerateUseCaseInteractor = userGenerateUseCaseInteractor;
    }

    public void execute(String genre, int popularity, float danceability, float valence, float speechiness,
                        float energy, int numberOfTracks) throws IOException {
        GenerateInputData generateInputData = new GenerateInputData(genre, popularity, danceability, valence, speechiness,
                energy, numberOfTracks);

        userGenerateUseCaseInteractor.execute(generateInputData);
    }
}
