package form;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class NewsBot extends JFrame implements ActionListener {

    Map<String, String> validPassword = new HashMap<>();

    LoginForm loginForm;
    NewsForm newsForm;

    String username;


    private void setValidPassword() {
        validPassword.put("admin", "0000");
        validPassword.put("user", "1111");
    }

    public NewsBot() {
        setValidPassword();
        loginForm = new LoginForm(this);

    }

    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginForm.loginButton) {
            String login, password;
            login = loginForm.userTextField.getText();
            password = loginForm.passwordField.getText();

            if(!validPassword.containsKey(login) || !password.equals(validPassword.get(login))) {
                JOptionPane.showMessageDialog(this, "Неверный логин или пароль");
                return;
            }
            username = login;

            loginForm.setVisible(false);
            loginForm.dispose();
            newsForm = new NewsForm(login, this);

        }

        //Coding Part of RESET button
        if (e.getSource() == loginForm.resetButton) {
            loginForm.userTextField.setText("");
            loginForm.passwordField.setText("");
        }

        //Coding Part of showPassword JCheckBox
        if (e.getSource() == loginForm.showPassword) {
            if (loginForm.showPassword.isSelected()) {
                loginForm.passwordField.setEchoChar((char) 0);
            } else {
                loginForm.passwordField.setEchoChar('*');
            }

        }

        if(e.getSource() == newsForm.configButton) {
            configPage();
        }
    }

    public void configPage() {
        JFrame configUserPage = new JFrame("Настройки");
        configUserPage.setSize(400, 300);
        JButton button = new JButton("Назад");
        button.setBounds(20, 10, 100, 25);
        configUserPage.add(button);

        JLabel nameLabel = new JLabel("Имя");
        JLabel secondNameLabel = new JLabel("Фамилия");
        JLabel changePassword = new JLabel("Новый пароль");

        JTextField name = new JTextField();
        JTextField secondName = new JTextField();
        JTextField newPassword = new JTextField();

        nameLabel.setBounds(50, 50, 100, 25);
        name.setBounds(200, 50, 100, 25);
        secondNameLabel.setBounds(50, 100, 100, 25);
        secondName.setBounds(200, 100, 100, 25);
        changePassword.setBounds(50, 150, 100, 25);
        newPassword.setBounds(200, 150, 100, 25);


        configUserPage.add(nameLabel);
        configUserPage.add(secondNameLabel);
        configUserPage.add(changePassword);
        configUserPage.add(name);
        configUserPage.add(secondName);
        configUserPage.add(newPassword);



        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                configUserPage.dispose();
                newsForm = new NewsForm(username, this);
            }
        });

        newsForm.dispose();
        configUserPage.setLayout(null);
        configUserPage.setVisible(true);


    }


}
