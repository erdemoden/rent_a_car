package com.rentacar.view;

import com.rentacar.model.Cars;
import com.rentacar.model.City;
import com.rentacar.model.ReservedCars;
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
    private JLabel lbl_uname;
    private JComboBox cmbBx_isRental;
    private JPanel pnl_reserveCars;
    private JTable tbl_reserveCars;
    private JButton btn_refresh;
    private JPanel pnl_etkilesimler;
    private DefaultTableModel tblMdl_carList;   // tablonun stun başlıkları ve diğer değerleri için
    private DefaultTableModel tblMdl_reservedCarList;

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
            loadReservedCarsToTable(company);

            for(String i : City.getIdAllString()){
                cmbBx_cities.addItem(i);
            }
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
                boolean is_rental = cmbBx_isRental.getSelectedItem().toString() == "Tamam" ? true : false;
                boolean result = Cars.addByCompany(company_id,city_id,brand,model,type,price,dateFirst,dateLast,is_rental);
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

        btn_refresh.addActionListener(e -> {
            loadReservedCarsToTable(company);
            loadCarsToTable(company);
        });
    }



    // METODS
    private void loadCarsToTable(Company company){
        // toblo başlıkları
        tblMdl_carList = new DefaultTableModel();
        Object[] colTitle = {"no", /*"Araç ID",*/ "Şehir", "Marka", "Model", "Araç Tipi", "Günlük Fiyat", "Tarihinden", "Tarihine", "Kiralık mı?"};
        tblMdl_carList.setColumnIdentifiers(colTitle);
        // -tablo başlıkları

        // DefaultTableModel clearModel = (DefaultTableModel) tbl_carList.getModel();
        // clearModel.setRowCount(0);  // tablo satırlarını siler

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

    public void loadReservedCarsToTable(Company company){
        tblMdl_reservedCarList = new DefaultTableModel();
        Object[] title = {"Sıra", "Araç ID", "Müşteri Adı", "Müşteri Soyadı", "Günlük Ücreti", "Tarihinden", "Tarihine"};
        tblMdl_reservedCarList.setColumnIdentifiers(title);

        int no = 1;
        for(ReservedCars rCar : ReservedCars.getListByCompany(company)){
            Object[] row = new Object[title.length];
            int i = 0;
            row[i++] = no;
            row[i++] = rCar.getCar_id();
            row[i++] = rCar.customerName;
            row[i++] = rCar.customerSurname;
            row[i++] = rCar.getDaily_price();
            row[i++] = rCar.getDate_first();
            row[i++] = rCar.getDate_last();
            tblMdl_reservedCarList.addRow(row);
            no++;
        }
        tbl_reserveCars.setModel(tblMdl_reservedCarList);
        tbl_reserveCars.getTableHeader().setReorderingAllowed(false);
        tbl_reserveCars.getColumnModel().getColumn(0).setPreferredWidth(10);
        tbl_reserveCars.getColumnModel().getColumn(1).setPreferredWidth(10);
    }



}
