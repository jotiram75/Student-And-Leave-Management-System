package com.tka.service;

import java.util.ArrayList;

import java.util.List;

import com.tka.dao.StudentDao;
import com.tka.entity.Student;

public class StudentService {
	StudentDao studentDao = new StudentDao();
	
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		students = studentDao.getAllStudents();
		return students;
	}
}
