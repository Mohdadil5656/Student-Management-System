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

@WebServlet("/SearchStudent")
public class SearchStudent extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String path = request.getContextPath();

        String keyword = request.getParameter("keyword");

        if (keyword == null || keyword.trim().isEmpty()) {

            response.sendRedirect(path + "/StudentList");
            return;
        }

        keyword = keyword.trim();

        String sql = "SELECT sid, sname, semail, cid, dob FROM student "
                + "WHERE CAST(sid AS CHAR) LIKE ? OR sname LIKE ?";

        out.print("<html><head><title>Search Student</title>");

        out.print("<style>");

        out.print("body{font-family:Arial;background:#f2f2f2;margin:0;padding:30px;}");
        out.print(".container{background:white;padding:25px;border-radius:10px;}");
        out.print("h2{text-align:center;color:blue;}");
        out.print("table{width:100%;border-collapse:collapse;margin-top:25px;}");
        out.print("th,td{border:1px solid #ddd;padding:12px;text-align:center;}");
        out.print("th{background:blue;color:white;}");
        out.print("tr:nth-child(even){background:#f2f2f2;}");
        out.print(".btn{background:blue;color:white;padding:10px 20px;text-decoration:none;border-radius:5px;}");
        out.print(".edit{background:green;color:white;padding:7px 12px;text-decoration:none;border-radius:5px;}");
        out.print(".delete{background:red;color:white;padding:7px 12px;text-decoration:none;border-radius:5px;}");

        out.print("</style></head><body>");

        out.print("<div class='container'>");

        out.print("<h2>Search Student Result</h2>");

        out.print("<a class='btn' href='" + path
                + "/StudentList'>Back to Student List</a>");

        out.print("<table>");

        out.print("<tr>");

        out.print("<th>Student ID</th>");
        out.print("<th>Student Name</th>");
        out.print("<th>Email</th>");
        out.print("<th>Course ID</th>");
        out.print("<th>Date of Birth</th>");
        out.print("<th>Action</th>");

        out.print("</tr>");

        int count = 0;

        try (Connection con = DbConnectio.getConnection();

             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    count++;

                    String sid = rs.getString("sid");

                    out.print("<tr>");

                    out.print("<td>" + sid + "</td>");
                    out.print("<td>" + rs.getString("sname") + "</td>");
                    out.print("<td>" + rs.getString("semail") + "</td>");
                    out.print("<td>" + rs.getInt("cid") + "</td>");
                    out.print("<td>" + rs.getDate("dob") + "</td>");

                    out.print("<td>");

                    out.print("<a class='edit' href='" + path
                            + "/EditStudent?sid=" + sid + "'>Edit</a>");

                    out.print(" ");

                    out.print("<a class='delete' href='" + path
                            + "/DeleteStudent?sid=" + sid
                            + "' onclick=\"return confirm('Are you sure you want to delete this student?')\">Delete</a>");

                    out.print("</td>");

                    out.print("</tr>");
                }

                if (count == 0) {

                    out.print("<tr><td colspan='6'>No Student Found</td></tr>");
                }
            }

        } catch (Exception e) {

            e.printStackTrace();

            out.print("<tr><td colspan='6'>Error: "
                    + e.getMessage() + "</td></tr>");
        }

        out.print("</table>");

        out.print("<h3>Total Students Found: " + count + "</h3>");

        out.print("</div></body></html>");
    }
}