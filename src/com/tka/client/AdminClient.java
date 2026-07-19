package com.tka.client;

import java.util.Scanner;

public class AdminClient {

    public static void adminDashboard(Scanner sc) {

        int choice;

        do {

            System.out.println();
            System.out.println("==========================================================");
            System.out.println("                   ADMIN DASHBOARD");
            System.out.println("==========================================================");
            System.out.println("1. Student Management");
            System.out.println("2. Leave Management");
            System.out.println("3. Reports");
            System.out.println("0. Logout");
            System.out.println("==========================================================");
            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch (choice) {

            case 1:

                StudentManagement.studentManagement(sc);
                break;

            case 2:

                LeaveManagement.leaveManagement(sc);
                break;

            case 3:

                ReportManagement.reportManagement(sc);
                break;

            case 0:

                System.out.println("\nAdmin Logged Out Successfully.");
                break;

            default:

                System.out.println("\nInvalid Choice.");
            }

        } while (choice != 0);
    }
}