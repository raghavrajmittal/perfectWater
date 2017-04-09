package com.example.thushara.perfectwater.Controller;

//package model;
import java.sql.*;




/**
 * Created by baria on 4/6/17.
 */



public class SQLiteConnection {

    /**
     * creates connection with database
     * @return connection to database
     */

    public static Connection Connector() {
        try {
            System.out.println("CONNECTION FAILED AT STEP 0");
            Class.forName("org.sqlite.JDBC");
            System.out.println("CONNECTION FAILED AT STEP 1");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:Database.db");
            System.out.println("CONNECTION FAILED AT STEP 1");
            return conn;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

}
