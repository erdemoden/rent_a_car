package com.rentacar.view;

import com.rentacar.model.Customer;
import com.rentacar.tool.Config;
import com.rentacar.tool.Tool;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerGUI extends JFrame{
    private JPanel wrapper;
    private JLabel lbl_customer;
    private JPanel pnl_top;
    private JPanel pnl_middle;
    private JButton btn_exit;
    private JLabel lbl_uname;


    public CustomerGUI(Customer customer) {

        {
            lbl_customer.setText(customer.getName().toUpperCase() + " " + customer.getSurname().toUpperCase());
            lbl_uname.setText("@"+customer.getUname());
            setContentPane(wrapper);
            setSize(750,500);
            setTitle(Config.APP_TITLE);
            setLocation(Tool.screenCenterAxis("x",getSize()), Tool.screenCenterAxis("y", getSize()));
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
        }




        btn_exit.addActionListener(e -> {
            this.dispose();
        });
    }
}
