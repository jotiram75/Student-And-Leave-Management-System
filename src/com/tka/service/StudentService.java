package com.tka.service;

import java.util.List;

import com.tka.dao.StudentDao;
import com.tka.entity.Student;

public class StudentService {

    StudentDao studentDao = new StudentDao();

    // Login
    public String login(String username, String password) {

        if (username == null || username.trim().isEmpty() ||
            password == null || password.trim().isEmpty()) {
            return null;
        }

        return studentDao.login(username, password);
    }

    // 1. Display all students
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    // 2. Add student
    public boolean insertStudents(Student s1) {

        if (s1.getRollno() <= 0 || s1.getMarks() < 0 || s1.getMarks() > 100) {
            return false;
        }

        return studentDao.insertStudents(s1);
    }

    // 3. Display one student
    public Student getStudentByRollNo(int rollno) {

        if (rollno <= 0) {
            return null;
        }

        return studentDao.getStudentByRollNo(rollno);
    }

    // 4. Update student
    public boolean updateStudent(int rollno, String name, int marks) {

        if (rollno <= 0 || marks < 0 || marks > 100) {
            return false;
        }

        return studentDao.updateStudent(rollno, name, marks);
    }

    // 5. Delete student
    public boolean deleteStudent(int rollno) {

        if (rollno <= 0) {
            return false;
        }

        return studentDao.deleteStudent(rollno);
    }

    

    // 7. Find topper
    public Student findTopper() {
        return studentDao.findTopper();
    }

    // 8. Find average marks
    public double findAverageMarks() {
        return studentDao.findAverageMarks();
    }

    // 9. Search student by name
    public List<Student> searchStudentByName(String prefix) {

        if (prefix == null || prefix.trim().isEmpty()) {
            return null;
        }

        return studentDao.searchStudentByName(prefix);
    }
    
}