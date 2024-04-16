/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;


public class favServlet extends HttpServlet {

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
            out.println("<title>Servlet favServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            int pk_id=Integer.parseInt(request.getParameter("pk_id"));
            int u_id=Integer.parseInt(request.getParameter("u_id"));
            
            
            try {
                Connection con=connection.getconnection();
                
                String sql="select * from fav where u_id=? and pk_id=?";
                PreparedStatement pts1=con.prepareStatement(sql);
                pts1.setInt(1, u_id);
                pts1.setInt(2, pk_id);
                
                ResultSet rs=pts1.executeQuery();
                
                if(rs.next())
                {
                    HttpSession session=request.getSession();
                    session.setAttribute("errorMessage", "package already inserted");
                    response.sendRedirect("user/package.jsp");
                            
                }else
                {   
                String sql2="insert into fav(u_id,pk_id) values(?,?)";
                
                PreparedStatement pts2=con.prepareStatement(sql2);
                pts2.setInt(1, u_id);
                pts2.setInt(2, pk_id);
                
                int i=pts2.executeUpdate();
                
                HttpSession session=request.getSession();
                session.setAttribute("successMessage", "Package Added Successfully");
                response.sendRedirect("user/package.jsp");
                }
            } catch (IOException | SQLException e) {
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
