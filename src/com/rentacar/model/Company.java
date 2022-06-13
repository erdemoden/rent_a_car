package com.rentacar.model;

import com.rentacar.db.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Company {
    private int id;
    private String uname;
    private String password;
    private String name;
    private int city_id;

    public Company(){}
    public Company(int id, String uname, String password, String name, int city_id) {
        this.id = id;
        this.uname = uname;
        this.password = password;
        this.name = name;
        this.city_id = city_id;
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

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }




    // ----------------------------------------------------------------------------------------------------------------
    /**
     * veri tabanı doğrulamasından sonra şirket girişi aktif olacak
     */
    public static Company setCompany(String uname, String password){
        Company company;
        String query = "SELECT * FROM company WHERE uname='" + uname + "' AND password='"+ password +"'";
        try {
            Statement st = DB.connect().createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next()){
                company = new Company();
                company.setId(rs.getInt("id"));
                company.setUname(rs.getString("uname"));
                company.setPassword(rs.getString("password"));
                company.setName(rs.getString("name"));
                company.setCity_id(rs.getInt("city_id"));
                return company;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }




}
