package com.rentacar.view;


import com.rentacar.helptool.Config;
import com.rentacar.helptool.HelpTool;
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
    private JComboBox comboBox1;
    private JLabel lbl_typeLogin;
    private JPanel pnl_center;
    private JPanel pnl_top;
    private JLabel lbl_brand;
    private JButton btn_registerCompany;
    private JButton btn_registerUser;
    private JPanel pnl_register;

    public LoginGUI(){
        // +Window Kısmı
        HelpTool.setTheme("Metal");
        // add(wrapper);
        setContentPane(wrapper); // bu add yerine kullanılabilir
        setSize(400, 400);
        setResizable(false);
        setTitle(Config.APP_TITLE);
        setLocation(HelpTool.screenCenterAxis("x",getSize()), HelpTool.screenCenterAxis("y", getSize()));

        // setLocationRelativeTo(null);  //ekran ORTALA
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // ekran kapanınca sonlandır.
        setVisible(true);
        //pack();
        // -Window Kısmı


        // +Giriş Butonu
        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (HelpTool.isTextFieldEmpty(txtFld_uname) || HelpTool.isTextFieldEmpty(psswrdFld_password)){
                    JOptionPane.showMessageDialog(null, "Boş değer var. Onalrı Düzelt!..", "Uyarı", JOptionPane.WARNING_MESSAGE);
                }else {
                    //JOptionPane.showMessageDialog(null, "Giriş başarılı..", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                    // şirket bilgileri
                    Company company = new Company(1,"Yolcu360", "123", "Yolcu365", 34);
                    CompanyGUI companygui = new CompanyGUI(company);
                }
            }
        });
        // -Giriş Butonu


        // +Şirket Kayıt Butonu
        btn_registerCompany.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterOfCompany rgstrCompany = new RegisterOfCompany();
            }
        });
        // -Şirket Kayıt Butonu

    }

}
