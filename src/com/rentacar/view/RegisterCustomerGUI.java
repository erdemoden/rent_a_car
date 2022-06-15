package com.rentacar.view;

import com.rentacar.model.Customer;
import com.rentacar.tool.Config;
import com.rentacar.tool.Tool;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterCustomerGUI extends JFrame {

    private JPanel wrapper;
    private JPanel pnl_top;
    private JPanel pnl_middle;
    private JTextField fld_name;
    private JTextField fld_sname;
    private JPasswordField fld_password;
    private JPasswordField fld_passwordTry;
    private JButton btn_register;
    private JTextField fld_uname;
    private JPanel pnl_nameSurname;

    public RegisterCustomerGUI(){
        {
            setContentPane(wrapper);
            setTitle(Config.APP_TITLE);
            setSize(400,450);
            setLocation(Tool.screenCenterAxis("x",getSize()), Tool.screenCenterAxis("y", getSize()));
            setVisible(true);
        }

        btn_register.addActionListener(e -> {
            boolean result;
            if(Tool.isFieldEmpty(fld_uname) || Tool.isFieldEmpty(fld_password) || Tool.isFieldEmpty(fld_passwordTry) || Tool.isFieldEmpty(fld_name) || Tool.isFieldEmpty(fld_sname) ){
                Tool.showDialog("empty");
            }else {
                if(!fld_password.getText().equals(fld_passwordTry.getText())){
                    Tool.showDialog("not_equal_pass");
                }else{
                    result = Customer.add(fld_uname.getText(),fld_password.getText(),fld_name.getText(),fld_sname.getText());
                    if(result){
                        Tool.showDialog("done");
                        fld_uname.setText(null);
                        fld_password.setText(null);
                        fld_passwordTry.setText(null);
                        fld_name.setText(null);
                        fld_sname.setText(null);
                    }else{
                        Tool.showDialog("error");
                    }
                }
            }

        });
    }
}
