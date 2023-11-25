package interface_adapter.generate;

import interface_adapter.ViewManagerModel;
import use_case.generate.GenerateOutputBoundary;
import use_case.generate.GenerateOutputData;

public class GeneratePresenter implements GenerateOutputBoundary {

    private final GenerateViewModel generateViewModel;

    private ViewManagerModel viewManagerModel;

    public GeneratePresenter(ViewManagerModel viewManagerModel,
                             GenerateViewModel generateViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.generateViewModel = generateViewModel;
    }

    @Override
    public void prepareSuccessView(GenerateOutputData response) {
        // Once success, switch to the output view.
        // Files required: OutputState, OutputViewModel, OutputView
    }
}
