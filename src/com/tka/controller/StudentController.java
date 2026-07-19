package com.tka.controller;

import java.util.List;

import com.tka.entity.Student;
import com.tka.service.StudentService;

public class StudentController {

    StudentService studentService = new StudentService();

    // 1. Display all students
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // 2. Add student
    public boolean insertStudents(Student s1) {
        return studentService.insertStudents(s1);
    }

    // 3. Display one student
    public Student getStudentByRollNo(int rollno) {
        return studentService.getStudentByRollNo(rollno);
    }

    // 4. Update student
    public boolean updateStudent(int rollno, String name, int marks) {
        return studentService.updateStudent(rollno, name, marks);
    }

    // 5. Delete student
    public boolean deleteStudent(int rollno) {
        return studentService.deleteStudent(rollno);
    }

    

    // 7. Find topper
    public Student findTopper() {
        return studentService.findTopper();
    }

    // 8. Find average marks
    public double findAverageMarks() {
        return studentService.findAverageMarks();
    }

    // 9. Search student by name
    public List<Student> searchStudentByName(String prefix) {
        return studentService.searchStudentByName(prefix);
    }
    
    public String login(String username, String password) {
        return studentService.login(username, password);
    }
}