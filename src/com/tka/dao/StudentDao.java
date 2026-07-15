package com.tka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tka.entity.Student;
import com.tka.utility.DBUtility;

public class StudentDao {

    private Connection con = null;
    private Statement stmt = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    // Students Queries
    private String selectQuery = "SELECT * FROM students";
    private String insertQuery = "INSERT INTO students(rollno,name,marks) VALUES(?,?,?)";
    private String getOneStudentQuery = "SELECT * FROM students WHERE rollno=?";
    private String updateQuery = "UPDATE students SET name=?, marks=? WHERE rollno=?";
    private String deleteQuery = "DELETE FROM students WHERE rollno=?";
    private String leaveQuery = "UPDATE students SET leave_status='Applied' WHERE rollno=?";
    private String topperQuery = "SELECT * FROM students ORDER BY marks DESC LIMIT 1";
    private String averageQuery = "SELECT AVG(marks) AS avgMarks FROM students";
    private String searchQuery = "SELECT * FROM students WHERE name LIKE ?";

    // Login Query
    private String loginQuery =
            "SELECT role FROM users WHERE username=? AND password=?";

    // ===================== LOGIN =====================

    public String login(String username, String password) {

        String role = null;

        try {

            con = DBUtility.getConnection();

            pst = con.prepareStatement(loginQuery);

            pst.setString(1, username);
            pst.setString(2, password);

            rs = pst.executeQuery();

            if (rs.next()) {
                role = rs.getString("role");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return role;
    }

    // ===================== DISPLAY ALL =====================

    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        try {

            con = DBUtility.getConnection();

            stmt = con.createStatement();

            rs = stmt.executeQuery(selectQuery);

            while (rs.next()) {

                Student student = new Student(
                        rs.getInt("rollno"),
                        rs.getString("name"),
                        rs.getInt("marks"));

                students.add(student);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return students;
    }

    // ===================== INSERT =====================

    public boolean insertStudents(Student s1) {

        try {

            con = DBUtility.getConnection();

            pst = con.prepareStatement(insertQuery);

            pst.setInt(1, s1.getRollno());
            pst.setString(2, s1.getName());
            pst.setInt(3, s1.getMarks());

            return pst.executeUpdate() > 0;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return false;
    }

    // ===================== GET ONE STUDENT =====================

    public Student getStudentByRollNo(int rollno) {

        Student student = null;

        try {

            con = DBUtility.getConnection();

            pst = con.prepareStatement(getOneStudentQuery);

            pst.setInt(1, rollno);

            rs = pst.executeQuery();

            if (rs.next()) {

                student = new Student(
                        rs.getInt("rollno"),
                        rs.getString("name"),
                        rs.getInt("marks"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return student;
    }

    // ===================== UPDATE =====================

    public boolean updateStudent(int rollno, String name, int marks) {

        try {

            con = DBUtility.getConnection();

            pst = con.prepareStatement(updateQuery);

            pst.setString(1, name);
            pst.setInt(2, marks);
            pst.setInt(3, rollno);

            return pst.executeUpdate() > 0;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return false;
    }

    // ===================== DELETE =====================

    public boolean deleteStudent(int rollno) {

        try {

            con = DBUtility.getConnection();

            pst = con.prepareStatement(deleteQuery);

            pst.setInt(1, rollno);

            return pst.executeUpdate() > 0;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return false;
    }

    // ===================== APPLY LEAVE =====================

    public boolean applyLeave(int rollno) {

        try {

            con = DBUtility.getConnection();

            pst = con.prepareStatement(leaveQuery);

            pst.setInt(1, rollno);

            return pst.executeUpdate() > 0;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return false;
    }

    // ===================== FIND TOPPER =====================

    public Student findTopper() {

        Student topper = null;

        try {

            con = DBUtility.getConnection();

            stmt = con.createStatement();

            rs = stmt.executeQuery(topperQuery);

            if (rs.next()) {

                topper = new Student(
                        rs.getInt("rollno"),
                        rs.getString("name"),
                        rs.getInt("marks"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return topper;
    }

    // ===================== AVERAGE MARKS =====================

    public double findAverageMarks() {

        double avg = 0;

        try {

            con = DBUtility.getConnection();

            stmt = con.createStatement();

            rs = stmt.executeQuery(averageQuery);

            if (rs.next()) {
                avg = rs.getDouble("avgMarks");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return avg;
    }

    // ===================== SEARCH STUDENT =====================

    public List<Student> searchStudentByName(String prefix) {

        List<Student> students = new ArrayList<>();

        try {

            con = DBUtility.getConnection();

            pst = con.prepareStatement(searchQuery);

            pst.setString(1, prefix + "%");

            rs = pst.executeQuery();

            while (rs.next()) {

                Student student = new Student(
                        rs.getInt("rollno"),
                        rs.getString("name"),
                        rs.getInt("marks"));

                students.add(student);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return students;
    }

    // ===================== CLOSE RESOURCES =====================

    private void closeResources() {

        try {

            if (rs != null)
                rs.close();

            if (pst != null)
                pst.close();

            if (stmt != null)
                stmt.close();

            if (con != null)
                con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}