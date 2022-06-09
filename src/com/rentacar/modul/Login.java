package com.rentacar.modul;


import com.rentacar.helptool.HelpTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
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

    public Login(){
        // +Window Kısmı
        {
            HelpTool.setTheme("Metal");

            add(wrapper);
            // setContentPane(wrapper); // bu add yerine kullanılabilir
            setSize(400, 400);
            setResizable(false);
            setTitle("Giriş Ekranı");

            int x = (Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2;
            int y = (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2;
            setLocation(x, y);
            // setLocationRelativeTo(null);  //ekran ORTALA

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // ekran kapanınca sonlandır.
            setVisible(true);
            //pack();
        }
        // -Window Kısmı


        // +Giriş Butonu
        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (txtFld_uname.getText().length() == 0 || psswrdFld_password.getText().length() == 0){
                    JOptionPane.showMessageDialog(null, "Boş değer girdiniz!..", "Uyarı", JOptionPane.WARNING_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(null, "Giriş başarılı..", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
        // -Giriş Butonu


    }

}
