package com.rentacar.view;

import com.rentacar.helptool.Config;
import com.rentacar.helptool.HelpTool;

import javax.swing.*;

public class RegisterOfCompany extends JFrame{
    private JPanel wrapper;
    private JTextField textField1;
    private JTextField textField2;
    private JPasswordField dasdPasswordField;
    private JPasswordField passwordField1;
    private JButton şirketiKaydetButton;
    private JComboBox comboBox1;


    public RegisterOfCompany() {

        // +Ekran
        setContentPane(wrapper);
        HelpTool.setTheme("Metal");
        setSize(300,400);

        int x = HelpTool.screenCenterAxis("x", getSize());
        int y = HelpTool.screenCenterAxis("y", getSize());
        setLocation(x,y);

        // setLocationRelativeTo(null);

        setTitle(Config.APP_TITLE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // x tuşu.
        setVisible(true);
        // -Ekran


    }
}
