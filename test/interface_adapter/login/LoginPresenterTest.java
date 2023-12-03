package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import interface_adapter.generate.GenerateViewModel;
import interface_adapter.getSimilarPlaylists.GetSimilarPlaylistsViewModel;
import interface_adapter.getTrackDetails.GetTrackDetailsViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.login.LoginOutputData;
import view.MenuView;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LoginPresenterTest {

    private ViewManagerModel viewManagerModel;
    private LoginViewModel loginViewModel;
    private GenerateViewModel generateViewModel;
    private GetSimilarPlaylistsViewModel getSimilarPlaylistsViewModel;
    private GetTrackDetailsViewModel getTrackDetailsViewModel;
    private MenuView menuView;
    private LoginPresenter loginPresenter;

    @BeforeEach
    void setUp() {
        viewManagerModel = new ViewManagerModel();
        generateViewModel = new GenerateViewModel();
        getSimilarPlaylistsViewModel = new GetSimilarPlaylistsViewModel();
        getTrackDetailsViewModel = new GetTrackDetailsViewModel();
        loginViewModel = new LoginViewModel();
        menuView = new MenuView(generateViewModel, getSimilarPlaylistsViewModel, getTrackDetailsViewModel,
                viewManagerModel);
        loginPresenter = new LoginPresenter(viewManagerModel, loginViewModel, menuView);
    }

    @Test
    void prepareSuccessView_updatesViewManager() {
        // Arrange
        String name = "username";
        LoginOutputData loginOutputData = new LoginOutputData(name);

        // Act
        loginPresenter.prepareSuccessView(loginOutputData);

        // Assert
        assertEquals(menuView.viewName, viewManagerModel.getActiveView());
    }

    @Test
    void prepareFailView_updatesViewModelState() {
        // Arrange
        String error = "Invalid username";

        // Act
        loginPresenter.prepareFailView(error);

        // Assert
        assertNull(loginViewModel.getState().getUsernameError()); // Assuming there's a method to clear the error
        assertEquals(error, loginViewModel.getState().getUsernameError());
    }

}
