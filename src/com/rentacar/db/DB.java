package com.rentacar.db;

import com.rentacar.tool.Config;
import com.rentacar.tool.Tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private Connection connect = null;

    public Connection connectDB(){
        try {
            this.connect = DriverManager.getConnection(Config.DB_URL, Config.DB_USER, Config.DB_PASSWORD);
        } catch (SQLException e) {
            Tool.showDialog("Sunuculara bağlanırken hata oluştu. Veri tabanı bilgilerinizi kontrol edin!\n\n" +
                    "Sistemden Gelen Hata: " + e.getMessage() );
            e.printStackTrace();
        }
        return this.connect;
    }

    public static Connection connect(){
        DB db = new DB();
        return db.connectDB();
    }
}
