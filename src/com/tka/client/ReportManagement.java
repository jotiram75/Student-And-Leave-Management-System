package com.tka.client;

import java.util.List;
import java.util.Scanner;

import com.tka.controller.StudentController;
import com.tka.entity.Student;

public class ReportManagement {

    public static void reportManagement(Scanner sc) {

        StudentController studentController = new StudentController();

        int choice;

        do {

            System.out.println();
            System.out.println("==========================================================");
            System.out.println("                  REPORT MANAGEMENT");
            System.out.println("==========================================================");
            System.out.println("1. View Topper");
            System.out.println("2. View Average Marks");
            System.out.println("3. View Student Count");
            System.out.println("4. View Merit List");
            System.out.println("0. Back");
            System.out.println("==========================================================");
            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch (choice) {

            case 1:

                Student topper = studentController.findTopper();

                if (topper != null) {

                    System.out.println("\n--------------- TOPPER DETAILS ----------------");
                    System.out.printf("%-15s : %d%n", "Roll Number", topper.getRollno());
                    System.out.printf("%-15s : %s%n", "Name", topper.getName());
                    System.out.printf("%-15s : %d%n", "Marks", topper.getMarks());
                    System.out.println("------------------------------------------------");

                } else {

                    System.out.println("No Student Record Found.");
                }

                break;

            case 2:

                double avg = studentController.findAverageMarks();

                System.out.println("\nAverage Marks : " + avg);

                break;

            case 3:

                List<Student> students = studentController.getAllStudents();

                System.out.println("\nTotal Students : " + students.size());

                break;

            case 4:

                List<Student> meritList = studentController.getAllStudents();

                meritList.sort((s1, s2) -> Integer.compare(s2.getMarks(), s1.getMarks()));

                System.out.println();
                System.out.println("==============================================================");
                System.out.printf("%-10s %-25s %-10s%n", "Roll No", "Name", "Marks");
                System.out.println("==============================================================");

                for (Student s : meritList) {

                    System.out.printf("%-10d %-25s %-10d%n",
                            s.getRollno(),
                            s.getName(),
                            s.getMarks());
                }

                System.out.println("==============================================================");

                break;

            case 0:

                System.out.println("Returning to Admin Dashboard...");
                break;

            default:

                System.out.println("Invalid Choice.");
            }

        } while (choice != 0);

    }

}