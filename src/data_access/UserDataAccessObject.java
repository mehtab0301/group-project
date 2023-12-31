package data_access;

import entity.User;
import entity.UserFactory;
import use_case.login.LoginUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserDataAccessObject extends UserDataAccessInterface implements SignupUserDataAccessInterface, LoginUserDataAccessInterface {
    private final Map<String, User> accounts = new HashMap<>();

    private UserFactory userFactory;

    public UserDataAccessObject(UserFactory userFactory) throws IOException {
        this.userFactory = userFactory;
    }

    @Override
    public void save(User user) {
        accounts.put(user.getName(), user);
    }

    @Override
    public User get(String username) {
        return accounts.get(username);
    }

    @Override
    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }
}