package com.tka.entity;

public class StudentLeave {

    private int lid;
    private String startdate;
    private String enddate;
    private String reason;
    private String status;
    private int sid;

    public StudentLeave() {
        super();
    }

    public StudentLeave(int lid, String startdate, String enddate,
                        String reason, String status, int sid) {
        super();
        this.lid = lid;
        this.startdate = startdate;
        this.enddate = enddate;
        this.reason = reason;
        this.status = status;
        this.sid = sid;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "StudentLeave [lid=" + lid + ", startdate=" + startdate
                + ", enddate=" + enddate + ", reason=" + reason
                + ", status=" + status + ", sid=" + sid + "]";
    }

}