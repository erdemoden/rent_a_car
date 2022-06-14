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
    private JTextField txtFld_dailyPrice;
    private JTextField txtFld_dateFirst;
    private JTextField txtFld_dateLast;
    private JComboBox cmbBx_cities;
    private JPanel pnl_date;
    private JLabel lbl_dateAround;
    private JLabel lbl_dailyPrice;
    private JLabel lbl_city;
    private DefaultTableModel tblMdl_carList;   // tablonun stun başlıkları ve diğer değerleri için

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
        loadCarsToTable(company);
        // -model Car List için title oluşturuldu

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
    }

    private void loadCarsToTable(Company company){
        // toblo başlıkları
        tblMdl_carList = new DefaultTableModel();
        Object[] tableCarTitle = {"no", /*"Araç ID",*/ "Şehir", "Marka", "Model", "Araç Tipi", "Günlük Fiyat", "Tarihinden", "Tarihine"};
        tblMdl_carList.setColumnIdentifiers(tableCarTitle);
        // -tablo başlıkları

        // Şirketin arabaları
        int i = 1;
        for(Cars car : Cars.getListByCompany(company.getId())){
            Object[] row = new Object[tableCarTitle.length];
            int index = 0;
            row[index++] = i;
            //row[index++] = car.getId();
            row[index++] = car.getCity_id();
            row[index++] = car.getBrand();
            row[index++] = car.getModel();
            row[index++] = car.getType();
            row[index++] = car.getDaily_price();
            row[index++] = car.getDate_first();
            row[index++] = car.getDate_last();
            tblMdl_carList.addRow(row);
            i++;
        }
        tbl_carList.setModel(tblMdl_carList);
        tbl_carList.getTableHeader().setReorderingAllowed(false);
        // -Sirketin arabaları
    }
}
