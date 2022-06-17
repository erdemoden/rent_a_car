package com.rentacar.model;

import com.rentacar.db.DB;
import com.rentacar.tool.Tool;

import java.sql.PreparedStatement;
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

    public static String getNameByID(int id){
        String name = null;
        String sql = "SELECT name FROM company WHERE id = ?";
        try {
            PreparedStatement ps = DB.connect().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                name = rs.getString("name");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return name;
    }

    public static boolean add(String uname, String password, String passwordTry, String name, int city_id){
        boolean result = false;
        if(password.equals(passwordTry)){
            String sql = "INSERT INTO company (uname, password, name, city_id) VALUES (?,?,?,?)";
            try {
                PreparedStatement ps = DB.connect().prepareStatement(sql);
                ps.setString(1,uname);
                ps.setString(2,password);
                ps.setString(3,name);
                ps.setInt(4, city_id);
                result = ps.executeUpdate() != -1;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else{
            Tool.showDialog("not_equal_pass");
        }
        return  result;
    }


}
