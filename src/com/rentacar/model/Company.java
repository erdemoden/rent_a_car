package com.rentacar.model;

import com.rentacar.helptool.HelpTool;

public class Company {
    private int id;
    private String uname;
    private String password;
    private String name;
    private int city_id;

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

}
