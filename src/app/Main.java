package app;

import data_access.UserDataAccessObject;
import entity.CommonUserFactory;
import interface_adapter.generate.GenerateViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.output.OutputViewModel;
import interface_adapter.signup.SignupViewModel;
import view.*;
import interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JFrame application = new JFrame("App");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        SignupViewModel signupViewModel = new SignupViewModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        GenerateViewModel generateViewModel = new GenerateViewModel();
        OutputViewModel outputViewModel = new OutputViewModel();

        UserDataAccessObject userDataAccessObject = new UserDataAccessObject(new CommonUserFactory());

        MenuView menuView = new MenuView(generateViewModel, viewManagerModel);
        views.add(menuView, menuView.viewName);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, menuView,
                userDataAccessObject);
        views.add(loginView, loginView.viewName);

        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel,
                userDataAccessObject);
        views.add(signupView, signupView.viewName);

        OutputView outputView = new OutputView(outputViewModel, viewManagerModel, generateViewModel);
        views.add(outputView, outputView.viewName);

        MergeView mergeView = MergeUseCaseFactory.create(viewManagerModel, generateViewModel, outputViewModel,
                outputView);
        views.add(mergeView, mergeView.viewName);

        GenerateView generateView = GenerateUseCaseFactory.create(viewManagerModel,
                generateViewModel, outputViewModel, mergeView);
        views.add(generateView, generateView.viewName);

        viewManagerModel.setActiveView(menuView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}