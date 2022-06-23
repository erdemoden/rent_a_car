package com.rentacar.model;

import com.rentacar.db.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class City {
    private int id;
    private int city_id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // --------------------------------------------------------------
    public static String getName(int city_id){
        City city = null;
        String sql = "SELECT name FROM city WHERE city_id=?";
        try {
            PreparedStatement ps = DB.connect().prepareStatement(sql);
            ps.setInt(1,city_id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                city = new City();
                city.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return city.getName();
    }

    public static ArrayList<String> getIdAllString(){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 81; i++){
            list.add(i, String.valueOf(i+1));
        }
        return list;
    }
}
