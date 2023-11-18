package app;

import interface_adapter.generate.GenerateViewModel;
import interface_adapter.login.LoginViewModel;
import view.GenerateView;
import view.LoginView;
import view.ViewManager;
import interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame application = new JFrame("App");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        GenerateViewModel generateViewModel = new GenerateViewModel();
        GenerateView generateView = new GenerateView(generateViewModel);
        views.add(generateView, generateView.viewName);

        // Temporary input formats use for changing views
        LoginViewModel loginViewModel = new LoginViewModel();
        LoginView loginView = new LoginView(loginViewModel, generateViewModel, viewManagerModel);
        views.add(loginView, loginView.viewName);

        viewManagerModel.setActiveView(loginView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}