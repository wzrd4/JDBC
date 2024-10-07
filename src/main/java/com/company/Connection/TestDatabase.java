package com.company.Connection;

import java.sql.*;
import java.util.*;

public class TestDatabase {
    public static void main(String[] args) {
        System.out.println("-------------- MySQL JDBC Connection Testing ---------------");
        try{
            JDBC.connect();

            Statement stmt = JDBC.connection.createStatement();/*
            stmt.executeUpdate("INSERT INTO publishers (publisherName) values ('Iraida')");

            stmt.executeUpdate("UPDATE publishers SET publisherName = 'Ksюsha' WHERE publisherID = 1");*/

            /*stmt.executeUpdate("insert into authors (firstName, lastName) values ('Vladislava','Smiv')");*/
            /*stmt.executeUpdate("insert into titles (isbn, title, editionNumber, year, publisherID, price) " +
                    "values ('1923012745', 'LOloloshka', 993, 1, 1, 999.99)");
            stmt.executeUpdate("insert into authorisbn (authorID, isbn) values(16, '1923012745')");*/

            /*stmt.executeUpdate("UPDATE Authors set firstName='Vlada' where authorID=16");*/

            /*stmt.executeUpdate("insert into titles (isbn, title, editionNumber, year, publisherID, price)" +
                    "VALUES ('123456789', 'JDH', 992, 2, " +
                    "(select publisherID from publishers where publisherName='Ksюsha'), 991.99)");*/

            stmt.executeUpdate("INSERT INTO authorISBN (authorID, isbn)" +
                    " values ((select authorID from authors where firstName='Vlada'), '123456789')");
        } catch (SQLException e){
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
        JDBC.close();
    }
}
