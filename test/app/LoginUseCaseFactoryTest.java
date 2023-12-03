package app;

import entity.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.generate.GenerateViewModel;
import interface_adapter.getSimilarPlaylists.GetSimilarPlaylistsViewModel;
import interface_adapter.getTrackDetails.GetTrackDetailsViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginViewModel;
import org.junit.jupiter.api.Test;
import use_case.login.LoginUserDataAccessInterface;
import view.LoginView;
import view.MenuView;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LoginUseCaseFactoryTest {

    @Test
    void create_returnsLoginView() {
        // Arrange
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        GenerateViewModel generateViewModel = new GenerateViewModel();
        GetSimilarPlaylistsViewModel getSimilarPlaylistsViewModel = new GetSimilarPlaylistsViewModel();
        GetTrackDetailsViewModel getTrackDetailsViewModel = new GetTrackDetailsViewModel();
        MenuView menuView = new MenuView(generateViewModel, getSimilarPlaylistsViewModel, getTrackDetailsViewModel,
                viewManagerModel);
        LoginUserDataAccessInterface userDataAccessObject = new FakeLoginUserDataAccess(); // Use a fake implementation

        // Act
        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, menuView, userDataAccessObject);

        // Assert
        assertNotNull(loginView);
    }

    // This is a simple fake implementation for testing purposes
    private static class FakeLoginUserDataAccess implements LoginUserDataAccessInterface {
        @Override
        public boolean existsByName(String username) {
            // Simulate user authentication (replace with your logic)
            return username.equals("testUser");
        }

        @Override
        public void save(User user) {
            // Simulate saving user data (replace with your logic)
        }

        @Override
        public User get(String username) {
            return null;
        }
    }
}
