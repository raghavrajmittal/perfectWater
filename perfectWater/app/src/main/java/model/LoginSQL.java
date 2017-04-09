package model;
import java.sql.*;

import com.example.thushara.perfectwater.Controller.SQLiteConnection;

/**
 * Created by baria on 4/6/17.
 */

public class LoginSQL {

    Connection connection;

    /**
     * constructor for LoginSQL
     */
    public LoginSQL() {
        connection = SQLiteConnection.Connector();
        if (connection == null) {
//            System.exit(1);
            System.out.print("FAILED CONNECTION TO DATABASE");
        } else {
            System.out.println("Connected");
        }

    }

    /**
     * checks to see if databse is connected
     * @return boolean if db is connected or not
     */
    public boolean isDbConnected() {
        try {
            return !connection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * see if db is closed
     */

    public void closedDatabase() {
        try {
            connection.close();

        }catch (Exception e) {
            System.out.println("Error");
        }
    }

    /**
     * connect database
     */
    public void connectDatabase() {
        connection = SQLiteConnection.Connector();
    }

    /**
     * check if there's a valid login
     * @param user username
     * @param pass password
     * @return boolean saying if it's a login
     */
    public boolean isLogin(String user, String pass) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        return true;
    }

}
