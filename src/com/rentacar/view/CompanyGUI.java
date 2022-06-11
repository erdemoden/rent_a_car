package com.rentacar.view;

import com.rentacar.model.Cars;
import com.rentacar.tool.Config;
import com.rentacar.tool.HelpTool;
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
    private DefaultTableModel tblMdl_carList;   // tablonun stun başlıkları ve diğer değerleri için
    // private Object[] rowTitle_carList;

    public CompanyGUI(Company company) {
        // +pencere yapılandırmsı
        {
            setContentPane(wrapper);
            setSize(600,400);
            setTitle(Config.APP_TITLE);
            setLocation(HelpTool.screenCenterAxis("x",getSize()), HelpTool.screenCenterAxis("y", getSize()));
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
        }
        // -pencere yapılandırmsı

        // +model Car List için title oluşturuldu
        {
            tblMdl_carList = new DefaultTableModel();
            Object[] rowTitle_carList = {"ID", "Marka", "Model", "Araç Tipi"};
            tblMdl_carList.setColumnIdentifiers(rowTitle_carList);
            for(Cars car : Cars.fetchCarsByCompany(company.getId())){
                Object[] row = new Object[rowTitle_carList.length];
                row[0] = car.getId();
                row[1] = car.getBrand();
                row[2] = car.getModel();
                row[3] = car.getType();
                tblMdl_carList.addRow(row);
            }
            tbl_carList.setModel(tblMdl_carList);
            tbl_carList.getTableHeader().setReorderingAllowed(false);
        }
        // -model Car List için title oluşturuldu


        // --------------- ekran işleri ---------------
        lbl_companyTitle.setText(company.getName());

    }
}
