package com.rentacar.view;

import com.rentacar.tool.Config;
import com.rentacar.tool.Tool;

import javax.swing.*;

public class RegisterCustomerGUI extends JFrame {

    private JPanel wrapper;
    private JPanel pnl_top;
    private JPanel pnl_middle;
    private JTextField textField1;
    private JTextField textField2;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton btn_register;
    private JTextField textField3;

    public RegisterCustomerGUI(){
        {
            setContentPane(wrapper);
            setTitle(Config.APP_TITLE);
            setSize(400,450);
            setLocation(Tool.screenCenterAxis("x",getSize()), Tool.screenCenterAxis("y", getSize()));
            setVisible(true);
        }
    }
}
