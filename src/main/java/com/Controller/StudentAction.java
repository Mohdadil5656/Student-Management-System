package com.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.Model.Student;
import com.Service.StudentService;

@WebServlet("/StudentAction")
public class StudentAction extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {

            System.out.println("Student Action Called");

            LocalDateTime createdBy = LocalDateTime.now();

            String sid = request.getParameter("sid");
            String sname = request.getParameter("sname");
            String semail = request.getParameter("semail");

            int cid = Integer.parseInt(request.getParameter("cid"));

            LocalDate dob = LocalDate.parse(request.getParameter("dob"));

            Student st = new Student(createdBy, sid, sname, semail, cid, dob);

            StudentService sv = new StudentService();

            int row = sv.saveStudentRecord(st);

            System.out.println("Rows Inserted: " + row);

            if(row > 0) {

                response.sendRedirect(request.getContextPath()
                        + "/Dashboard?name="
                        + java.net.URLEncoder.encode(sname, "UTF-8"));

            }
            else {

                out.print("Student Registration Failed!");

            }

        } catch (Exception e) {

            e.printStackTrace();

            out.print("Error: " + e.getMessage());

        }

    }
}