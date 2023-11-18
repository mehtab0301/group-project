package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.generate.GenerateViewModel;
import interface_adapter.login.LoginViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "log in";
    private final LoginViewModel loginViewModel;

    // Temporary use for changing views
    private final GenerateViewModel generateViewModel;
    private final ViewManagerModel viewManagerModel;

    private final JTextField usernameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);

    private final JButton logIn;

    public LoginView(LoginViewModel loginViewModel, GenerateViewModel generateViewModel,
                     ViewManagerModel viewManagerModel) {
        this.loginViewModel = loginViewModel;
        this.loginViewModel.addPropertyChangeListener(this);

        // Temporary use for changing views
        this.generateViewModel = generateViewModel;
        this.viewManagerModel = viewManagerModel;

        JLabel title = new JLabel(LoginViewModel.TITLE_LABLE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(new JLabel(LoginViewModel.USERNAME_LABEL), usernameInputField);
        usernameInfo.setAlignmentX(CENTER_ALIGNMENT);
        LabelTextPanel passwordInfo = new LabelTextPanel(new JLabel(LoginViewModel.PASSWORD_LABEL), passwordInputField);
        passwordInfo.setAlignmentX(CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        logIn = new JButton(LoginViewModel.LOGIN_BUTTON_LABEL);
        buttons.add(logIn);

        logIn.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(buttons);
    }

    public void actionPerformed(ActionEvent evt) {
        viewManagerModel.setActiveView(generateViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}