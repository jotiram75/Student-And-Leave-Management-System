package com.tka.controller;

import java.util.List;

import com.tka.entity.StudentLeave;
import com.tka.service.StudentLeaveService;

public class StudentLeaveController {

    private StudentLeaveService studentLeaveService = new StudentLeaveService();

    // View All Leave Requests
    public List<StudentLeave> getAllStudentLeave() {
        return studentLeaveService.getAllStudentLeave();
    }

    // Apply Leave
    public boolean applyLeave(StudentLeave leave) {
        return studentLeaveService.applyLeave(leave);
    }

    // View Leave By Student ID
    public List<StudentLeave> getLeaveByStudentId(int sid) {
        return studentLeaveService.getLeaveByStudentId(sid);
    }

    // Approve Leave
    public boolean approveLeave(int leaveId) {
        return studentLeaveService.approveLeave(leaveId);
    }

    // Reject Leave
    public boolean rejectLeave(int leaveId) {
        return studentLeaveService.rejectLeave(leaveId);
    }

    // Student - Cancel own leave
    public boolean deleteLeave(int leaveId, int sid) {
        return studentLeaveService.deleteLeave(leaveId, sid);
    }

    // Admin - Delete any leave request
    public boolean deleteLeave(int leaveId) {
        return studentLeaveService.deleteLeave(leaveId);
    }
}