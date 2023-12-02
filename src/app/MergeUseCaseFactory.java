package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.generate.GenerateViewModel;
import interface_adapter.merge.MergeController;
import interface_adapter.merge.MergePresenter;
import interface_adapter.output.OutputViewModel;
import use_case.merge.MergeInputBoundary;
import use_case.merge.MergeInteractor;
import use_case.merge.MergeOutputBoundary;
import view.MenuView;
import view.MergeView;
import view.OutputView;

import javax.swing.*;
import java.io.IOException;

public class MergeUseCaseFactory {

    public static MergeView create(ViewManagerModel viewManagerModel,
                                   GenerateViewModel generateViewModel,
                                   OutputViewModel outputViewModel,
                                   OutputView outputView,
                                   MenuView menuView) {
        try {
            MergeController mergeController = createUserMergeUseCase(viewManagerModel, outputViewModel, outputView);
            return new MergeView(outputViewModel, viewManagerModel, generateViewModel, mergeController, menuView);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "There's an error.");
        }

        return null;
    }

    private static MergeController createUserMergeUseCase(ViewManagerModel viewManagerModel,
                                                      OutputViewModel outputViewModel,
                                                      OutputView outputView)
            throws IOException {

        MergeOutputBoundary mergeOutputBoundary = new MergePresenter(viewManagerModel, outputViewModel, outputView);

        MergeInputBoundary userMergeInteractor = new MergeInteractor(mergeOutputBoundary);

        return new MergeController(userMergeInteractor);
    }
}
