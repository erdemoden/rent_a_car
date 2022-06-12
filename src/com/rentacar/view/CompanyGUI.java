package com.rentacar.view;

import com.rentacar.model.Cars;
import com.rentacar.tool.Config;
import com.rentacar.tool.Tool;
import com.rentacar.model.Company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CompanyGUI extends JFrame {
    private JPanel wrapper;
    private JTabbedPane tbbdPn_company;
    private JLabel lbl_companyTitle;
    private JPanel pnl_top;
    private JButton btn_exit;
    private JPanel pnl_carList;
    private JScrollPane scrllPn_carList;
    private JTable tbl_carList;
    private JPanel pnl_AddCar;
    private JLabel lbl_yeniArac;
    private JLabel lbl_carBrand;
    private JTextField txtFld_carBrand;
    private JLabel lbl_carModel;
    private JTextField txtFld_carModel;
    private JLabel lbl_carType;
    private JTextField txtFld_carType;
    private JButton btn_addCar;
    private DefaultTableModel tblMdl_carList;   // tablonun stun başlıkları ve diğer değerleri için
    // private Object[] rowTitle_carList;

    public CompanyGUI(Company company) {
        // +pencere yapılandırmsı
        {
            lbl_companyTitle.setText(company.getName());
            setContentPane(wrapper);
            setSize(750,500);
            setTitle(Config.APP_TITLE);
            setLocation(Tool.screenCenterAxis("x",getSize()), Tool.screenCenterAxis("y", getSize()));
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
        }
        // -pencere yapılandırmsı

        // +model Car List için title oluşturuldu
        {
            // toblo başlıkları
            tblMdl_carList = new DefaultTableModel();
            Object[] colTitle_carList = {"no", "Araç ID", "Marka", "Model", "Araç Tipi"};
            tblMdl_carList.setColumnIdentifiers(colTitle_carList);
            // -tablo başlıkları

            // Şirketin arabaları
            int i = 1;
            for(Cars car : Cars.getListByCompany(company.getId())){
                Object[] row = new Object[colTitle_carList.length];
                row[0] = i;
                row[1] = car.getId();
                row[2] = car.getBrand();
                row[3] = car.getModel();
                row[4] = car.getType();
                tblMdl_carList.addRow(row);
                i++;
            }
            tbl_carList.setModel(tblMdl_carList);
            tbl_carList.getTableHeader().setReorderingAllowed(false);
            // -Sirketin arabaları
        }
        // -model Car List için title oluşturuldu

    }
}
