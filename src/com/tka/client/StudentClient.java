package com.tka.client;

import java.util.Scanner;

import com.tka.controller.StudentController;

public class StudentClient {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StudentController studentController = new StudentController();

		System.out.println("==========================================================");
		System.out.println("        STUDENT & LEAVE MANAGEMENT SYSTEM (SLMS)");
		System.out.println("             Role Based Access Control (RBAC)");
		System.out.println("==========================================================");

		System.out.print("Username : ");
		String username = sc.nextLine();

		System.out.print("Password : ");
		String password = sc.nextLine();

		String role = studentController.login(username, password);

		if (role == null) {
			System.out.println("\nInvalid Username or Password.");
			sc.close();
			return;
		}

		System.out.println("\nLogin Successful.");
		System.out.println("Welcome " + username);
		System.out.println("Role : " + role);

		if (role.equalsIgnoreCase("ADMIN")) {

			AdminClient.adminDashboard(sc);

		} else if (role.equalsIgnoreCase("STUDENT")) {

			System.out.print("\nEnter Your Roll Number : ");
			int rollNo = sc.nextInt();

			StudentDashboard.studentDashboard(sc, rollNo);

		} else {

			System.out.println("Invalid Role.");

		}

		sc.close();

	}
}