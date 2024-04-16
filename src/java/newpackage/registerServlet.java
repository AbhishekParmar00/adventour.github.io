/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package newpackage;

import com.mysql.cj.protocol.Resultset;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class registerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            String f_name=request.getParameter("f_name");
            String l_name=request.getParameter("l_name");
            String u_email=request.getParameter("u_email");
            String password=request.getParameter("password");
            int age=Integer.parseInt(request.getParameter("age")); 
            int hint=Integer.parseInt(request.getParameter("hint"));
            String state=request.getParameter("state");
            String city=request.getParameter("city");
            String gender=request.getParameter("gender");
            String image="images/defaultImg/unknown.jpg";
           
            try {
                
                Connection con=connection.getconnection();
                String str="select * from user_info where u_email=?";
                PreparedStatement pts1=con.prepareStatement(str);
                pts1.setString(1, u_email);
                
                ResultSet rs=pts1.executeQuery();
                
                if(rs.next())
                {
                    out.print("error | User already exists");
                }
                else
                {
                    user usermodel=new user(f_name,l_name,u_email,password,age,hint,state,city,gender,image);
                    
                    userdatabase reguser = new userdatabase(connection.getconnection());
                    
                    if(reguser.saveuser(usermodel))
                    {
                        out.print("success | Registation Successful");
                    }
                    else
                    {
                        
                         out.print("error | Registration Failed");
                    }
                }
            } catch (SQLException e) {
            }
                
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
