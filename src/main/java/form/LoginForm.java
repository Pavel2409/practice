package form;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class LoginForm extends JFrame {



    Container container = getContentPane();
    JLabel userLabel = new JLabel("Логин");
    JLabel passwordLabel = new JLabel("Пароль");
    public JTextField userTextField = new JTextField();
    public JPasswordField passwordField = new JPasswordField();
    public JButton loginButton = new JButton("Войти");
    public JButton resetButton = new JButton("Сбросить");
    JCheckBox showPassword = new JCheckBox("Показать пароль");



    public LoginForm(ActionListener listener) {
        super("Авторизация");
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent(listener);

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setBounds(700, 350, 400, 300);
        super.setVisible(true);

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(50, 50, 100, 30);
        passwordLabel.setBounds(50, 120, 100, 30);
        userTextField.setBounds(150, 50, 150, 30);
        passwordField.setBounds(150, 120, 150, 30);
        showPassword.setBounds(150, 150, 150, 30);
        loginButton.setBounds(50, 200, 100, 30);
        resetButton.setBounds(200, 200, 100, 30);

    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }

    public void addActionEvent(ActionListener listener) {
        loginButton.addActionListener(listener);
        resetButton.addActionListener(listener);
        showPassword.addActionListener(listener);
    }

}
