package use_case.signup;

import entity.User;
import entity.UserFactory;
import org.junit.Assert;
import org.junit.Test;

public class SignupInteractorTest {

    @Test
    public void SignupTest() {
        SignupInputData signupInputData = new SignupInputData("username", "pwd", "pwd");

        SignupOutputBoundary successPresenter = new SignupOutputBoundary() {
            @Override
            public void prepareSuccessView(SignupOutputData user) {
                Assert.assertNull(user);
            }

            @Override
            public void prepareFailView(String error) {
            }
        };

        SignupUserDataAccessInterface signupUserDataAccessInterface = new SignupUserDataAccessInterface() {
            @Override
            public boolean existsByName(String identifier) {
                return false;
            }

            @Override
            public void save(User user) {

            }
        };

        UserFactory userFactory = new UserFactory() {
            @Override
            public User create(String name, String password) {
                return null;
            }
        };

        SignupInputBoundary signupInteractor = new SignupInteractor(signupUserDataAccessInterface, successPresenter,
                userFactory);
        signupInteractor.execute(signupInputData);
    }
}
