package com.rentacar.model;

import com.rentacar.db.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Cars {
    private int id;
    private int company_id;
    private String brand;
    private String model;
    private String type;

    public Cars(){};
    public Cars(int id, int company_id, String brand, String model, String type) {
        this.id = id;
        this.company_id = company_id;
        this.brand = brand;
        this.model = model;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //---------------------------------------------------------------------------------------------------------------
    public static ArrayList<Cars> fetchCarsByCompany(int company_id){
        ArrayList<Cars> carList = new ArrayList<>();
        String sql = "SELECT id, brand, model, type FROM cars WHERE company_id="+ company_id +"";

        try {
            Statement st = DB.connect().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Cars car = new Cars();
                car.setId(rs.getInt("id"));
                car.setCompany_id(rs.getInt(company_id));
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString("model"));
                car.setType(rs.getString("type"));
                carList.add(car);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carList;
    }
}
