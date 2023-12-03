package interface_adapter.signup;

import interface_adapter.signup.SignupState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SignupStateTest {

    @Test
    void gettersAndSetters_workCorrectly() {
        // Arrange
        SignupState signupState = new SignupState();

        // Act and Assert
        assertNull(signupState.getUsername());
        assertNull(signupState.getUsernameError());
        assertNull(signupState.getPassword());
        assertNull(signupState.getPasswordError());
        assertNull(signupState.getRepeatPassword());
        assertNull(signupState.getRepeatPasswordError());

        // Set values
        signupState.setUsername("user123");
        signupState.setUsernameError("Invalid username");
        signupState.setPassword("password123");
        signupState.setPasswordError("Invalid password");
        signupState.setRepeatPassword("password123");
        signupState.setRepeatPasswordError("Passwords do not match");

        // Assert after setting values
        assertEquals("user123", signupState.getUsername());
        assertEquals("Invalid username", signupState.getUsernameError());
        assertEquals("password123", signupState.getPassword());
        assertEquals("Invalid password", signupState.getPasswordError());
        assertEquals("password123", signupState.getRepeatPassword());
        assertEquals("Passwords do not match", signupState.getRepeatPasswordError());
    }

    @Test
    void copyConstructor_worksCorrectly() {
        // Arrange
        SignupState originalState = new SignupState();
        originalState.setUsername("user123");
        originalState.setUsernameError("Invalid username");
        originalState.setPassword("password123");
        originalState.setPasswordError("Invalid password");
        originalState.setRepeatPassword("password123");
        originalState.setRepeatPasswordError("Passwords do not match");

        // Act
        SignupState copiedState = new SignupState(originalState);

        // Assert
        assertEquals(originalState.getUsername(), copiedState.getUsername());
        assertEquals(originalState.getUsernameError(), copiedState.getUsernameError());
        assertEquals(originalState.getPassword(), copiedState.getPassword());
        assertEquals(originalState.getPasswordError(), copiedState.getPasswordError());
        assertEquals(originalState.getRepeatPassword(), copiedState.getRepeatPassword());
        assertEquals(originalState.getRepeatPasswordError(), copiedState.getRepeatPasswordError());
    }

}