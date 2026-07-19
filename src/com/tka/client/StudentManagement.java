package com.tka.client;

import java.util.List;
import java.util.Scanner;

import com.tka.controller.StudentController;
import com.tka.entity.Student;

public class StudentManagement {

    public static void studentManagement(Scanner sc) {

        StudentController studentController = new StudentController();

        int choice;

        do {

            System.out.println();
            System.out.println("==========================================================");
            System.out.println("                STUDENT MANAGEMENT");
            System.out.println("==========================================================");
            System.out.println("1. Display All Students");
            System.out.println("2. Add Student");
            System.out.println("3. View Student By Roll Number");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Search Student");
            System.out.println("0. Back");
            System.out.println("==========================================================");
            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch (choice) {

            case 1:

                List<Student> students = studentController.getAllStudents();

                if (students.isEmpty()) {
                    System.out.println("No Student Records Found.");
                    break;
                }

                System.out.println("----------------------------------------------------------");
                System.out.printf("%-10s %-25s %-10s%n",
                        "Roll No", "Name", "Marks");
                System.out.println("----------------------------------------------------------");

                for (Student s : students) {

                    System.out.printf("%-10d %-25s %-10d%n",
                            s.getRollno(),
                            s.getName(),
                            s.getMarks());
                }

                System.out.println("----------------------------------------------------------");

                break;

            case 2:

                Student student = new Student();

                System.out.print("Enter Roll Number : ");
                student.setRollno(sc.nextInt());

                sc.nextLine();

                System.out.print("Enter Name : ");
                student.setName(sc.nextLine());

                System.out.print("Enter Marks : ");
                student.setMarks(sc.nextInt());

                if (studentController.insertStudents(student))
                    System.out.println("Student Added Successfully.");
                else
                    System.out.println("Failed To Add Student.");

                break;

            case 3:

                System.out.print("Enter Roll Number : ");
                int rollNo = sc.nextInt();

                Student st = studentController.getStudentByRollNo(rollNo);

                if (st != null) {

                    System.out.println();
                    System.out.println("--------------- STUDENT DETAILS ----------------");
                    System.out.printf("%-15s : %d%n", "Roll Number", st.getRollno());
                    System.out.printf("%-15s : %s%n", "Name", st.getName());
                    System.out.printf("%-15s : %d%n", "Marks", st.getMarks());
                    System.out.println("-----------------------------------------------");

                } else {

                    System.out.println("Student Not Found.");
                }

                break;

            case 4:

                System.out.print("Enter Roll Number : ");
                int updateRoll = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter New Name : ");
                String name = sc.nextLine();

                System.out.print("Enter New Marks : ");
                int marks = sc.nextInt();

                if (studentController.updateStudent(updateRoll, name, marks))
                    System.out.println("Student Updated Successfully.");
                else
                    System.out.println("Update Failed.");

                break;

            case 5:

                System.out.print("Enter Roll Number : ");
                int deleteRoll = sc.nextInt();

                if (studentController.deleteStudent(deleteRoll))
                    System.out.println("Student Deleted Successfully.");
                else
                    System.out.println("Deletion Failed.");

                break;

            case 6:

                sc.nextLine();

                System.out.print("Enter Student Name : ");
                String prefix = sc.nextLine();

                List<Student> result = studentController.searchStudentByName(prefix);

                if (result == null || result.isEmpty()) {

                    System.out.println("No Student Found.");

                } else {

                    System.out.println("----------------------------------------------------------");
                    System.out.printf("%-10s %-25s %-10s%n",
                            "Roll No", "Name", "Marks");
                    System.out.println("----------------------------------------------------------");

                    for (Student s : result) {

                        System.out.printf("%-10d %-25s %-10d%n",
                                s.getRollno(),
                                s.getName(),
                                s.getMarks());
                    }

                    System.out.println("----------------------------------------------------------");
                }

                break;

            case 0:

                System.out.println("Returning To Admin Dashboard...");
                break;

            default:

                System.out.println("Invalid Choice.");
            }

        } while (choice != 0);

    }

}