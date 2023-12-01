package use_case.generate;

import data_access.PlaylistHistoryAccess;
import entity.Playlist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenerateInteractor implements GenerateInputBoundary{
    final GenerateOutputBoundary userPresenter;

    public GenerateInteractor(GenerateOutputBoundary generateOutputBoundary) {
        this.userPresenter = generateOutputBoundary;
    }

    @Override
    public void execute(GenerateInputData generateInputData) throws IOException {
        Playlist output = CreatePlaylistHelper.generatePlaylists(generateInputData.getGenre(),
                generateInputData.getPopularity(),
                generateInputData.getDanceability(),
                generateInputData.getValence(),
                generateInputData.getSpeechiness(),
                generateInputData.getEnergy(),
                generateInputData.getNumberOfTracks());

        if (!PlaylistHistoryAccess.getPlaylists().isEmpty()) {
            PlaylistHistoryAccess.addToHistory(output);
        } else {
            ArrayList<Playlist> playlistArrayList = new ArrayList<>();
            playlistArrayList.add(output);
            PlaylistHistoryAccess.setHistory(playlistArrayList);
        }

        GenerateOutputData generateOutputData = new GenerateOutputData(output);
        userPresenter.prepareSuccessView(generateOutputData);
    }
}
