package Server.Controller;

import Server.View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController implements ActionListener {
    private View view;

    public RegisterController(View view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("REGISTER")) {
            System.out.println(view.getRegisterView().getUsername());
            System.out.println(view.getRegisterView().getEmail());
            System.out.println(view.getRegisterView().getPassword());
            System.out.println(view.getRegisterView().getPasswordVerify());
            System.out.println("Registered");
        }
    }

    private boolean confirmPassword(String password, String confirmPassword) {
        boolean validPassword;
        validPassword = password.equals(confirmPassword);
        if (validPassword) {
            validPassword = password.length() >= 8;
            if (validPassword) {
                validPassword = !password.contains(view.getRegisterView().getUsername());
                if (validPassword) {
                    validPassword = specialCharacters(password);
                }
            }
        }

        return validPassword;
    }

    private boolean specialCharacters(String password) {
        int num = 0;
        if (password.matches("(?=.*[a-z])")) {
            num++;
        }
        if (password.matches("(?=.*[A-Z])")) {
            num++;
        }
        if (password.matches("(?=.*[@#$%^&+=])")) {
            num++;
        }
        if (password.matches("(?=.*d)")) {
            num++;
        }
        return num >= 2;
    }
}
