package app;

import data_access.UserDataAccessObject;
import entity.CommonUserFactory;
import interface_adapter.generate.GenerateViewModel;
import interface_adapter.getSimilarPlaylists.GetSimilarPlaylistsViewModel;
import interface_adapter.getTrackDetails.GetTrackDetailsViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.output.OutputViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.similarPlaylists.SimilarPlaylistsViewModel;
import interface_adapter.trackDetails.TrackDetailsViewModel;
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
        GetSimilarPlaylistsViewModel getSimilarPlaylistsViewModel = new GetSimilarPlaylistsViewModel();
        SimilarPlaylistsViewModel similarPlaylistsViewModel = new SimilarPlaylistsViewModel();
        GetTrackDetailsViewModel getTrackDetailsViewModel = new GetTrackDetailsViewModel();
        TrackDetailsViewModel trackDetailsViewModel = new TrackDetailsViewModel();
        OutputViewModel outputViewModel = new OutputViewModel();

        UserDataAccessObject userDataAccessObject = new UserDataAccessObject(new CommonUserFactory());

        MenuView menuView = new MenuView(generateViewModel, getSimilarPlaylistsViewModel, getTrackDetailsViewModel,
                viewManagerModel);
        views.add(menuView, menuView.viewName);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, menuView,
                userDataAccessObject);
        views.add(loginView, loginView.viewName);

        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel,
                userDataAccessObject);
        views.add(signupView, signupView.viewName);

        OutputView outputView = new OutputView(outputViewModel, viewManagerModel, generateViewModel);
        views.add(outputView, outputView.viewName);

        SimilarPlaylistsView similarPlaylistsView = new SimilarPlaylistsView(similarPlaylistsViewModel,
                viewManagerModel, menuView);
        views.add(similarPlaylistsView, similarPlaylistsView.viewName);

        TrackDetailsView trackDetailsView = new TrackDetailsView(trackDetailsViewModel, viewManagerModel, menuView);
        views.add(trackDetailsView, trackDetailsView.viewName);

        MergeView mergeView = MergeUseCaseFactory.create(viewManagerModel, generateViewModel, outputViewModel,
                outputView);
        views.add(mergeView, mergeView.viewName);

        GenerateView generateView = GenerateUseCaseFactory.create(viewManagerModel,
                generateViewModel, outputViewModel, mergeView);
        views.add(generateView, generateView.viewName);

        GetSimilarPlaylistsView getsimilarPlaylistsView = GetSimilarPlaylistsUseCaseFactory.create(viewManagerModel,
                getSimilarPlaylistsViewModel, similarPlaylistsViewModel);
        views.add(getsimilarPlaylistsView, getsimilarPlaylistsView.viewName);

        GetTrackDetailsView getTrackDetailsView = GetTrackDetailsUseCaseFactory.create(viewManagerModel,
                getTrackDetailsViewModel, trackDetailsViewModel);
        views.add(getTrackDetailsView, getTrackDetailsView.viewName);

        viewManagerModel.setActiveView(signupViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}