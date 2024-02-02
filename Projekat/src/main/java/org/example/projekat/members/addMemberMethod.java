package org.example.projekat.members;

import org.example.projekat.exceptions.invalidLoginException;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.projekat.database.database.con;


public class addMemberMethod {
    /**
     * @throws SQLException
     * @throws invalidLoginException
     */
    public static member addMember(String memberIndex, String name, String lastname, String email, String phoneNumber, String grade, String age) throws SQLException, invalidLoginException {
        member member = new member();


        PreparedStatement statement = con.prepareStatement("INSERT INTO member (memberIndex, name, lastname, email, phoneNumber, grade, age) VALUES (?, ?, ?, ?, ?, ?, ?)");
        statement.setString(1, memberIndex);
        statement.setString(2, name);
        statement.setString(3, lastname);
        statement.setString(4, email);
        statement.setString(5, phoneNumber);
        statement.setString(6, grade);
        statement.setString(7, age);

        int rowsAffected = statement.executeUpdate();


        if (rowsAffected > 0) {

            member.setMemmerIndex(memberIndex);
            member.setName(name);
            member.setLastname(lastname);
            member.setEmail(email);
            member.setPhoneNumber(phoneNumber);
            member.setGrade(grade);
            member.setAge(age);
        } else {

            System.out.println("Failed to add the book to the database.");
        }

        return member;
    }

}
