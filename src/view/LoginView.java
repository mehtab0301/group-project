package view;

import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.Color;
import java.awt.Font;

public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "log in";
    private final LoginViewModel loginViewModel;

    private final JTextField usernameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);

    private final JButton logIn;

    private final LoginController loginController;

    public LoginView(LoginViewModel loginViewModel, LoginController loginController) {
        this.setBackground(new Color(22,23,46));
        this.loginController = loginController;
        this.loginViewModel = loginViewModel;
        this.loginViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(LoginViewModel.TITLE_LABLE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setBackground(new Color(22,23,46));

        JLabel usernameLabel = new JLabel(SignupViewModel.USERNAME_LABEL);
        usernameLabel.setForeground(new Color(169, 245,180));
        usernameLabel.setFont(new Font("Poppins", Font.BOLD, 15));

        LabelTextPanel usernameInfo = new LabelTextPanel(usernameLabel, usernameInputField);
        usernameInfo.setAlignmentX(CENTER_ALIGNMENT);
        usernameInfo.setBackground(new Color(22,23,46));

        JLabel passwordLabel = new JLabel(SignupViewModel.PASSWORD_LABEL);
        passwordLabel.setForeground(new Color(213, 249,121));
        passwordLabel.setFont(new Font("Poppins", Font.BOLD, 15));


        LabelTextPanel passwordInfo = new LabelTextPanel(passwordLabel, passwordInputField);
        passwordInfo.setAlignmentX(CENTER_ALIGNMENT);
        passwordInfo.setBackground(new Color(22,23,46));


        JPanel buttons = new JPanel();
        buttons.setBackground(new Color(22,23,46));
        buttons.setForeground(new Color(169, 245,180));
        logIn = new JButton(LoginViewModel.LOGIN_BUTTON_LABEL);
        buttons.add(logIn);

        logIn.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(logIn)) {
                            LoginState currentState = loginViewModel.getState();

                            loginController.execute(currentState.getUsername(),
                                    currentState.getPassword());
                        }
                    }
                }
        );

        usernameInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                LoginState currentState = loginViewModel.getState();
                currentState.setUsername(usernameInputField.getText() + e.getKeyChar());
                loginViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        passwordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        LoginState currentState = loginViewModel.getState();
                        currentState.setPassword(passwordInputField.getText() + e.getKeyChar());
                        loginViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(buttons);
    }

    public void actionPerformed(ActionEvent evt) {}

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LoginState state = (LoginState) evt.getNewValue();
        setFields(state);
    }

    private void setFields(LoginState state) {
        usernameInputField.setText(state.getUsername());
    }
}