package data_access;

import data_access.UserDataAccessObject;
import entity.User;
import entity.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.login.LoginUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UserDataAccessObjectTest {

    private UserDataAccessObject userDataAccessObject;

    @BeforeEach
    void setUp() throws IOException {
        UserFactory userFactory = new UserFactory() {
            @Override
            public User create(String name, String password) {
                return null;
            }
        };
        userDataAccessObject = new UserDataAccessObject(userFactory);
    }

    @Test
    void saveAndGetUser() {
        User user = new User() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public String getPassword() {
                return null;
            }
        };
        userDataAccessObject.save(user);

        User retrievedUser = userDataAccessObject.get("testUser");

        assertEquals(user, retrievedUser);
    }

    @Test
    void existsByName() {
        User user = new User() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public String getPassword() {
                return null;
            }
        };
        userDataAccessObject.save(user);

        assertTrue(userDataAccessObject.existsByName("existingUser"));
        assertFalse(userDataAccessObject.existsByName("nonexistentUser"));
    }

}
