package com.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Student {

    private LocalDateTime cretedBy;
    private String sid;
    private String sname;
    private String semail;
    private int cid;
    private LocalDate dob;

    public Student() {
        super();
    }

    public Student(LocalDateTime cretedBy, String sid, String sname,
            String semail, int cid, LocalDate dob) {

        super();

        this.cretedBy = cretedBy;
        this.sid = sid;
        this.sname = sname;
        this.semail = semail;
        this.cid = cid;
        this.dob = dob;
    }

    public LocalDateTime getCretedBy() {
        return cretedBy;
    }

    public void setCretedBy(LocalDateTime cretedBy) {
        this.cretedBy = cretedBy;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {

        return "Student [cretedBy=" + cretedBy
                + ", sid=" + sid
                + ", sname=" + sname
                + ", semail=" + semail
                + ", cid=" + cid
                + ", dob=" + dob + "]";
    }
}