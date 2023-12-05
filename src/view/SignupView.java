package view;

import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupState;
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

public class SignupView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "sign up";

    private final SignupViewModel signupViewModel;
    public final JTextField usernameInputField = new JTextField(15);
    public final JPasswordField passwordInputField = new JPasswordField(15);
    public final JPasswordField repeatPasswordInputField = new JPasswordField(15);
    public final SignupController signupController;
    private final JButton signUp;

    public SignupView(SignupController controller, SignupViewModel signupViewModel) {



        this.signupController = controller;
        this.signupViewModel = signupViewModel;
        signupViewModel.addPropertyChangeListener(this);

        this.setBackground(new Color(22,23,46));

        JLabel title = new JLabel(SignupViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(new Color(213, 249,121));
        title.setFont(new Font("Poppins", Font.BOLD, 17));

        JLabel usernameLabel = new JLabel(SignupViewModel.USERNAME_LABEL);
        usernameLabel.setForeground(new Color(169, 245,180));
        usernameLabel.setFont(new Font("Poppins", Font.BOLD, 15));

        LabelTextPanel usernameInfo = new LabelTextPanel(
                usernameLabel, usernameInputField);
        usernameInfo.setBackground(new Color(22,23,46));
        usernameInfo.setForeground(new Color(169, 245,180));

        JLabel passwordLabel = new JLabel(SignupViewModel.PASSWORD_LABEL);
        passwordLabel.setForeground(new Color(213, 249,121));
        passwordLabel.setFont(new Font("Poppins", Font.BOLD, 15));

        LabelTextPanel passwordInfo = new LabelTextPanel(passwordLabel, passwordInputField);
        passwordInfo.setForeground(new Color(169, 245,180));
        passwordInfo.setBackground(new Color(22,23,46));

        JLabel passrepLabel = new JLabel(SignupViewModel.REPEAT_PASSWORD_LABEL);
        passrepLabel.setForeground(new Color(169, 245,180));
        passrepLabel.setFont(new Font("Poppins", Font.BOLD, 15));


        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(passrepLabel, repeatPasswordInputField);
        repeatPasswordInfo.setBackground(new Color(22,23,46));
        repeatPasswordInfo.setForeground(new Color(169, 245,180));

        JPanel buttons = new JPanel();
        buttons.setBackground(new Color(22,23,46));
        buttons.setForeground(new Color(169, 245,180));
        signUp = new JButton(SignupViewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(signUp);


        signUp.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(signUp)) {
                            SignupState currentState = signupViewModel.getState();

                            signupController.execute(
                                    currentState.getUsername(),
                                    currentState.getPassword(),
                                    currentState.getRepeatPassword()
                            );
                        }
                    }
                }
        );

        usernameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        String text = usernameInputField.getText() + e.getKeyChar();
                        currentState.setUsername(text);
                        signupViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        passwordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        currentState.setPassword(passwordInputField.getText() + e.getKeyChar());
                        signupViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        repeatPasswordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        currentState.setRepeatPassword(repeatPasswordInputField.getText() + e.getKeyChar());
                        signupViewModel.setState(currentState); // Hmm, is this necessary?
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(repeatPasswordInfo);
        this.add(buttons);
    }

    public void actionPerformed(ActionEvent evt) {}

    @Override
    public void propertyChange(PropertyChangeEvent evt) {}
}