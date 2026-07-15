package com.tka.client;

import java.util.List;
import java.util.Scanner;

import com.tka.controller.StudentController;
import com.tka.entity.Student;

public class StudentClient {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentController studentController = new StudentController();

        System.out.println("==========================================");
        System.out.println(" STUDENT & LEAVE MANAGEMENT SYSTEM (SLMS)");
        System.out.println("==========================================");

        System.out.print("Enter Username : ");
        String username = sc.nextLine();

        System.out.print("Enter Password : ");
        String password = sc.nextLine();

        String role = studentController.login(username, password);

        if (role == null) {
            System.out.println("Invalid Username or Password.");
            sc.close();
            return;
        }

        System.out.println("\nLogin Successful!");
        System.out.println("Logged in as : " + role);

        if (role.equalsIgnoreCase("ADMIN")) {

            adminMenu(sc, studentController);

        } else if (role.equalsIgnoreCase("STUDENT")) {

            System.out.print("Enter Your Roll Number : ");
            int rollNo = sc.nextInt();

            studentMenu(sc, studentController, rollNo);

        } else {

            System.out.println("Invalid Role.");
        }

        sc.close();
    }

    // ================= ADMIN MENU =================

    public static void adminMenu(Scanner sc, StudentController studentController) {

        int choice;

        do {

            System.out.println("\n========= ADMIN MENU =========");
            System.out.println("1. Display All Students");
            System.out.println("2. Add Student");
            System.out.println("3. Display One Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Find Topper");
            System.out.println("7. Average Marks");
            System.out.println("8. Search Student");
            System.out.println("0. Logout");

            System.out.print("Enter Choice : ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:

                List<Student> students = studentController.getAllStudents();

                for (Student s : students) {
                    System.out.println(s.getRollno() + "  " + s.getName() + "  " + s.getMarks());
                }

                break;

            case 2:

                Student s = new Student();

                System.out.print("Roll No : ");
                s.setRollno(sc.nextInt());

                sc.nextLine();

                System.out.print("Name : ");
                s.setName(sc.nextLine());

                System.out.print("Marks : ");
                s.setMarks(sc.nextInt());

                if (studentController.insertStudents(s))
                    System.out.println("Student Added Successfully.");
                else
                    System.out.println("Insertion Failed.");

                break;

            case 3:

                System.out.print("Enter Roll No : ");
                int roll = sc.nextInt();

                Student st = studentController.getStudentByRollNo(roll);

                if (st != null)
                    System.out.println(st.getRollno() + "  " + st.getName() + "  " + st.getMarks());
                else
                    System.out.println("Student Not Found.");

                break;

            case 4:

                System.out.print("Enter Roll No : ");
                int r = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter New Name : ");
                String name = sc.nextLine();

                System.out.print("Enter New Marks : ");
                int marks = sc.nextInt();

                if (studentController.updateStudent(r, name, marks))
                    System.out.println("Student Updated Successfully.");
                else
                    System.out.println("Update Failed.");

                break;

            case 5:

                System.out.print("Enter Roll No : ");
                int deleteRoll = sc.nextInt();

                if (studentController.deleteStudent(deleteRoll))
                    System.out.println("Student Deleted Successfully.");
                else
                    System.out.println("Deletion Failed.");

                break;

            case 6:

                Student topper = studentController.findTopper();

                if (topper != null) {
                    System.out.println("\nTopper Details");
                    System.out.println(topper.getRollno() + "  " + topper.getName() + "  " + topper.getMarks());
                }

                break;

            case 7:

                System.out.println("Average Marks = " + studentController.findAverageMarks());

                break;

            case 8:

                sc.nextLine();

                System.out.print("Enter Student Name : ");
                String prefix = sc.nextLine();

                List<Student> list = studentController.searchStudentByName(prefix);

                if (list.isEmpty()) {
                    System.out.println("No Student Found.");
                } else {

                    for (Student stu : list) {
                        System.out.println(stu.getRollno() + "  " + stu.getName() + "  " + stu.getMarks());
                    }

                }

                break;

            case 0:

                System.out.println("Admin Logged Out.");
                break;

            default:

                System.out.println("Invalid Choice.");
            }

        } while (choice != 0);

    }

    // ================= STUDENT MENU =================

    public static void studentMenu(Scanner sc, StudentController studentController, int rollNo) {

        int choice;

        do {

            System.out.println("\n========= STUDENT MENU =========");
            System.out.println("1. View My Details");
            System.out.println("2. Apply Leave");
            System.out.println("3. View Topper");
            System.out.println("0. Logout");

            System.out.print("Enter Choice : ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:

                Student student = studentController.getStudentByRollNo(rollNo);

                if (student != null)
                    System.out.println(student.getRollno() + "  " + student.getName() + "  " + student.getMarks());
                else
                    System.out.println("Student Not Found.");

                break;

            case 2:

                if (studentController.applyLeave(rollNo))
                    System.out.println("Leave Applied Successfully.");
                else
                    System.out.println("Leave Application Failed.");

                break;

            case 3:

                Student topper = studentController.findTopper();

                if (topper != null) {
                    System.out.println("Topper:");
                    System.out.println(topper.getRollno() + "  " + topper.getName() + "  " + topper.getMarks());
                }

                break;

            case 0:

                System.out.println("Student Logged Out.");
                break;

            default:

                System.out.println("Invalid Choice.");
            }

        } while (choice != 0);

    }
}