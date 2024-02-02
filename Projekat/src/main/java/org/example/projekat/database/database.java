package org.example.projekat.database;

import java.sql.*;
import java.sql.Connection;
import java.util.List;


public class database {
    public static java.sql.Connection con = null;

    private static String url ="jdbc:mysql://localhost:3306/biblioteka";
    private  static  String dbName = "biblioteka";
    private static String username = "root";
    private static String password = "ab.p779S";

    public static void initializeDB() {
        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement stmt = con.createStatement()) {

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void openConnection() throws SQLException{
        con = DriverManager.getConnection(url , username, password);

    }
    public static void closeConnection() throws  SQLException{
        if(con!= null && con.isClosed()){
            con.close();
        }
    }


}
