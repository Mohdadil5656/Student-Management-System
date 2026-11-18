package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.DbConfig.DbConnectio;
import com.Model.Student;

public class StudentDao {

    public int saveStudentRecord(Student st) {

        int row = 0;

        String sql = "INSERT INTO student (sid, sname, semail, cid, dob, createdBy) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DbConnectio.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, st.getSid());
            ps.setString(2, st.getSname());
            ps.setString(3, st.getSemail());
            ps.setInt(4, st.getCid());
            ps.setDate(5, java.sql.Date.valueOf(st.getDob()));
            ps.setTimestamp(6, java.sql.Timestamp.valueOf(st.getCretedBy()));

            row = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row;
    }
}