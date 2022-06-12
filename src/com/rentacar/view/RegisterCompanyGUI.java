package com.rentacar.view;

import com.rentacar.tool.Config;
import com.rentacar.tool.Tool;

import javax.swing.*;

public class RegisterCompanyGUI extends JFrame{
    private JPanel wrapper;
    private JPanel pnl_top;
    private JPanel pnl_middle;
    private JLabel lbl_title;
    private JTextField textField1;
    private JTextField textField2;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JComboBox comboBox1;
    private JButton btn_register;

    public RegisterCompanyGUI(){
        {
            setContentPane(wrapper);
            setSize(700,500);
            setTitle(Config.APP_TITLE);
            setLocation(Tool.screenCenterAxis("x",getSize()), Tool.screenCenterAxis("y", getSize()));
            setVisible(true);
        }
    }
}
