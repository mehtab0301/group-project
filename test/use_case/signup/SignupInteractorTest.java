package use_case.signup;

import data_access.UserDataAccessObject;
import entity.CommonUserFactory;
import entity.User;
import org.junit.jupiter.api.Test;
import use_case.login.*;
import use_case.signup.*;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SignupInteractorTest {
    @Test
    public void testPrepareSuccessfulSignupView() throws IOException {
        // Arrange
        SignupOutputBoundary successPresenter = mock(SignupOutputBoundary.class);
        SignupInputData signupInputData = new SignupInputData("newUser", "password123", "password123");
        UserDataAccessObject userDataAccessObject = new UserDataAccessObject(new CommonUserFactory());

        // Create the SignupInteractor with the mock success presenter and a UserFactory
        SignupInteractor signupInteractor = new SignupInteractor(userDataAccessObject, successPresenter, new CommonUserFactory());

        // Act
        signupInteractor.execute(signupInputData);

        // Assert
        // Verify that prepareSuccessView was called
        verify(successPresenter, times(1)).prepareSuccessView(any(SignupOutputData.class));
    }
    @Test
    public void testPrepareFailPasswordSignupView() throws IOException {
        // Arrange
        SignupOutputBoundary failPresenter = mock(SignupOutputBoundary.class);
        SignupInputData signupInputData = new SignupInputData("userTest", "123", "wrongPassword");
        UserDataAccessObject userDataAccessObject = new UserDataAccessObject(new CommonUserFactory());
        // Set up a user for the existing account
        User user = new CommonUserFactory().create("userTest", "correctPassword");
        userDataAccessObject.save(user);

        // Create the SignupInteractor with the mock fail presenter
        SignupInputBoundary signupInteractor = new SignupInteractor(userDataAccessObject, failPresenter,  new CommonUserFactory());

        // Act
        signupInteractor.execute(signupInputData);

        // Assert
        // Verify that prepareFailView was called with the expected error message
        verify(failPresenter, times(1)).prepareFailView("Passwords don't match.");
        // You might want to further assert specific details about the expected error message
    }
    @Test
    public void testPrepareFailUserView() throws IOException {
        // Arrange
        SignupOutputBoundary failPresenter = mock(SignupOutputBoundary.class);
        SignupInputData signupInputData = new SignupInputData("existingUser", "123", "password");
        UserDataAccessObject userDataAccessObject = new UserDataAccessObject(new CommonUserFactory());

        // Set up a user for the existing account
        User existingUser = new CommonUserFactory().create("existingUser", "existingPassword");
        userDataAccessObject.save(existingUser);

        // Create the SignupInteractor with the mock fail presenter and a UserFactory
        SignupInteractor signupInteractor = new SignupInteractor(userDataAccessObject, failPresenter, new CommonUserFactory());

        // Act
        signupInteractor.execute(signupInputData);

        // Assert
        // Verify that prepareFailView was called with the expected error message
        verify(failPresenter, times(1)).prepareFailView("User already exists with the username 'existingUser'.");
    }
}
