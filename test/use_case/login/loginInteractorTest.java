package use_case.login;

import entity.User;
import org.junit.Assert;
import org.junit.Test;

public class LoginInteractorTest {

    @Test
    public void LoginTest() {
        LoginInputData loginInputData = new LoginInputData("username", "pwd");

        LoginOutputBoundary successPresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                Assert.assertEquals("Username", user.getUsername());
            }

            @Override
            public void prepareFailView(String error) {
            }
        };
        LoginUserDataAccessInterface loginUserDataAccessObject = new LoginUserDataAccessInterface() {
            @Override
            public boolean existsByName(String identifier) {
                return false;
            }

            @Override
            public void save(User user) {
            }

            @Override
            public User get(String username) {
                return null;
            }
        };

        LoginInputBoundary loginInteractor = new LoginInteractor(loginUserDataAccessObject, successPresenter);
        loginInteractor.execute(loginInputData);
    }
}
