package interface_adapter.login;

import interface_adapter.login.LoginState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LoginStateTest {

    @Test
    void gettersAndSetters_workCorrectly() {
        // Arrange
        LoginState loginState = new LoginState();

        // Act and Assert
        assertNull(loginState.getUsername());
        assertNull(loginState.getUsernameError());
        assertNull(loginState.getPassword());
        assertNull(loginState.getPasswordError());

        // Set values
        loginState.setUsername("user123");
        loginState.setUsernameError("Invalid username");
        loginState.setPassword("password123");
        loginState.setPasswordError("Invalid password");

        // Assert after setting values
        assertEquals("user123", loginState.getUsername());
        assertEquals("Invalid username", loginState.getUsernameError());
        assertEquals("password123", loginState.getPassword());
        assertEquals("Invalid password", loginState.getPasswordError());
    }

    @Test
    void copyConstructor_worksCorrectly() {
        // Arrange
        LoginState originalState = new LoginState();
        originalState.setUsername("user123");
        originalState.setUsernameError("Invalid username");
        originalState.setPassword("password123");
        originalState.setPasswordError("Invalid password");

        // Act
        LoginState copiedState = new LoginState(originalState);

        // Assert
        assertEquals(originalState.getUsername(), copiedState.getUsername());
        assertEquals(originalState.getUsernameError(), copiedState.getUsernameError());
        assertEquals(originalState.getPassword(), copiedState.getPassword());
        assertEquals(originalState.getPasswordError(), copiedState.getPasswordError());
    }

    // Add more tests as needed for different scenarios

}
