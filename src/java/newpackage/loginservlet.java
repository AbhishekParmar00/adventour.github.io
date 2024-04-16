package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;

public class loginservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String u_email = request.getParameter("u_email");
            String password = request.getParameter("password");
            String prevUrl = request.getParameter("prevUrl");
            HttpSession session = request.getSession();
            int i = (int) session.getAttribute("previousUrl");

            userdatabase db = new userdatabase(connection.getconnection());
            user user = db.loguser(u_email, password);
            if (user != null) {
                // User login success
                session.setAttribute("loguser", user);
                if (i == 0) {
                    out.write("user," + prevUrl); // Comma-separated string for user login success and prevUrl
                } else {
                    out.write("index");
                }
            } else {
                // Invalid credentials
                out.write("Invalid email or password");
            }
    }
}

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
public String getServletInfo() {
        return "Handles login requests";
    }
}
