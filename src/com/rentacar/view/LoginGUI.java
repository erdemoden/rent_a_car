package com.rentacar.view;


import com.rentacar.tool.Config;
import com.rentacar.tool.Tool;
import com.rentacar.model.Company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame{
    private JPanel wrapper;
    private JTextField txtFld_uname;
    private JPasswordField psswrdFld_password;
    private JButton btn_login;
    private JLabel lbl_uname;
    private JLabel lbl_password;
    private JComboBox cmbBx_loginType;
    private JLabel lbl_typeLogin;
    private JPanel pnl_center;
    private JPanel pnl_top;
    private JLabel lbl_brand;
    private JButton btn_registerCompany;
    private JButton btn_registerCustomer;
    private JPanel pnl_register;
    private JRadioButton rdBtn_customer;
    private JRadioButton rdBtn_company;

    public LoginGUI(){
        // +Window Kısmı
        {
            Tool.setTheme("Metal");
            // add(wrapper);
            setContentPane(wrapper); // bu add yerine kullanılabilir
            setSize(400, 400);
            setResizable(false);
            setTitle(Config.APP_TITLE);
            setLocation(Tool.screenCenterAxis("x",getSize()), Tool.screenCenterAxis("y", getSize()));

            // setLocationRelativeTo(null);  //ekran ORTALA
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // ekran kapanınca sonlandır.
            setVisible(true);
            //pack();
        }
        // -Window Kısmı


        // +Giriş Butonu
        btn_login.addActionListener(e -> {
            if (Tool.isFieldEmpty(txtFld_uname) || Tool.isFieldEmpty(psswrdFld_password)){
                Tool.showDialog("empty");
            }else{
                if(Config.USER_COMPANY == cmbBx_loginType.getSelectedItem().toString()){
                    // şirket Girişi için
                    Company company = Company.setCompany(txtFld_uname.getText(), psswrdFld_password.getText());
                    if(company == null){
                        Tool.showDialog("wrong_info");
                    } else if (company != null) {
                        CompanyGUI companyGUI = new CompanyGUI(company);
                    }
                }else if(Config.USER_CUSTOMER == cmbBx_loginType.getSelectedItem().toString()){
                    // Müşeri girişi
                    CustomerGUI customerGUI = new CustomerGUI();
                }else{
                    Tool.showDialog("Bu Kullanıcı Türü Bulunamadı");
                }
            }
        });
        // -Giriş Butonu



        // +Şirket Kayıt Butonu
        btn_registerCompany.addActionListener(e -> {
            RegisterCompanyGUI registerCompanyGUI = new RegisterCompanyGUI();
        });
        // -Şirket Kayıt Butonu



        // +Müşteri Kayıt Butonu
        btn_registerCustomer.addActionListener(e -> {
            RegisterCustomerGUI registerCustomerGUI = new RegisterCustomerGUI();
        });
        // -Müşteri Kayıt Butonu

    }
}
