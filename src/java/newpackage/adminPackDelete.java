/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class adminPackDelete extends HttpServlet {

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
            out.println("<title>Servlet adminPackDelete</title>");            
            out.println("</head>");
            out.println("<body>");
            
            int pk_id=Integer.parseInt(request.getParameter("pk_id"));
            System.out.println(pk_id);
            String Path=null;
            try {
                
                
                Connection con=connection.getconnection();
                
                String imgpath="select pk_image from package where pk_id=?";
                PreparedStatement pts1=con.prepareStatement(imgpath);
                pts1.setInt(1, pk_id);
                
                ResultSet rs=pts1.executeQuery();
                
                if(rs.next())
                {
                    Path=rs.getString("pk_image");
                    
                }
                
                String existingFilePath="D:/project/new project/adventour/web/"+Path;
                
                String sql="delete from package where pk_id=?";
                
                PreparedStatement pts=con.prepareStatement(sql);
                pts.setInt(1, pk_id);
                
                int row=pts.executeUpdate();
                
                if(row>0)
                {
                            try {
                                boolean delete=Files.deleteIfExists(Paths.get(existingFilePath));
                            } catch (IOException e) {
                                e.printStackTrace();
                            } 
                    response.sendRedirect("admin/admin-package.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
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
