package ru.babaev.Service;

import ru.babaev.ConfigApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static String username;
    static String password;
    static String url;

    static DBConnection dbInstance;
    public Connection connection;

    private DBConnection() throws SQLException, ClassNotFoundException {
        username = ConfigApp.getLoginBD();
        password = ConfigApp.getPasswordBD();
        url = ConfigApp.getConnectionStringBD();
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(url, username, password);
    }

    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
        if(dbInstance==null){
            dbInstance = new DBConnection();
        }
        return dbInstance;
    }

}