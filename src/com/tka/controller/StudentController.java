package com.tka.controller;

import java.util.ArrayList;

import java.util.List;
import com.tka.entity.Student;
import com.tka.service.StudentService;

public class StudentController {
	StudentService studentService = new StudentService();
	
	public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        students = studentService.getAllStudents();
        return students;
    }
}
	

