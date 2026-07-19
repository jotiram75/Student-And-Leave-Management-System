package com.tka.client;

import java.util.Scanner;

import com.tka.controller.StudentController;
import com.tka.entity.Student;

public class StudentDashboard {

    public static void studentDashboard(Scanner sc, int rollNo) {

        StudentController studentController = new StudentController();

        int choice;

        do {

            System.out.println();
            System.out.println("==========================================================");
            System.out.println("                  STUDENT DASHBOARD");
            System.out.println("==========================================================");
            System.out.println("1. My Profile");
            System.out.println("2. Leave Management");
            System.out.println("3. View Topper");
            System.out.println("0. Logout");
            System.out.println("==========================================================");
            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch (choice) {

            case 1:

                Student student = studentController.getStudentByRollNo(rollNo);

                if (student != null) {

                    System.out.println();
                    System.out.println("--------------- MY PROFILE ----------------");
                    System.out.printf("%-15s : %d%n", "Roll Number", student.getRollno());
                    System.out.printf("%-15s : %s%n", "Name", student.getName());
                    System.out.printf("%-15s : %d%n", "Marks", student.getMarks());
                    System.out.println("-------------------------------------------");

                } else {

                    System.out.println("Student Not Found.");

                }

                break;

            case 2:

                LeaveManagement.studentLeaveManagement(sc, rollNo);
                break;

            case 3:

                Student topper = studentController.findTopper();

                if (topper != null) {

                    System.out.println();
                    System.out.println("--------------- TOPPER DETAILS ----------------");
                    System.out.printf("%-15s : %d%n", "Roll Number", topper.getRollno());
                    System.out.printf("%-15s : %s%n", "Name", topper.getName());
                    System.out.printf("%-15s : %d%n", "Marks", topper.getMarks());
                    System.out.println("-----------------------------------------------");

                }

                break;

            case 0:

                System.out.println("\nStudent Logged Out Successfully.");
                break;

            default:

                System.out.println("Invalid Choice.");
            }

        } while (choice != 0);
    }
}