package com.rentacar.view;

import com.rentacar.model.*;
import com.rentacar.tool.Config;
import com.rentacar.tool.Tool;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CustomerGUI extends JFrame{
    private JPanel wrapper;
    private JLabel lbl_customer;
    private JPanel pnl_top;
    private JButton btn_exit;
    private JLabel lbl_uname;
    private JTabbedPane tbbdPn_customer;
    private JPanel pnl_rentalCars;
    private JLabel lbl_cityID;
    private JComboBox cmbBx_cityID;
    private JTextField txtFld_brand;
    private JTextField txtFld_type;
    private JTextField txtFld_dateFirst;
    private JTextField txtFld_dateLast;
    private JButton btn_search;
    private JPanel pnl_search;
    private JLabel lbl_carSearch;
    private JPanel pnl_side;
    private JPanel pnl_reserve;
    private JTextField txtFld_carID;
    private JPanel pnl_reserveCar;
    private JPanel pnl_sideReserve;
    private JTextField txtFld_deleteReserve;
    private JButton btn_deleteReserve;
    private JTextField txtFld_firstDate;
    private JTextField txtFld_lastDate;
    private JButton btn_reserveMake;
    private JTable tbl_rentalCars;
    private JTable tbl_reservedCars;
    private JButton btn_allCar;
    private DefaultTableModel tblMdl_rentalCars;
    private DefaultTableModel tblMdl_reservedCars;


    public CustomerGUI(Customer customer) {

        {
            lbl_customer.setText(customer.getName().toUpperCase() + " " + customer.getSurname().toUpperCase());
            lbl_uname.setText("@"+customer.getUname());
            setContentPane(wrapper);
            setSize(1080,675);
            setTitle(Config.APP_TITLE);
            setLocation(Tool.screenCenterAxis("x",getSize()), Tool.screenCenterAxis("y", getSize()));
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
            loadCarsToTable();
            loadReservedCarsToTable(customer);
            for(String i : City.getIdAllString()){
                cmbBx_cityID.addItem(i);
            }
        }

        btn_exit.addActionListener(e -> {
            this.dispose();
        });

        btn_reserveMake.addActionListener(e -> {
            boolean isAdd;
            int id = Integer.parseInt(txtFld_carID.getText());
            if(Tool.isFieldEmpty(txtFld_carID) || Tool.isFieldEmpty(txtFld_firstDate) || Tool.isFieldEmpty(txtFld_lastDate)){
                Tool.showDialog("empty");
            }else{
                if(txtFld_carID.getText().equals("0")){
                    Tool.showDialog("Lütfen rezervasyonunu yapmak istediğiniz aracı seçiniz.");
                }else if(!txtFld_carID.getText().equals("0")){
                    if(!Cars.isBetweenDates(Integer.parseInt(txtFld_carID.getText()), txtFld_firstDate.getText(), txtFld_lastDate.getText())){
                        int companyID = Cars.fetchCompany(Integer.parseInt(txtFld_carID.getText()));
                        String compName = Company.getNameByID(companyID);
                        Tool.showDialog(compName + ", bu tarihler arasında aracını kiralamıyor! Lütfen uygun tarih giriniz.");
                    }else{
                        if(ReservedCars.isReserved(Integer.parseInt(txtFld_carID.getText()), txtFld_firstDate.getText(), txtFld_lastDate.getText())){
                            Tool.showDialog("Seçtiğiniz araç, belirlediğiniz tarihler arasında daha önce rezerve edilmiş." +
                                    " Başka tarih belirleyebilirisiniz.");
                        }else{
                            isAdd = ReservedCars.add(id, customer.getId(), txtFld_firstDate.getText(), txtFld_lastDate.getText());
                            if(!isAdd){
                                Tool.showDialog("error");
                            }else{
                                Tool.showDialog("done");
                                loadReservedCarsToTable(customer);
                            }
                        }
                    }
                }
            }
        });

        // kiralık araçlar listesi için tablo dinleyicisi
        tbl_rentalCars.getSelectionModel().addListSelectionListener(e -> {
            try{
                String selectedCarID = tbl_rentalCars.getValueAt(tbl_rentalCars.getSelectedRow(), 0).toString();
                txtFld_carID.setText(selectedCarID);
            }catch(Exception exception){
                System.out.println("Kontrollü: " + exception.getMessage());
            }
        });

        tbl_reservedCars.getSelectionModel().addListSelectionListener(e -> {
            try{
                String selectCarID = tbl_reservedCars.getValueAt(tbl_reservedCars.getSelectedRow(), 0).toString();
                txtFld_deleteReserve.setText(selectCarID);
            }catch(Exception exception){
                System.out.println("Kotrollü: " + exception.getMessage());
            }
        });

        btn_search.addActionListener(e -> {
            int cityID = Integer.parseInt(cmbBx_cityID.getSelectedItem().toString());
            String brand = txtFld_brand.getText();
            String type = txtFld_type.getText().trim();
            String dateF = txtFld_dateFirst.getText().trim();
            String dateL = txtFld_dateLast.getText().trim();

            ArrayList<Cars> cars = Cars.searchCarForCustomer(cityID, brand, type, dateF, dateL);
            loadCarsToTable(cars);
        });
        btn_allCar.addActionListener(e -> {
            loadCarsToTable();
        });
        btn_deleteReserve.addActionListener(e -> {
            if(Tool.isFieldEmpty(txtFld_deleteReserve)){
                Tool.showDialog("Lütfen Aracı seçin");
            }else{
                int id = Integer.parseInt(txtFld_deleteReserve.getText());
                if(ReservedCars.deleteReserve(id)){
                    loadReservedCarsToTable(customer);
                    Tool.showDialog("Silme işleminiz başarılı!");
                }else{
                    Tool.showDialog("Maalesef verilen taahhüt içerisinde olmadığınız için, iptal işleminiz gerçekleştirilmedi.");
                }
            }
        });
    }

    public void loadCarsToTable(){
        tblMdl_rentalCars = new DefaultTableModel();
        Object[] colTitle = {"Araç ID","Şirket", "Marka", "Model", "Araç Tipi", "Günlük Kira", "Şehir", "Tarihinden", "Tarihine", "Sıra"};
        tblMdl_rentalCars.setColumnIdentifiers(colTitle);

        int no = 1;
        for(Cars car : Cars.getBeenRental()){
            Object[] row = new Object[colTitle.length];
            int i = 0;
            row[i++] = car.getId();
            row[i++] = Company.getNameByID(car.getCompany_id());
            row[i++] = car.getBrand();
            row[i++] = car.getModel();
            row[i++] = car.getType();
            row[i++] = car.getDaily_price();
            row[i++] = City.getName(car.getCity_id());
            row[i++] = car.getDate_first();
            row[i++] = car.getDate_last();
            row[i++] = no;
            tblMdl_rentalCars.addRow(row);
            no++;
        }
        tbl_rentalCars.setModel(tblMdl_rentalCars);
        tbl_rentalCars.getTableHeader().setReorderingAllowed(false);
        tbl_rentalCars.getColumnModel().getColumn(0).setMaxWidth(50);
        tbl_rentalCars.getColumnModel().getColumn(colTitle.length-1).setMaxWidth(50);
    }

    public void loadCarsToTable(ArrayList<Cars> cars){
        tblMdl_rentalCars = new DefaultTableModel();
        Object[] colTitle = {"Araç ID","Şirket", "Marka", "Model", "Araç Tipi", "Günlük Kira", "Şehir", "Tarihinden", "Tarihine", "Sıra"};
        tblMdl_rentalCars.setColumnIdentifiers(colTitle);

        int no = 1;
        for(Cars car : cars){
            Object[] row = new Object[colTitle.length];
            int i = 0;
            row[i++] = car.getId();
            row[i++] = Company.getNameByID(car.getCompany_id());
            row[i++] = car.getBrand();
            row[i++] = car.getModel();
            row[i++] = car.getType();
            row[i++] = car.getDaily_price();
            row[i++] = City.getName(car.getCity_id());
            row[i++] = car.getDate_first();
            row[i++] = car.getDate_last();
            row[i++] = no;
            tblMdl_rentalCars.addRow(row);
            no++;
        }
        tbl_rentalCars.setModel(tblMdl_rentalCars);
        tbl_rentalCars.getTableHeader().setReorderingAllowed(false);
        tbl_rentalCars.getColumnModel().getColumn(0).setMaxWidth(50);
        tbl_rentalCars.getColumnModel().getColumn(colTitle.length-1).setMaxWidth(50);
    }

    public void loadReservedCarsToTable(Customer customer){
        tblMdl_reservedCars = new DefaultTableModel();
        Object[] title = {"ID", "Araç ID", "Firma",  "Araç", "Günlük Fiyat", "Başlangıç Tarihi", "Bitiş Tarihi", "Sıra"};
        tblMdl_reservedCars.setColumnIdentifiers(title);

        int no = 1;
        for(ReservedCars rCar : ReservedCars.getListByCustomer(customer)){
            Object[] row = new Object[title.length];
            int i = 0;
            row[i++] = rCar.getId();
            row[i++] = rCar.getCar_id();
            row[i++] = rCar.companyName;
            row[i++] = Cars.getName(rCar.getCar_id());
            row[i++] = rCar.getDaily_price();
            row[i++] = rCar.getDate_first();
            row[i++] = rCar.getDate_last();
            row[i++] = no;
            tblMdl_reservedCars.addRow(row);
            no++;
        }
        tbl_reservedCars.setModel(tblMdl_reservedCars);
        tbl_reservedCars.getTableHeader().setReorderingAllowed(false);
        tbl_reservedCars.getColumnModel().getColumn(0).setPreferredWidth(20);
        tbl_reservedCars.getColumnModel().getColumn(1).setPreferredWidth(50);
        tbl_reservedCars.getColumnModel().getColumn(title.length-1).setPreferredWidth(50);
    }


}
