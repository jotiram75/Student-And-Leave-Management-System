package com.tka.service;

import java.util.List;

import com.tka.dao.StudentLeaveDao;
import com.tka.entity.StudentLeave;

public class StudentLeaveService {

    private StudentLeaveDao studentLeaveDao = new StudentLeaveDao();

    // 1. View All Leave Requests
    public List<StudentLeave> getAllStudentLeave() {
        return studentLeaveDao.getAllStudentLeave();
    }

    // 2. Apply Leave
    public boolean applyLeave(StudentLeave leave) {

        if (leave == null)
            return false;

        if (leave.getSid() <= 0)
            return false;

        if (leave.getReason() == null || leave.getReason().trim().isEmpty())
            return false;

        if (leave.getStartdate() == null || leave.getEnddate() == null)
            return false;

        return studentLeaveDao.applyLeave(leave);
    }

    // 3. View Leave By Student Id
    public List<StudentLeave> getLeaveByStudentId(int sid) {

        if (sid <= 0)
            return null;

        return studentLeaveDao.getLeaveByStudentId(sid);
    }

    // 4. Approve Leave
    public boolean approveLeave(int leaveId) {

        if (leaveId <= 0)
            return false;

        return studentLeaveDao.approveLeave(leaveId);
    }

    // 5. Reject Leave
    public boolean rejectLeave(int leaveId) {

        if (leaveId <= 0)
            return false;

        return studentLeaveDao.rejectLeave(leaveId);
    }

    // 6. Student - Cancel Own Leave
    public boolean deleteLeave(int leaveId, int sid) {

        if (leaveId <= 0 || sid <= 0)
            return false;

        return studentLeaveDao.deleteLeave(leaveId, sid);
    }

    // 7. Admin - Delete Any Leave
    public boolean deleteLeave(int leaveId) {

        if (leaveId <= 0)
            return false;

        return studentLeaveDao.deleteLeave(leaveId);
    }
}