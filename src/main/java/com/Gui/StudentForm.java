package com.Gui;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/StudentForm")
public class StudentForm extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String form = "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<title>Student Registration</title>"

                + "<style>"

                + "body {"
                + "font-family: Arial;"
                + "background-color: #f2f2f2;"
                + "}"

                + ".container {"
                + "width: 400px;"
                + "margin: 40px auto;"
                + "padding: 20px;"
                + "background: white;"
                + "border-radius: 8px;"
                + "box-shadow: 0 0 10px gray;"
                + "}"

                + "h2 {"
                + "text-align: center;"
                + "color: blue;"
                + "}"

                + "label {"
                + "display: block;"
                + "margin-top: 12px;"
                + "}"

                + "input {"
                + "width: 100%;"
                + "padding: 9px;"
                + "margin-top: 5px;"
                + "box-sizing: border-box;"
                + "}"

                + "button {"
                + "width: 100%;"
                + "padding: 10px;"
                + "margin-top: 20px;"
                + "background: blue;"
                + "color: white;"
                + "border: none;"
                + "cursor: pointer;"
                + "}"

                + "button:hover {"
                + "background: darkblue;"
                + "}"

                + "</style>"
                + "</head>"

                + "<body>"

                + "<div class='container'>"

                + "<h2>Student Registration Form</h2>"

                + "<form action='" + request.getContextPath()
                + "/StudentAction' method='post'>"

                + "<label>Student ID:</label>"
                + "<input type='text' name='sid' required>"

                + "<label>Student Name:</label>"
                + "<input type='text' name='sname' required>"

                + "<label>Student Email:</label>"
                + "<input type='email' name='semail' required>"

                + "<label>Course ID:</label>"
                + "<input type='number' name='cid' required>"

                + "<label>Date of Birth:</label>"
                + "<input type='date' name='dob' required>"

                + "<button type='submit'>Register Student</button>"

                + "</form>"

                + "</div>"

                + "</body>"
                + "</html>";

        out.print(form);
    }
}