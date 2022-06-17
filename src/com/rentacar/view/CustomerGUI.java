package com.rentacar.view;

import com.rentacar.model.Cars;
import com.rentacar.model.City;
import com.rentacar.model.Company;
import com.rentacar.model.Customer;
import com.rentacar.tool.Config;
import com.rentacar.tool.Tool;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CustomerGUI extends JFrame{
    private JPanel wrapper;
    private JLabel lbl_customer;
    private JPanel pnl_top;
    private JButton btn_exit;
    private JLabel lbl_uname;
    private JTabbedPane tbbdPn_customer;
    private JPanel pnl_rentalCars;
    private JTable tbl_rentalCars;
    private JLabel lbl_cityID;
    private JComboBox comboBox1;
    private JTextField TOGGTextField;
    private JTextField docatoTextField;
    private JTextField a20220601TextField;
    private JTextField a20220626TextField;
    private JButton araçAraButton;
    private JPanel pnl_search;
    private JLabel lbl_carSearch;
    private JPanel pnl_side;
    private JPanel pnl_reserve;
    private JButton rezerveEtButton;
    private JTextField araçTextField;
    private JPanel pnl_reserveCar;
    private JTable tbl_reserveCars;
    private JPanel pnl_sideReserve;
    private JTextField araçTextField1;
    private JButton iptalButton;
    private DefaultTableModel tblMdl_rentalCars;


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
        }


        btn_exit.addActionListener(e -> {
            this.dispose();
        });
    }

    public void loadCarsToTable(){
        tblMdl_rentalCars = new DefaultTableModel();
        Object[] colTitle = {"no","Şirket", "Marka", "Model", "Araç Tipi", "Günlük Kira", "Şehir", "Tarihinden", "Tarihine"};
        tblMdl_rentalCars.setColumnIdentifiers(colTitle);

        int no = 1;
        for(Cars car : Cars.getAll()){
            Object[] row = new Object[colTitle.length];
            int i = 0;
            row[i++] = no;
            row[i++] = Company.getNameByID(car.getCompany_id());
            row[i++] = car.getBrand();
            row[i++] = car.getModel();
            row[i++] = car.getType();
            row[i++] = car.getDaily_price();
            row[i++] = City.getName(car.getCity_id());
            row[i++] = car.getDate_first();
            row[i++] = car.getDate_last();
            tblMdl_rentalCars.addRow(row);
            no++;
        }
        tbl_rentalCars.setModel(tblMdl_rentalCars);
        tbl_rentalCars.getTableHeader().setReorderingAllowed(false);
        tbl_rentalCars.getColumnModel().getColumn(0).setMaxWidth(35);

    }

    public void AlterneLoadCarsToTable(){
        tblMdl_rentalCars = new DefaultTableModel();
        Object[] colTitle = {"no","Şirket", "Marka", "Model", "Araç Tipi", "Günlük Kira", "Şehir", "Tarihinden", "Tarihine"};
        tblMdl_rentalCars.setColumnIdentifiers(colTitle);

    }
}
