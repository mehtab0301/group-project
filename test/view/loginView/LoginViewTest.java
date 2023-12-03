package view.loginView;

import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;
import use_case.login.LoginInteractor;
import view.LoginView;

import javax.swing.*;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

class LoginViewTest {

    private LoginViewModel loginViewModel;
    private LoginController loginController;
    private LoginView loginView;

    @BeforeEach
    void setUp() {
        loginViewModel = new LoginViewModel();
        loginController = new LoginController(null); // You might need to provide a mock implementation
        loginView = new LoginView(loginViewModel, loginController);
    }

    @Test
    void testLoginButtonClick() {
        JButton loginButton = findButton(loginView, LoginViewModel.LOGIN_BUTTON_LABEL);
        assertNotNull(loginButton);

        // Simulate a button click
        loginButton.doClick();

        // Now, you can assert the expected behavior based on the button click
        // For example, you might want to check if the loginController was called with the correct parameters.
    }

    // Helper method to find a button in the LoginView
    private JButton findButton(Container container, String buttonText) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                if (button.getText().equals(buttonText)) {
                    return button;
                }
            } else if (component instanceof Container) {
                JButton button = findButton((Container) component, buttonText);
                if (button != null) {
                    return button;
                }
            }
        }
        return null;
    }
}
