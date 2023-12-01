package interface_adapter.merge;

import entity.Playlist;
import use_case.merge.MergeInputBoundary;
import use_case.merge.MergeInputData;

import java.io.IOException;
import java.util.ArrayList;

public class MergeController {

    final MergeInputBoundary mergeInteractor;

    public MergeController(MergeInputBoundary mergeInputBoundary) {
        this.mergeInteractor = mergeInputBoundary;
    }

    public void execute(ArrayList<Playlist> playlistHistory) throws IOException {
        MergeInputData mergeInputData = new MergeInputData(playlistHistory);
        mergeInteractor.execute(mergeInputData);
    }
}
