package com.Gui;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String path = request.getContextPath();

        String name = request.getParameter("name");

        if (name == null || name.isEmpty()) {
            name = "Adil";
        }

        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Student Dashboard</title>");

        out.print("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");

        out.print("<style>");

        out.print("*{box-sizing:border-box;}");

        out.print("body{font-family:Arial;background:#f0f2f5;margin:0;}");

        out.print(".header{background:linear-gradient(135deg,#141e30,#243b55);color:white;padding:22px 35px;display:flex;justify-content:space-between;align-items:center;flex-wrap:wrap;}");

        out.print(".header h2{margin:0;}");

        out.print(".logout{background:#e74c3c;color:white;padding:12px 25px;text-decoration:none;border-radius:6px;font-weight:bold;display:inline-block;font-size:16px;}");

        out.print(".logout:hover{background:#c0392b;}");

        out.print(".container{padding:35px;}");

        out.print(".welcome{background:white;padding:25px;border-radius:12px;box-shadow:0 3px 12px #ddd;}");

        out.print(".welcome h1{color:#243b55;margin-top:0;}");

        out.print(".cards{display:flex;gap:25px;flex-wrap:wrap;margin-top:30px;}");

        out.print(".card{background:white;flex:1 1 220px;max-width:280px;padding:30px 20px;text-align:center;border-radius:12px;box-shadow:0 3px 12px #ddd;transition:0.3s;}");

        out.print(".card:hover{transform:translateY(-7px);}");

        out.print(".card h3{color:#243b55;font-size:21px;}");

        out.print(".card p{color:#777;min-height:40px;}");

        out.print(".btn{color:white;padding:11px 22px;text-decoration:none;border-radius:6px;display:inline-block;font-weight:bold;}");

        out.print(".add{background:#27ae60;}");

        out.print(".view{background:#2980b9;}");

        out.print(".search{background:#8e44ad;}");

        out.print(".footer{text-align:center;padding:20px;color:#777;margin-top:30px;}");

        out.print("</style>");

        out.print("</head>");

        out.print("<body>");

        out.print("<div class='header'>");

        out.print("<h2>Student Management System</h2>");

        // Logout Button
        out.print("<a class='logout' href='" + path + "/Logout'>Logout</a>");

        out.print("</div>");

        out.print("<div class='container'>");

        out.print("<div class='welcome'>");

        out.print("<h1>Welcome " + name + "!</h1>");

        out.print("<p>Manage all student information from one place.</p>");

        out.print("</div>");

        out.print("<div class='cards'>");

        out.print("<div class='card'>");
        out.print("<h3>Add New Student</h3>");
        out.print("<p>Register a new student in the system.</p>");
        out.print("<a class='btn add' href='" + path + "/StudentForm'>Add Student</a>");
        out.print("</div>");

        out.print("<div class='card'>");
        out.print("<h3>View Students</h3>");
        out.print("<p>View all registered student records.</p>");
        out.print("<a class='btn view' href='" + path + "/StudentList'>View Students</a>");
        out.print("</div>");

        out.print("<div class='card'>");
        out.print("<h3>Search Student</h3>");
        out.print("<p>Find student records by ID or Name.</p>");
        out.print("<a class='btn search' href='" + path + "/StudentList'>Search Student</a>");
        out.print("</div>");

        out.print("</div>");

        out.print("</div>");

        out.print("<div class='footer'>");

        out.print("<p>Student Management System | Developed using Java Servlet, JDBC & MySQL</p>");

        out.print("</div>");

        out.print("</body>");

        out.print("</html>");
    }
}