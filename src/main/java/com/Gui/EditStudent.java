package com.Gui;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.DbConfig.DbConnectio;

@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String sid = request.getParameter("sid");

        String sql = "SELECT * FROM student WHERE sid = ?";

        try (Connection con = DbConnectio.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, sid);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    out.print("<html><head><title>Edit Student</title></head><body>");

                    out.print("<h2>Update Student Details</h2>");

                    out.print("<form action='UpdateStudent' method='post'>");

                    out.print("<input type='hidden' name='sid' value='" 
                            + rs.getString("sid") + "'>");

                    out.print("Student Name: <input type='text' name='sname' value='"
                            + rs.getString("sname") + "' required><br><br>");

                    out.print("Email: <input type='email' name='semail' value='"
                            + rs.getString("semail") + "' required><br><br>");

                    out.print("Course ID: <input type='number' name='cid' value='"
                            + rs.getInt("cid") + "' required><br><br>");

                    out.print("Date of Birth: <input type='date' name='dob' value='"
                            + rs.getDate("dob") + "' required><br><br>");

                    out.print("<button type='submit'>Update Student</button>");

                    out.print("</form>");

                    out.print("</body></html>");

                } else {
                    out.print("Student Not Found");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.print("Error: " + e.getMessage());
        }
    }
}