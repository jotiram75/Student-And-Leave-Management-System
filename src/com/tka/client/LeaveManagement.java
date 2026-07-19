package com.tka.client;

import java.util.List;
import java.util.Scanner;

import com.tka.controller.StudentLeaveController;
import com.tka.entity.StudentLeave;

public class LeaveManagement {

    static StudentLeaveController leaveController = new StudentLeaveController();

    // ================= ADMIN LEAVE MANAGEMENT =================

    public static void leaveManagement(Scanner sc) {

        int choice;

        do {

            System.out.println();
            System.out.println("==========================================================");
            System.out.println("                  LEAVE MANAGEMENT");
            System.out.println("==========================================================");
            System.out.println("1. View All Leave Requests");
            System.out.println("2. View Leave By Student ID");
            System.out.println("3. Approve Leave");
            System.out.println("4. Reject Leave");
            System.out.println("5. Delete Leave Request");
            System.out.println("0. Back");
            System.out.println("==========================================================");
            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch (choice) {

            case 1:

                List<StudentLeave> leaves = leaveController.getAllStudentLeave();

                if (leaves.isEmpty()) {

                    System.out.println("\nNo Leave Records Found.");

                } else {

                    System.out.println(
                            "--------------------------------------------------------------------------------------------");
                    System.out.printf("%-8s %-15s %-15s %-30s %-10s%n",
                            "LeaveId", "Start Date", "End Date", "Reason", "Student");
                    System.out.println(
                            "--------------------------------------------------------------------------------------------");

                    for (StudentLeave leave : leaves) {

                    	System.out.printf("%-8d %-15s %-15s %-25s %-12s %-10d%n",
                    	        leave.getLid(),
                    	        leave.getStartdate(),
                    	        leave.getEnddate(),
                    	        leave.getReason(),
                    	        leave.getStatus(),
                    	        leave.getSid());
                    }

                    System.out.println(
                            "--------------------------------------------------------------------------------------------");
                }

                break;

            case 2:

            	System.out.print("Enter Student ID : ");
            	int sid = sc.nextInt();

            	List<StudentLeave> studentLeaves = leaveController.getLeaveByStudentId(sid);

            	if (studentLeaves == null || studentLeaves.isEmpty()) {

            	    System.out.println("\nNo Leave Records Found.");

            	} else {

            	    System.out.println("---------------------------------------------------------------------------------------------------");
            	    System.out.printf("%-8s %-15s %-15s %-25s %-12s%n",
            	            "LeaveId", "Start Date", "End Date", "Reason", "Status");
            	    System.out.println("---------------------------------------------------------------------------------------------------");

            	    for (StudentLeave leave : studentLeaves) {

            	        System.out.printf("%-8d %-15s %-15s %-25s %-12s%n",
            	                leave.getLid(),
            	                leave.getStartdate(),
            	                leave.getEnddate(),
            	                leave.getReason(),
            	                leave.getStatus());
            	    }

            	    System.out.println("---------------------------------------------------------------------------------------------------");
				}

				break;

            case 3:

            	System.out.print("Enter Leave ID : ");
            	int approveId = sc.nextInt();

            	boolean approved = leaveController.approveLeave(approveId);

            	if (approved) {
            	    System.out.println("\nLeave Approved Successfully.");
            	} else {
            	    System.out.println("\nLeave ID Not Found.");
            	}
                break;

            case 4:

            	System.out.print("Enter Leave ID : ");
            	int rejectId = sc.nextInt();

            	boolean rejected = leaveController.rejectLeave(rejectId);

            	if (rejected) {
            	    System.out.println("\nLeave Rejected Successfully.");
            	} else {
            	    System.out.println("\nLeave ID Not Found.");
            	}
                break;

            case 5:

            	System.out.print("Enter Leave ID : ");
            	int deleteId = sc.nextInt();

            	boolean deleted = leaveController.deleteLeave(deleteId);

            	if (deleted) {
            	    System.out.println("\nLeave Deleted Successfully.");
            	} else {
            	    System.out.println("\nLeave ID Not Found.");
            	}
                break;

            case 0:

                System.out.println("Returning to Admin Dashboard...");
                break;

            default:

                System.out.println("Invalid Choice.");
            }

        } while (choice != 0);

    }

    // ================= STUDENT LEAVE MANAGEMENT =================

    public static void studentLeaveManagement(Scanner sc, int rollNo) {

        int choice;

        do {

            System.out.println();
            System.out.println("==========================================================");
            System.out.println("               STUDENT LEAVE MANAGEMENT");
            System.out.println("==========================================================");
            System.out.println("1. Apply Leave");
            System.out.println("2. View My Leave Requests");
            System.out.println("3. Cancel Leave Request");
            System.out.println("0. Back");
            System.out.println("==========================================================");
            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch (choice) {

            case 1:

                sc.nextLine();

                System.out.print("Enter Start Date (yyyy-mm-dd): ");
                String startDate = sc.nextLine();

                System.out.print("Enter End Date (yyyy-mm-dd): ");
                String endDate = sc.nextLine();

                System.out.print("Enter Reason : ");
                String reason = sc.nextLine();

                StudentLeave leave = new StudentLeave();

                leave.setStartdate(startDate);
                leave.setEnddate(endDate);
                leave.setReason(reason);
                leave.setSid(rollNo);

                boolean ack = leaveController.applyLeave(leave);

                if (ack) {
                    System.out.println("\nLeave Applied Successfully.");
                } else {
                    System.out.println("\nFailed to Apply Leave.");
                }

                break;

            case 2:

                List<StudentLeave> myLeaves = leaveController.getLeaveByStudentId(rollNo);

                if (myLeaves == null || myLeaves.isEmpty()) {

                    System.out.println("\nNo Leave Records Found.");

                } else {

                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.printf("%-8s %-15s %-15s %-25s%n",
                            "LeaveId", "Start Date", "End Date", "Reason");
                    System.out.println("-------------------------------------------------------------------------------");

                    for (StudentLeave leave1 : myLeaves) {

                        System.out.printf("%-8d %-15s %-15s %-25s%n",
                                leave1.getLid(),
                                leave1.getStartdate(),
                                leave1.getEnddate(),
                                leave1.getReason());
                    }

                    System.out.println("-------------------------------------------------------------------------------");
                }

                
                break;

            case 3:

                System.out.print("Enter Leave ID : ");
                int leaveId = sc.nextInt();

                boolean deleted = leaveController.deleteLeave(leaveId, rollNo);

                if (deleted) {
                    System.out.println("\nLeave Request Cancelled Successfully.");
                } else {
                    System.out.println("\nLeave Request Not Found.");
                }

                break;

            case 0:

                System.out.println("Returning to Student Dashboard...");
                break;

            default:

                System.out.println("Invalid Choice.");
            }

        } while (choice != 0);

    }

}