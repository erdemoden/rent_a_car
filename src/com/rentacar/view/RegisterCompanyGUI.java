package com.rentacar.view;

import com.rentacar.model.Company;
import com.rentacar.tool.Config;
import com.rentacar.tool.Tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterCompanyGUI extends JFrame{
    private JPanel wrapper;
    private JPanel pnl_top;
    private JPanel pnl_middle;
    private JLabel lbl_title;
    private JTextField txtFld_companyName;
    private JTextField txtFld_uname;
    private JPasswordField psswrdFld_pss;
    private JPasswordField psswrdFld_pssTry;
    private JComboBox cmbBx_city;
    private JButton btn_register;

    public RegisterCompanyGUI(){
        {
            setContentPane(wrapper);
            setSize(400,450);
            setTitle(Config.APP_TITLE);
            setLocation(Tool.screenCenterAxis("x",getSize()), Tool.screenCenterAxis("y", getSize()));
            setVisible(true);
        }

        btn_register.addActionListener(e -> {
            if(Tool.isFieldEmpty(txtFld_companyName) || Tool.isFieldEmpty(txtFld_uname) || Tool.isFieldEmpty(psswrdFld_pss) || Tool.isFieldEmpty(psswrdFld_pssTry)) {
                Tool.showDialog("empty");
            }else{
                boolean result = false;
                result = Company.add(txtFld_uname.getText(),
                        psswrdFld_pss.getText(), psswrdFld_pssTry.getText(),
                        txtFld_companyName.getText(),
                        Integer.parseInt(cmbBx_city.getSelectedItem().toString()));
                if(result){
                    Tool.showDialog("done");
                    // Ekran kapatma komutunu bulamadım.
                    setSize(0,0);
                    setLocation(Toolkit.getDefaultToolkit().getScreenSize().width,
                            Toolkit.getDefaultToolkit().getScreenSize().height);
                }else{
                    Tool.showDialog("not_register");
                }
            }
        });
    }
}
