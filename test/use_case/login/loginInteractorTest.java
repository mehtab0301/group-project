package use_case.login;
import static org.mockito.Mockito.*;
import data_access.UserDataAccessObject;
import entity.CommonUser;
import entity.CommonUserFactory;
import entity.User;
import entity.UserFactory;
import org.junit.jupiter.api.Test;
import interface_adapter.ViewManagerModel;
import interface_adapter.generate.GenerateViewModel;
import interface_adapter.getSimilarPlaylists.GetSimilarPlaylistsViewModel;
import interface_adapter.getTrackDetails.GetTrackDetailsViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import org.junit.Assert;
import use_case.getTrackDetails.*;
import use_case.signup.SignupOutputData;
import use_case.signup.SignupUserDataAccessInterface;
import view.GenerateView;
import view.MenuView;

import java.io.IOException;

public class loginInteractorTest {
    @Test
    public void testPrepareSuccessView() throws IOException {
        // Arrange
        LoginOutputBoundary successPresenter = mock(LoginOutputBoundary.class);
        LoginInputData loginInputData = new LoginInputData("userTest", "123");
        UserDataAccessObject userDataAccessObject = new UserDataAccessObject(new CommonUserFactory());
        // Set up a user for the existing account
        User user = new CommonUserFactory().create("userTest", "123");
        userDataAccessObject.save(user);

        // Create the LoginInteractor with the mock success presenter
        LoginInputBoundary loginInteractor = new LoginInteractor(userDataAccessObject, successPresenter);

        // Act
        loginInteractor.execute(loginInputData);

        // Assert
        // Verify that prepareSuccessView was called with the expected LoginOutputData
        verify(successPresenter, times(1)).prepareSuccessView(any(LoginOutputData.class));
        // You might want to further assert specific details about the expected LoginOutputData
    }
    @Test
    public void testPrepareFailPasswordView() throws IOException {
        // Arrange
        LoginOutputBoundary successPresenter = mock(LoginOutputBoundary.class);
        LoginInputData loginInputData = new LoginInputData("userTest", "123");
        UserDataAccessObject userDataAccessObject = new UserDataAccessObject(new CommonUserFactory());
        // Set up a user for the existing account
        User user = new CommonUserFactory().create("userTest", "1234");
        userDataAccessObject.save(user);

        // Create the LoginInteractor with the mock success presenter
        LoginInputBoundary loginInteractor = new LoginInteractor(userDataAccessObject, successPresenter);

        // Act
        loginInteractor.execute(loginInputData);

        // Assert
        // Verify that prepareSuccessView was called with the expected LoginOutputData
        verify(successPresenter, times(1)).prepareFailView("Incorrect password for userTest.");
        // You might want to further assert specific details about the expected LoginOutputData
    }
    @Test
    public void testPrepareFailUserView() throws IOException {
        // Arrange
        LoginOutputBoundary successPresenter = mock(LoginOutputBoundary.class);
        LoginInputData loginInputData = new LoginInputData("userTest", "123");
        UserDataAccessObject userDataAccessObject = new UserDataAccessObject(new CommonUserFactory());
        // Set up a user for the existing account
        User user = new CommonUserFactory().create("userTestTest", "123");
        userDataAccessObject.save(user);

        // Create the LoginInteractor with the mock success presenter
        LoginInputBoundary loginInteractor = new LoginInteractor(userDataAccessObject, successPresenter);

        // Act
        loginInteractor.execute(loginInputData);

        // Assert
        // Verify that prepareSuccessView was called with the expected LoginOutputData
        verify(successPresenter, times(1)).prepareFailView("userTest: Account does not exist.");
        // You might want to further assert specific details about the expected LoginOutputData
    }
}
