package com.company.Connection;

import java.util.*;
import java.sql.*;

public class JDBC {
    public static Connection connection = null;

    public static void connect() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL JDBC Driver Registered!");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw new SQLException();
        }
        connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/books", "root", "8791816v");
        if(connection == null) {
            throw new SQLException();
        } else {
            System.out.println("Successfully connected to MySQL!");
        }
    }

    public static void close() {
        try{
            if(connection != null) {
                connection.close();
                System.out.println("Connection closed!");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Failed to close connection!");
        }
    }

}
