package com.Gui;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Welcome")
public class WelcomePage extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String path = request.getContextPath();

        out.print("<html><head><title>Welcome</title>");

        out.print("<style>");
        out.print("body{font-family:Arial;background:#f2f2f2;text-align:center;padding:100px;}");
        out.print(".box{background:white;width:500px;margin:auto;padding:40px;border-radius:12px;box-shadow:0 0 10px gray;}");
        out.print("h1{color:blue;}");
        out.print("a{display:inline-block;background:blue;color:white;padding:12px 25px;text-decoration:none;border-radius:5px;margin:10px;}");
        out.print("</style>");

        out.print("</head><body>");

        out.print("<div class='box'>");

        out.print("<h1>Welcome to Student Management System</h1>");

        out.print("<p>Manage your student records easily.</p>");

        out.print("<a href='" + path + "/StudentForm'>Register Student</a>");

        out.print("<a href='" + path + "/Dashboard'>Dashboard</a>");

        out.print("</div>");

        out.print("</body></html>");
    }
}