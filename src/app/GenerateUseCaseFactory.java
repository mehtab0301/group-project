package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.generate.GenerateController;
import interface_adapter.generate.GeneratePresenter;
import interface_adapter.generate.GenerateViewModel;
import use_case.generate.*;
import view.GenerateView;

import javax.swing.*;
import java.io.IOException;

public class GenerateUseCaseFactory {

    private GenerateUseCaseFactory() {}

    public static GenerateView create(ViewManagerModel viewManagerModel, GenerateViewModel generateViewModel) {

        try {
            GenerateController generateController = createUserGenerateUseCase(viewManagerModel, generateViewModel);
            return new GenerateView(generateController, generateViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "There's an error.");
        }

        return null;
    }

    private static GenerateController createUserGenerateUseCase(ViewManagerModel viewManagerModel,
                                                                GenerateViewModel generateViewModel)
            throws IOException {

        GenerateOutputBoundary generateOutputBoundary = new GeneratePresenter(viewManagerModel, generateViewModel);

        CreatePlaylistHelper createPlaylistHelper = new CreatePlaylistHelper();

        GenerateInputBoundary userGenerateInteractor = new GenerateInteractor(generateOutputBoundary,
                createPlaylistHelper);

        return new GenerateController(userGenerateInteractor);
    }
}
