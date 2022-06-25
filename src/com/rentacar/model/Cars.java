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
    private boolean is_rental;

    public Cars(){};

    public Cars(int id, int company_id, int city_id, String brand, String model, String type, Double daily_price, String date_first, String date_last, boolean is_rental) {
        this.id = id;
        this.company_id = company_id;
        this.city_id = city_id;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.daily_price = daily_price;
        this.date_first = date_first;
        this.date_last = date_last;
        this.is_rental = is_rental;
    }

    public static boolean isBetweenDates(int car_id, String date_first, String date_last) {
        boolean result = false;
        String sql = "SELECT * FROM cars " +
                "WHERE id = " + car_id + " AND " +
                "(date_first <= '" + date_first + "' AND date_last >= '" + date_last + "')";
        try {
            Statement st = DB.connect().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
                result = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static String getName(int car_id) {
        String result = "Araba Adı";
        String sql = "SELECT brand FROM cars WHERE id =" + car_id;
        try {
            Statement st = DB.connect().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
                result = rs.getString("brand");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
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

    public boolean getIs_rental() {
        return is_rental;
    }

    public void setIs_rental(boolean is_rental) {
        this.is_rental = is_rental;
    }

    //---------------------------------------------------------------------------------------------------------------
    public static ArrayList<Cars> getListByCompany(int company_id){
        ArrayList<Cars> cars = new ArrayList<>();
        String sql = "SELECT id, city_id, brand, model, type, daily_price, date_first, date_last, is_rental " +
                "FROM cars " +
                "WHERE company_id="+ company_id ;

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
                car.setIs_rental(rs.getBoolean("is_rental"));
                cars.add(car);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }

    public static ArrayList<Cars> getAll(){
        ArrayList<Cars> cars = new ArrayList<>();
        String sql = "SELECT * FROM cars";
        try {
            PreparedStatement ps = DB.connect().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Cars car = new Cars();
                car.setId(rs.getInt("id"));
                car.setCompany_id(rs.getInt("company_id"));
                car.setCity_id(rs.getInt("city_id"));
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString("model"));
                car.setType(rs.getString("type"));
                car.setDaily_price(rs.getDouble("daily_price"));
                car.setDate_first(rs.getString("date_first"));
                car.setDate_last(rs.getString("date_last"));
                car.setIs_rental(rs.getBoolean("is_rental"));
                cars.add(car);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }

    public static ArrayList<Cars> getBeenRental(){
        ArrayList<Cars> cars = new ArrayList<>();
        String sql = "SELECT * FROM cars WHERE is_rental = true";
        try {
            PreparedStatement ps = DB.connect().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Cars car = new Cars();
                car.setId(rs.getInt("id"));
                car.setCompany_id(rs.getInt("company_id"));
                car.setCity_id(rs.getInt("city_id"));
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString("model"));
                car.setType(rs.getString("type"));
                car.setDaily_price(rs.getDouble("daily_price"));
                car.setDate_first(rs.getString("date_first"));
                car.setDate_last(rs.getString("date_last"));
                car.setIs_rental(rs.getBoolean("is_rental"));
                cars.add(car);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }

    public static ArrayList<Cars> searchCarForCustomer(int cityID, String brand, String type, String dateF, String dateL) {
        ArrayList<Cars> cars = new ArrayList<>();
        String sql = "SELECT id, company_id, city_id, brand, model, type, daily_price, date_first, date_last, is_rental "+
                    "FROM cars "+
                    "WHERE (city_id = " + cityID + ") AND" +
                    "(brand LIKE '%"+ brand +"%')  AND "+
                    "(type LIKE '%"+type+"%')" ;
        try {
            PreparedStatement st = DB.connect().prepareStatement(sql);
            /*
            st.setInt(1,cityID);
            st.setString(2,brand);
            st.setString(3, type);
            */
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Cars car = new Cars();
                car.setId(rs.getInt("id"));
                car.setCompany_id(rs.getInt("company_id"));
                car.setCity_id(rs.getInt("city_id"));
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString("model"));
                car.setType(rs.getString("type"));
                car.setDaily_price(rs.getDouble("daily_price"));
                car.setDate_first(rs.getString("date_first"));
                car.setDate_last(rs.getString("date_last"));
                car.setIs_rental(rs.getBoolean("is_rental"));
                cars.add(car);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }

    public static boolean doActive(int carID, int companyID) {
        boolean result = false;
        String sql2 = "SELECT * FROM cars WHERE id = " +carID+ " AND is_rental = 1 AND company_id = " + companyID;
        try {
            Statement st2 = DB.connect().createStatement();
            ResultSet rs2 = st2.executeQuery(sql2);
            if(!rs2.next()){
                String sql = "UPDATE cars SET is_rental = '1' WHERE id = " + carID + " AND company_id = " + companyID;
                try {
                    Statement st = DB.connect().createStatement();
                    int rs = st.executeUpdate(sql);
                    if(rs != -1){
                        result = true;
                    }else{
                        result = false;
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }else{
                result = false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static boolean doPassive(int carID, int companyID) {
        boolean result = false;
        String sql2 = "SELECT * FROM cars WHERE id = " +carID+ " AND is_rental = 0 AND company_id = " + companyID;
        try {
            Statement st2 = DB.connect().createStatement();
            ResultSet rs2 = st2.executeQuery(sql2);
            if(!rs2.next()){
                String sql = "UPDATE cars SET is_rental = '0' WHERE id = " + carID + " AND company_id = " + companyID;
                try {
                    Statement st = DB.connect().createStatement();
                    int rs = st.executeUpdate(sql);
                    if(rs != -1){
                        result = true;
                    }else{
                        result = false;
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }else{
                result = false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }




    public static boolean addByCompany(int company_id, int city_id, String brand, String model, String type, double daily_price, String date_first, String date_last, Boolean is_rental){
        boolean result = false;
        String sql = "INSERT INTO cars " +
                "(company_id, city_id, brand, model, type, daily_price, date_first, date_last, is_rental) " +
                "VALUES (?,?,?,?,?,?,?,?,?)";
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
            ps.setBoolean(9,is_rental);
            result = ps.executeUpdate() != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static int totalCars(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM cars";
        try {
            Statement st = DB.connect().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return total;
    }

    public static int fetchCompany(int car_id){
        int result = 0;
        String sql = "SELECT company_id FROM cars WHERE id = ?";
        try {
            PreparedStatement ps = DB.connect().prepareStatement(sql);
            ps.setInt(1, car_id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                result = rs.getInt("company_id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static Double fetchPrice(int car_id){
        double result = 0.0;
        String sql = "SELECT daily_price FROM cars WHERE id = ?";
        try {
            PreparedStatement ps = DB.connect().prepareStatement(sql);
            ps.setInt(1,car_id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                result = rs.getDouble("daily_price");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
