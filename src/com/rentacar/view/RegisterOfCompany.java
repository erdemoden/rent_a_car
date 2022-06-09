package com.rentacar.view;

import com.rentacar.helptool.HelpTool;

import javax.swing.*;
import java.awt.*;

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
        {
            HelpTool.setTheme("Nimbus");
            setContentPane(wrapper);
            setLocationRelativeTo(null);
            setSize(300,400);
            setTitle("Kayıt Ekranı");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // ekran kapanınca sonlandır.
            setVisible(true);
        }
        // -Ekran


    }
}
