package ua.nure.poliakov.Task2.connection;

import java.sql.*;

public class Connect {

    private static final String URL = "jdbc:mysql://localhost:3306/usersdb?user=root&password=pass&autoReconnect=true&useSSL=false";

    private Connection connection;

    public Connect() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        try {
            connection = DriverManager.getConnection(URL);
            System.out.println("connect");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}