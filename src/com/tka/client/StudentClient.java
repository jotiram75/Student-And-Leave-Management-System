package com.tka.client;

import java.util.List;
import com.tka.controller.StudentController;
import com.tka.entity.Student;

public class StudentClient {
	public static void main(String[] args) {
		
		StudentController studentController = new StudentController();
		
		System.out.println("Fetching all students from the database:");
		List<Student> students = studentController.getAllStudents();
		
		for (Student student : students) {
			System.out.println("Roll No: " + student.getRollno() + ", Name: " + student.getName() + ", Marks: "
					+ student.getMarks());
		}
		
		
		
	}

}
