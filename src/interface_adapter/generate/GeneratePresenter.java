package interface_adapter.generate;

import data_access.PlaylistHistoryAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.output.OutputViewModel;
import interface_adapter.output.OutputViewState;
import use_case.generate.GenerateOutputBoundary;
import use_case.generate.GenerateOutputData;
import view.MergeView;

public class GeneratePresenter implements GenerateOutputBoundary {

    private final OutputViewModel outputViewModel;

    private final MergeView mergeView;

    private ViewManagerModel viewManagerModel;

    public GeneratePresenter(ViewManagerModel viewManagerModel,
                             OutputViewModel outputViewModel,
                             MergeView mergeView) {
        this.viewManagerModel = viewManagerModel;
        this.outputViewModel = outputViewModel;
        this.mergeView = mergeView;
    }

    @Override
    public void prepareSuccessView(GenerateOutputData response) {
        OutputViewState outputViewState = outputViewModel.getState();
        outputViewState.setGeneratedPlaylist(response.getTrackList());
        this.outputViewModel.setState(outputViewState);
        outputViewModel.firePropertyChanged();

        if (PlaylistHistoryAccess.isMergeable()) {
            viewManagerModel.setActiveView(mergeView.viewName);
            viewManagerModel.firePropertyChanged();
        } else {
            viewManagerModel.setActiveView(outputViewModel.getViewName());
            viewManagerModel.firePropertyChanged();
        }
    }
}

