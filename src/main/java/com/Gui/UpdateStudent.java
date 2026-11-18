package com.Gui;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.DbConfig.DbConnectio;

@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        
        String sid = request.getParameter("sid");
        String sname = request.getParameter("sname");
        String semail = request.getParameter("semail");
        String cid = request.getParameter("cid");
        String dob = request.getParameter("dob");

        String sql = "UPDATE student SET sname=?, semail=?, cid=?, dob=? WHERE sid=?";

        try (Connection con = DbConnectio.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, sname);
            ps.setString(2, semail);
            ps.setInt(3, Integer.parseInt(cid));
            ps.setDate(4, java.sql.Date.valueOf(dob));
            ps.setString(5, sid);

            int result = ps.executeUpdate();

            if (result > 0) {
                response.sendRedirect(request.getContextPath() + "/StudentList");
            } else {
                response.getWriter().print("Student Not Updated");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print("Error: " + e.getMessage());
        }
    }
}