package com.rentacar.model;

import com.rentacar.db.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReservedCars {
    private int id;
    private int car_id;
    private String carName;
    private int company_id;
    private int customer_id;
    private double daily_price;
    private String date_first;
    private String date_last;


    // - listeleme için kolay kullanılsın diye FROM Company.class
    public String customerName;
    public String customerSurname;
    public String companyName;

    public ReservedCars(){};
    public ReservedCars(int id, int car_id, int company_id, int customer_id, double daily_price, String date_first, String date_last, String carName) {
        this.id = id;
        this.car_id = car_id;
        this.company_id = company_id;
        this.customer_id = customer_id;
        this.daily_price = daily_price;
        this.date_first = date_first;
        this.date_last = date_last;
        this.carName = carName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public double getDaily_price() {
        return daily_price;
    }

    public void setDaily_price(double daily_price) {
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

    // -----------------------------------------------------------------------------------------------------

    public static boolean add(int car_id, int customer_id, String date_first, String date_last){
        boolean result = false;
        String sql = "INSERT INTO rental_cars (car_id, company_id, customer_id, daily_price, date_first, date_last) " +
                "VALUE (?,?,?,?,?,?)";
        int company_id = Cars.fetchCompany(car_id);
        double daily_price = Cars.fetchPrice(car_id);
        try {
            PreparedStatement ps = DB.connect().prepareStatement(sql);
            ps.setInt(1,car_id);
            ps.setInt(2,company_id);
            ps.setInt(3,customer_id);
            ps.setDouble(4,daily_price);
            ps.setString(5,date_first);
            ps.setString(6,date_last);
            result = ps.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static boolean isReserved(int carID, String dateFirst, String dateLast){
        boolean result = false;
        // rezerve edilmiş mi? Mantıksal yapısı
        String sql = "SELECT * FROM rental_cars " +
                "WHERE car_id = " + carID + " AND " +
                "(date_first <= '" + dateFirst + "' AND date_last >= '" + dateFirst + "' OR " +
                "date_first <= '" + dateLast + "' AND date_last >= '" + dateLast + "')";
        try {
            Statement ps = DB.connect().createStatement();
            ResultSet rs = ps.executeQuery(sql);
            if(rs.next()){
                // daha önce tarihler arasında reserve edilmiş
                result = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }


    // --- Nasıl kulannılmalı ???????
    public static ArrayList<ReservedCars> getListByCompany(Company company){
        ArrayList<ReservedCars> rCars = new ArrayList<>();
        String sql = "SELECT rental_cars.car_id, customer.name, customer.surname, " +
                "rental_cars.daily_price, rental_cars.date_first, rental_cars.date_last " +
                "FROM rental_cars " +
                "INNER JOIN customer " +
                "ON customer.id = rental_cars.customer_id " +
                "WHERE company_id = " + company.getId() + "";
        try {
            Statement st = DB.connect().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                ReservedCars rentalCar = new ReservedCars();
                rentalCar.setCar_id(rs.getInt("car_id"));
                rentalCar.customerName = rs.getString("name");
                rentalCar.customerSurname = rs.getString("surname");
                rentalCar.setDaily_price(rs.getDouble("daily_price"));
                rentalCar.setDate_first(rs.getString("date_first"));
                rentalCar.setDate_last(rs.getString("date_last"));
                rCars.add(rentalCar);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rCars;
    }

    public static ArrayList<ReservedCars> getListByCustomer(Customer customer) {
        ArrayList<ReservedCars> rCars = new ArrayList<>();
        String sql = "SELECT rental_cars.car_id, company.name, " +
                "rental_cars.daily_price, rental_cars.date_first, rental_cars.date_last " +
                "FROM rental_cars " +
                "INNER JOIN company " +
                "ON company.id = rental_cars.company_id " +
                "WHERE customer_id = " + customer.getId() + "";
        try {
            Statement st = DB.connect().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                ReservedCars rentalCar = new ReservedCars();
                rentalCar.setCar_id(rs.getInt("car_id"));
                // car name
                rentalCar.setCarName(Cars.getName(rs.getInt("car_id")));
                rentalCar.companyName = rs.getString("name");
                rentalCar.setDaily_price(rs.getDouble("daily_price"));
                rentalCar.setDate_first(rs.getString("date_first"));
                rentalCar.setDate_last(rs.getString("date_last"));
                rCars.add(rentalCar);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rCars;
    }


}
