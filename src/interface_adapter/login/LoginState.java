package interface_adapter.login;

public class LoginState {
    private String username = "";
    private String password = "";

    public LoginState(LoginState copy) {
        username = copy.username;
        password = copy.password;
    }

    public LoginState() {}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
