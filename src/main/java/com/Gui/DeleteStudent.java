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

@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String sid = request.getParameter("sid");

        if (sid == null || sid.trim().isEmpty()) {

            response.sendRedirect(request.getContextPath() + "/StudentList");
            return;
        }

        String sql = "DELETE FROM student WHERE sid = ?";

        try (Connection con = DbConnectio.getConnection();

             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, sid);

            int result = ps.executeUpdate();

            if (result > 0) {

                response.sendRedirect(
                        request.getContextPath() + "/StudentList?msg=deleted");

            } else {

                response.sendRedirect(
                        request.getContextPath() + "/StudentList?msg=notfound");
            }

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println("Error deleting student: "
                    + e.getMessage());
        }
    }
}