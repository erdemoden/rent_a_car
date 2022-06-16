package com.rentacar.model;

import com.rentacar.db.DB;
import com.rentacar.tool.Tool;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Customer {
    private int id;
    private String uname;
    private String password;
    private String name;
    private String surname;

    public Customer(){}

    public static Customer setCustomer(String uname, String pass) {
        String sql = "SELECT * FROM customer WHERE uname = '"+uname+"' AND password = '" + pass +"'";
        Customer customer;
        try {
            Statement st = DB.connect().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setUname(rs.getString("uname"));
                customer.setPassword(rs.getString("password"));
                customer.setName(rs.getString("name"));
                customer.setSurname(rs.getString("surname"));
                return customer;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    // --------------------------------- İşlemlerimiz ---------------------------------


    public static boolean add(String uname, String password, String name, String surname) {
        boolean result = false;
        String sql = "INSERT INTO customer (uname, password, name, surname) " +
                "VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = DB.connect().prepareStatement(sql);
            ps.setString(1,uname);
            ps.setString(2,password);
            ps.setString(3,name);
            ps.setString(4,surname);
            result = ps.executeUpdate() != -1;
        } catch (SQLException e) {
            Tool.showDialog(e.getMessage());
            throw new RuntimeException(e);
        }
        return result;
    }
}
