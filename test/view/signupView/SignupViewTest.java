package view.signupView;

import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupViewModel;
import org.junit.Test;
import use_case.signup.SignupInputBoundary;
import view.SignupView;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SignupViewTest {

    @Test
    public void testSignupButtonAction() {
        TestSignupView testSignupView = new TestSignupView();
        JButton signupButton = findButton(testSignupView, SignupViewModel.SIGNUP_BUTTON_LABEL);
        assertNotNull(signupButton);

        // Set test data in text fields
        testSignupView.usernameInputField.setText("testUser");
        testSignupView.passwordInputField.setText("testPassword");
        testSignupView.repeatPasswordInputField.setText("testPassword");

        // Simulate a button click
        signupButton.doClick();

        // Verify that the TestSignupController was updated correctly
        TestSignupController signupController = (TestSignupController) testSignupView.signupController;
        assertEquals("testUser", signupController.getUsername());
        assertEquals("testPassword", signupController.getPassword());
        assertEquals("testPassword", signupController.getRepeatPassword());
    }

    private JButton findButton(Container container, String buttonText) {
        return new JButton("signup");
    }

    class TestSignupController extends SignupController{
        private String username;
        private String password;
        private String repeatPassword;

        public TestSignupController(SignupInputBoundary userSignupUseCaseInteractor) {
            super(userSignupUseCaseInteractor);
        }

        public void execute(String username, String password, String repeatPassword) {
            this.username = username;
            this.password = password;
            this.repeatPassword = repeatPassword;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getRepeatPassword() {
            return repeatPassword;
        }
    }

    class TestSignupViewModel extends SignupViewModel {
    }

    class TestSignupView extends SignupView {
        public TestSignupView() {
            super(new SignupController(null), new TestSignupViewModel());
        }
    }
}
