package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.generate.GenerateController;
import interface_adapter.generate.GeneratePresenter;
import interface_adapter.generate.GenerateViewModel;
import interface_adapter.output.OutputViewModel;
import use_case.generate.*;
import view.GenerateView;
import view.MergeView;

import javax.swing.*;
import java.io.IOException;

public class GenerateUseCaseFactory {

    public static GenerateView create(ViewManagerModel viewManagerModel,
                                      GenerateViewModel generateViewModel,
                                      OutputViewModel outputViewModel,
                                      MergeView mergeView) {

        try {
            GenerateController generateController = createUserGenerateUseCase(viewManagerModel, outputViewModel,
                    mergeView);
            return new GenerateView(generateController, generateViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "There's an error.");
        }

        return null;
    }

    private static GenerateController createUserGenerateUseCase(ViewManagerModel viewManagerModel,
                                                                OutputViewModel outputViewModel,
                                                                MergeView mergeView)
            throws IOException {

        GenerateOutputBoundary generateOutputBoundary = new GeneratePresenter(viewManagerModel, outputViewModel,
                mergeView);

        GenerateInputBoundary userGenerateInteractor = new GenerateInteractor(generateOutputBoundary);

        return new GenerateController(userGenerateInteractor);
    }
}

