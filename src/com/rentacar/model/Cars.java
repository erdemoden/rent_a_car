package com.rentacar.model;

import com.rentacar.db.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Cars {
    private int id;
    private int company_id;
    private int city_id;
    private String brand;
    private String model;
    private String type;
    private Double daily_price;
    private String date_first;
    private String date_last;

    public Cars(){};

    public Cars(int id, int company_id, int city_id, String brand, String model, String type, Double daily_price, String date_first, String date_last) {
        this.id = id;
        this.company_id = company_id;
        this.city_id = city_id;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.daily_price = daily_price;
        this.date_first = date_first;
        this.date_last = date_last;
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

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
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

    public Double getDaily_price() {
        return daily_price;
    }

    public void setDaily_price(Double daily_price) {
        this.daily_price = daily_price;
    }

    public String getDate_first() {
        return date_first;
    }

    public void setDate_first(String date_first) {
        this.date_first = date_first;
    }

    public String getDate_last() {
        return date_last;
    }

    public void setDate_last(String date_last) {
        this.date_last = date_last;
    }

    //---------------------------------------------------------------------------------------------------------------
    public static ArrayList<Cars> getListByCompany(int company_id){
        ArrayList<Cars> carList = new ArrayList<>();
        String sql = "SELECT id, city_id, brand, model, type, daily_price, date_first, date_last " +
                "FROM cars " +
                "WHERE company_id="+ company_id + " ORDER BY id DESC";

        try {
            Statement st = DB.connect().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Cars car = new Cars();
                car.setId(rs.getInt("id"));
                car.setCompany_id(company_id);
                car.setCity_id(rs.getInt("city_id"));
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString("model"));
                car.setType(rs.getString("type"));
                car.setDaily_price(rs.getDouble("daily_price"));
                car.setDate_first(rs.getString("date_first"));
                car.setDate_last(rs.getString("date_last"));
                carList.add(car);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carList;
    }

    public static boolean addByCompany(int company_id, int city_id, String brand, String model, String type, double daily_price, String date_first, String date_last){
        boolean result = false;
        String sql = "INSERT INTO cars " +
                "(company_id, city_id, brand, model, type, daily_price, date_first, date_last) " +
                "VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DB.connect().prepareStatement(sql);
            ps.setInt(1,company_id);
            ps.setInt(2,city_id);
            ps.setString(3,brand);
            ps.setString(4,model);
            ps.setString(5,type);
            ps.setDouble(6,daily_price);
            ps.setString(7,date_first);
            ps.setString(8,date_last);
            result = ps.executeUpdate() != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
