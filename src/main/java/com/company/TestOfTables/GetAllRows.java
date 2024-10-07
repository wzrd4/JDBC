package com.company.TestOfTables;

import com.company.Connection.JDBC;

import java.sql.*;
import java.util.*;

public class GetAllRows {
    public static void main(String[] args) {
        Statement stmt = null;
        try{

            JDBC.connect();

            stmt = JDBC.connection.createStatement();

            String exampleQuery1 = "SELECT * FROM Authors";
            System.out.println("Authors:");
            ResultSet rs1 = stmt.executeQuery(exampleQuery1);
            while (rs1.next()) {
                int id = rs1.getInt("authorID");
                String firstName = rs1.getString("firstName");
                String lastName = rs1.getString("lastName");
                System.out.println(id + "\t" + firstName + "\t" + lastName);
            }

            String exampleQueryS = "SELECT * FROM Authors order by firstName, lastName";
            System.out.println("Authors SORTEDDDDD:");
            ResultSet rs5 = stmt.executeQuery(exampleQueryS);
            while (rs5.next()) {
                int id = rs5.getInt("authorID");
                String firstName = rs5.getString("firstName");
                String lastName = rs5.getString("lastName");
                System.out.println(id + "\t" + firstName + "\t" + lastName);
            }

            String exampleQuery2 = "SELECT * FROM AuthorISBN";
            System.out.println("Authors ISBN:");
            ResultSet rs2 = stmt.executeQuery(exampleQuery2);
            while (rs2.next()) {
                int id = rs2.getInt(1);
                String authorISBN = rs2.getString(2);

                System.out.println(id + "\t" + authorISBN);
            }

            String exampleQuery3 = "SELECT * FROM Titles";
            System.out.println("Titles:");
            ResultSet rs3 = stmt.executeQuery(exampleQuery3);
            while (rs3.next()) {
                String id = rs3.getString(1);
                String title = rs3.getString(2);
                int editionNumber = rs3.getInt(3);
                String year = rs3.getString(4);
                int publisherID = rs3.getInt(5);
                float price = rs3.getFloat(6);

                System.out.println(id + "\t" + title + "\t" + editionNumber + "\t" + year + "\t"
                        + publisherID + "\t" + price);
            }

            String exampleQuery4 = "SELECT * FROM Publishers";
            System.out.println("Publishers:");
            ResultSet rs4 = stmt.executeQuery(exampleQuery4);
            while (rs4.next()) {
                int id = rs4.getInt(1);
                String publisherName = rs4.getString(2);

                System.out.println(id + "\t" + publisherName);
            }

            int idd = 1;
            String exampleQuery6 = "SELECT * FROM titles where publisherID=" + idd + " ORDER BY title";
            System.out.println("Sorted titties by " + idd + ":");
            ResultSet rs6 = stmt.executeQuery(exampleQuery6);
            while (rs6.next()) {
                String id = rs6.getString(1);
                String title = rs6.getString(2);
                int editionNumber = rs6.getInt(3);
                String year = rs6.getString(4);
                int publisherID = rs6.getInt(5);
                float price = rs6.getFloat(6);

                System.out.println(id + "\t" + title + "\t" + editionNumber + "\t" + year + "\t"
                        + publisherID + "\t" + price);
            }

        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } finally {
            // Finally block, used to close resources
            JDBC.close();
        }
    }
}

