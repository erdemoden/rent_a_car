package com.rentacar.view;

import com.rentacar.model.Cars;
import com.rentacar.tool.Config;
import com.rentacar.tool.Tool;
import com.rentacar.model.Company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JTextField txtFld_dailyPrice;
    private JTextField txtFld_dateFirst;
    private JTextField txtFld_dateLast;
    private JComboBox cmbBx_cities;
    private JPanel pnl_date;
    private JLabel lbl_dateAround;
    private JLabel lbl_dailyPrice;
    private JLabel lbl_city;
    private JLabel lbl_uname;
    private DefaultTableModel tblMdl_carList;   // tablonun stun başlıkları ve diğer değerleri için

    public CompanyGUI(Company company) {
        // +pencere yapılandırmsı
        {
            lbl_companyTitle.setText(company.getName());
            lbl_uname.setText("@"+company.getUname());
            setContentPane(wrapper);
            setSize(750,500);
            setTitle(Config.APP_TITLE);
            setLocation(Tool.screenCenterAxis("x",getSize()), Tool.screenCenterAxis("y", getSize()));
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
            // +model Car List için title oluşturuldu
            loadCarsToTable(company);
            // -model Car List için title oluşturuldu
        }
        // -pencere yapılandırmsı


        // +arac Ekle
        btn_addCar.addActionListener(e -> {
            if(Tool.isFieldEmpty(txtFld_carBrand) || Tool.isFieldEmpty(txtFld_carModel) || Tool.isFieldEmpty(txtFld_carType) || Tool.isFieldEmpty(txtFld_dailyPrice) || Tool.isFieldEmpty(txtFld_dateFirst) || Tool.isFieldEmpty(txtFld_dateLast) ){
                Tool.showDialog("empty");
            }else{
                int company_id = company.getId();
                int city_id = Integer.parseInt(cmbBx_cities.getSelectedItem().toString());
                String brand = txtFld_carBrand.getText();
                String model = txtFld_carModel.getText();
                String type = txtFld_carType.getText();
                double price = Double.parseDouble(txtFld_dailyPrice.getText());
                String dateFirst = txtFld_dateFirst.getText();
                String dateLast = txtFld_dateLast.getText();
                boolean result = Cars.addByCompany(company_id,city_id,brand,model,type,price,dateFirst,dateLast);
                if(!result){
                    Tool.showDialog("error");
                }else {
                    Tool.showDialog("done");
                    // carList 'i yanile
                    loadCarsToTable(company);
                    txtFld_carBrand.setText(null);
                    txtFld_carModel.setText(null);
                    txtFld_carType.setText(null);
                    txtFld_dailyPrice.setText(null);
                    txtFld_dateFirst.setText(null);
                    txtFld_dateLast.setText(null);
                }
            }
        });
        // -arac Ekle

        // çıkış
        btn_exit.addActionListener(e -> {
            this.dispose();
        });
        //-çıkış
    }



    // METODS
    private void loadCarsToTable(Company company){
        // toblo başlıkları
        tblMdl_carList = new DefaultTableModel();
        Object[] colTitle = {"no", /*"Araç ID",*/ "Şehir", "Marka", "Model", "Araç Tipi", "Günlük Fiyat", "Tarihinden", "Tarihine", "Kiralık mı?"};
        tblMdl_carList.setColumnIdentifiers(colTitle);
        // -tablo başlıkları

        // Şirketin arabaları
        int no = 1;
        for(Cars car : Cars.getListByCompany(company.getId())){
            Object[] row = new Object[colTitle.length];
            int i = 0;
            row[i++] = no;
            //row[i++] = car.getId();
            row[i++] = car.getCity_id();
            row[i++] = car.getBrand();
            row[i++] = car.getModel();
            row[i++] = car.getType();
            row[i++] = car.getDaily_price();
            row[i++] = car.getDate_first();
            row[i++] = car.getDate_last();
            row[i++] = car.getIs_rental();
            tblMdl_carList.addRow(row);
            no++;
        }
        tbl_carList.setModel(tblMdl_carList);
        tbl_carList.getTableHeader().setReorderingAllowed(false);
        tbl_carList.getColumnModel().getColumn(0).setPreferredWidth(10);
        tbl_carList.getColumnModel().getColumn(1).setPreferredWidth(10);
        // -Sirketin arabaları
    }


}
