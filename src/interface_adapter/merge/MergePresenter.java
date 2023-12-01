package interface_adapter.merge;

import interface_adapter.ViewManagerModel;
import interface_adapter.output.OutputViewModel;
import interface_adapter.output.OutputViewState;
import use_case.merge.MergeOutputBoundary;
import use_case.merge.MergeOutputData;
import view.OutputView;

public class MergePresenter implements MergeOutputBoundary {
    private final OutputViewModel outputViewModel;
    private ViewManagerModel viewManagerModel;
    private final OutputView outputView;

    public MergePresenter(ViewManagerModel viewManagerModel,
                          OutputViewModel outputViewModel,
                          OutputView outputView) {
        this.viewManagerModel = viewManagerModel;
        this.outputViewModel = outputViewModel;
        this.outputView = outputView;
    }

    @Override
    public void prepareSuccessView(MergeOutputData mergeOutputData) {
        OutputViewState outputViewState = outputViewModel.getState();
        outputViewState.setGeneratedPlaylist(mergeOutputData.getPlaylist());
        this.outputViewModel.setState(outputViewState);
        outputViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(outputViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
