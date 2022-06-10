package com.rentacar.view;

import com.rentacar.helptool.Config;
import com.rentacar.helptool.HelpTool;
import com.rentacar.model.Company;

import javax.swing.*;

public class CompanyGUI extends JFrame {
    private JPanel wrapper;
    private JTabbedPane tbbdPn_company;
    private JLabel lbl_companyTitle;
    private JPanel pnl_top;
    private JButton btn_companyExit;

    public CompanyGUI(Company company) {
        setContentPane(wrapper);
        setSize(600,400);
        setTitle(Config.APP_TITLE);
        setLocation(HelpTool.screenCenterAxis("x",getSize()), HelpTool.screenCenterAxis("y", getSize()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        lbl_companyTitle.setText(company.getName() + " hoşgeldiniz");

    }
}
