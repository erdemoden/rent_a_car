package com.rentacar.view;

import com.rentacar.model.*;
import com.rentacar.tool.Config;
import com.rentacar.tool.Tool;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JTextField txtFld_fistDateSearch;
    private JTextField txtFld_lastDateSearch;
    private JButton araçAraButton;
    private JPanel pnl_search;
    private JLabel lbl_carSearch;
    private JPanel pnl_side;
    private JPanel pnl_reserve;
    private JTextField txtFld_carID;
    private JPanel pnl_reserveCar;
    private JTable tbl_reserveCars;
    private JPanel pnl_sideReserve;
    private JTextField araçTextField1;
    private JButton iptalButton;
    private JTextField txtFld_firstDate;
    private JTextField txtFld_lastDate;
    private JButton btn_reserveMake;
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

        btn_reserveMake.addActionListener(e -> {
            boolean isAdd;
            int id = Integer.parseInt(txtFld_carID.getText());
            if(Tool.isFieldEmpty(txtFld_carID) || Tool.isFieldEmpty(txtFld_firstDate) || Tool.isFieldEmpty(txtFld_lastDate)){
                Tool.showDialog("empty");
            }else{
                if(!txtFld_carID.getText().equals("0")){
                    if(RentalCars.isReserved(Integer.parseInt(txtFld_carID.getText()), txtFld_firstDate.getText(), txtFld_lastDate.getText())){
                        Tool.showDialog("Seçtiğiniz araç belirlediğiniz tarihler arasında daha önce rezerve edilmiş." +
                                " Başka tarih belirleyebilirisiiz");
                    }else{
                        isAdd = RentalCars.add(id, customer.getId(), txtFld_firstDate.getText(), txtFld_lastDate.getText());
                        if(!isAdd){
                            Tool.showDialog("error");
                        }else{
                            Tool.showDialog("done");
                        }
                    }
                }else if(txtFld_carID.getText().equals("0")){
                    Tool.showDialog("Lütfen rezervasyonunu yapmak istediğiniz aracı seçiniz.");
                }
            }
        });

        tbl_rentalCars.getSelectionModel().addListSelectionListener(e -> {
            String selectedCarID = tbl_rentalCars.getValueAt(tbl_rentalCars.getSelectedRow(), 1).toString();
            txtFld_carID.setText(selectedCarID);
        });
    }

    public void loadCarsToTable(){
        tblMdl_rentalCars = new DefaultTableModel();
        Object[] colTitle = {"Sıra", "ID","Şirket", "Marka", "Model", "Araç Tipi", "Günlük Kira", "Şehir", "Tarihinden", "Tarihine"};
        tblMdl_rentalCars.setColumnIdentifiers(colTitle);

        int no = 1;
        for(Cars car : Cars.getBeenRental()){
            Object[] row = new Object[colTitle.length];
            int i = 0;
            row[i++] = no;
            row[i++] = car.getId();
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
        tbl_rentalCars.getColumnModel().getColumn(0).setMaxWidth(30);
        tbl_rentalCars.getColumnModel().getColumn(1).setMaxWidth(40);
    }


}
