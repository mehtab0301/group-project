package interface_adapter.signup;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.signup.SignupOutputData;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SignupPresenterTest {

    private ViewManagerModel viewManagerModel;
    private SignupViewModel signupViewModel;
    private LoginViewModel loginViewModel;
    private SignupPresenter signupPresenter;

    @BeforeEach
    void setUp() {
        viewManagerModel = new ViewManagerModel();
        signupViewModel = new SignupViewModel();
        loginViewModel = new LoginViewModel();
        signupPresenter = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);
    }

    @Test
    void prepareSuccessView_updatesLoginViewModelStateAndViewManager() {
        // Arrange
        SignupOutputData response = new SignupOutputData("newUser", false);

        // Act
        signupPresenter.prepareSuccessView(response);

        // Assert
        LoginState loginState = loginViewModel.getState();
        assertEquals("newUser", loginState.getUsername());

        // Assuming the view manager is correctly updated
        assertEquals(loginViewModel.getViewName(), viewManagerModel.getActiveView());
    }

    @Test
    void prepareFailView_updatesViewModelState() {
        // Arrange
        String error = "Username already exists";

        // Act
        signupPresenter.prepareFailView(error);

        // Assert
        assertNull(signupViewModel.getState().getUsernameError()); // Assuming there's a method to clear the error
        assertEquals(error, signupViewModel.getState().getUsernameError());
    }

}