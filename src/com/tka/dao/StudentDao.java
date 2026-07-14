package com.tka.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tka.entity.Student;

public class StudentDao {

    public List<Student> getAllStudents() {

        String path = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3305/batch433_db";
        String username = "root";
        String password = "4125";
        String query = "SELECT * FROM students";

        List<Student> students = new ArrayList<>();

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            Class.forName(path);

            con = DriverManager.getConnection(url, username, password);

            stmt = con.createStatement();

            rs = stmt.executeQuery(query);

            while (rs.next()) {

                int rollno = rs.getInt("rollno");
                String name = rs.getString("name");
                int marks = rs.getInt("marks");

                Student student = new Student(rollno, name, marks);

                students.add(student);
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }
}