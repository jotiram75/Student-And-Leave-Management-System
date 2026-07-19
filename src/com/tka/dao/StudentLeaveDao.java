package com.tka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tka.entity.StudentLeave;
import com.tka.utility.DBUtility;

public class StudentLeaveDao {

    private Connection con = null;
    private Statement stmt = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    private String getAllLeavesQuery = "SELECT * FROM student_leave";

    private String applyLeaveQuery =
            "INSERT INTO student_leave(startdate,enddate,reason,status,sid) VALUES(?,?,?,?,?)";

    private String getLeaveByStudentQuery =
            "SELECT * FROM student_leave WHERE sid=?";

    private String approveLeaveQuery =
            "UPDATE student_leave SET status='APPROVED' WHERE lid=?";

    private String rejectLeaveQuery =
            "UPDATE student_leave SET status='REJECTED' WHERE lid=?";

    private String deleteLeaveQuery =
            "DELETE FROM student_leave WHERE lid=? AND sid=?";
    private String deleteLeaveAdminQuery =
            "DELETE FROM student_leave WHERE lid=?";

    // ==========================================================
    // View All Leave Requests
    // ==========================================================

    public List<StudentLeave> getAllStudentLeave() {

        List<StudentLeave> leaves = new ArrayList<>();

        try {

            con = DBUtility.getConnection();

            stmt = con.createStatement();

            rs = stmt.executeQuery(getAllLeavesQuery);

            while (rs.next()) {

                StudentLeave leave = new StudentLeave();

                leave.setLid(rs.getInt("lid"));
                leave.setStartdate(rs.getString("startdate"));
                leave.setEnddate(rs.getString("enddate"));
                leave.setReason(rs.getString("reason"));
                leave.setStatus(rs.getString("status"));
                leave.setSid(rs.getInt("sid"));

                leaves.add(leave);
            }

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

        } finally {

            closeResources();
        }

        return leaves;
    }

    // ==========================================================
    // Apply Leave
    // ==========================================================

    public boolean applyLeave(StudentLeave leave) {

        try {

            con = DBUtility.getConnection();

            pst = con.prepareStatement(applyLeaveQuery);

            pst.setString(1, leave.getStartdate());
            pst.setString(2, leave.getEnddate());
            pst.setString(3, leave.getReason());
            pst.setString(4, "PENDING");
            pst.setInt(5, leave.getSid());

            return pst.executeUpdate() > 0;

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

        } finally {

            closeResources();
        }

        return false;
    }

    // ==========================================================
    // View Leave By Student Id
    // ==========================================================

    public List<StudentLeave> getLeaveByStudentId(int sid) {

        List<StudentLeave> leaves = new ArrayList<>();

        try {

            con = DBUtility.getConnection();

            pst = con.prepareStatement(getLeaveByStudentQuery);

            pst.setInt(1, sid);

            rs = pst.executeQuery();

            while (rs.next()) {

                StudentLeave leave = new StudentLeave();

                leave.setLid(rs.getInt("lid"));
                leave.setStartdate(rs.getString("startdate"));
                leave.setEnddate(rs.getString("enddate"));
                leave.setReason(rs.getString("reason"));
                leave.setStatus(rs.getString("status"));
                leave.setSid(rs.getInt("sid"));

                leaves.add(leave);
            }

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

        } finally {

            closeResources();
        }

        return leaves;
    }

    // ==========================================================
    // Approve Leave
    // ==========================================================

    public boolean approveLeave(int leaveId) {

        try {

            con = DBUtility.getConnection();

            pst = con.prepareStatement(approveLeaveQuery);

            pst.setInt(1, leaveId);

            return pst.executeUpdate() > 0;

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

        } finally {

            closeResources();
        }

        return false;
    }

    // ==========================================================
    // Reject Leave
    // ==========================================================

    public boolean rejectLeave(int leaveId) {

        try {

            con = DBUtility.getConnection();

            pst = con.prepareStatement(rejectLeaveQuery);

            pst.setInt(1, leaveId);

            return pst.executeUpdate() > 0;

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

        } finally {

            closeResources();
        }

        return false;
    }

    // ==========================================================
    // Delete Leave
    // ==========================================================

    public boolean deleteLeave(int leaveId, int sid) {

        try {

            con = DBUtility.getConnection();

            pst = con.prepareStatement(deleteLeaveQuery);

            pst.setInt(1, leaveId);
            pst.setInt(2, sid);

            return pst.executeUpdate() > 0;
            
            

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // ==========================================================
    // Close Resources
    // ==========================================================

    private void closeResources() {

        try {

            if (rs != null)
                rs.close();

            if (pst != null)
                pst.close();

            if (stmt != null)
                stmt.close();

            if (con != null)
                con.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    
 // ==========================================================
    // Delete Leave
    // ==========================================================

 // ==========================================================
    // Delete Leave
    // ==========================================================

   

	public boolean deleteLeave(int leaveId) {
		  try {

		        con = DBUtility.getConnection();

		        pst = con.prepareStatement(deleteLeaveAdminQuery);

		        pst.setInt(1, leaveId);

		        return pst.executeUpdate() > 0;

		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        closeResources();
		    }

		    return false;
		
		
	}
    
}
