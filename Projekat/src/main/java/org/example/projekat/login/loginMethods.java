package org.example.projekat.login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.projekat.database.database.con;


public class loginMethods {
    /**
     *
     * @return
     * @throws SQLException
     */
    public static boolean userAcc(String username, String password) throws SQLException {
        user user = new user();
        boolean pass = false;
        PreparedStatement statement = con.prepareStatement("SELECT * FROM librarian WHERE username = ? AND password = ?");
        statement.setString(1, username);
        statement.setString(2, password);

        ResultSet set = statement.executeQuery();

        while(set.next()){

            user.setUsername(set.getString("username"));
            user.setPassword(set.getString("password"));
            if (username.equals(set.getString("username")) && password.equals(set.getString("password"))) {
                pass = true;
                break;
            }




        }
        return pass;

    }
}
