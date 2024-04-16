/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package newpackage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Admin
 */
@MultipartConfig
public class pmodifyservlet extends HttpServlet {

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
            out.println("<title>Servlet pmodifyservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            int pk_id=Integer.parseInt(request.getParameter("pk_id"));
            String pname=request.getParameter("pname");
            int pprice=Integer.parseInt(request.getParameter("pprice"));
            String plocation=request.getParameter("plocation");
            String ptype=request.getParameter("ptype");
            String pseason=request.getParameter("pseason");
            int pduration=Integer.parseInt(request.getParameter("pduration"));
            String pstatus=request.getParameter("pstatus");
            String pdescription=request.getParameter("pdescription");
            String pk_status=request.getParameter("pk_status");
            String uploadpath=null;
            String newPath=null;
            String image=null;
            image=request.getParameter("pk_image");
            Part file=request.getPart("image");
            
            String existingFilePath="D:/project/new project/adventour/web/"+image;
            String imageName=file.getSubmittedFileName();
            
            uploadpath="D:/project/new project/adventour/web/images/"+imageName;
            newPath="images/"+imageName;
            
            try {
                FileOutputStream fos=new FileOutputStream(uploadpath);
                InputStream is=file.getInputStream();
                
                byte[] data=new byte[is.available()];
                is.read(data);
                fos.write(data);
                fos.close();
            } catch (IOException e) {
            }
                try {
                
                    Connection con=connection.getconnection();
                
                    String sql="update package set pk_name=?,pk_type=?,pk_season=?,pk_location=?,pk_price=?,pk_description=?,pk_duration=?,pk_status=?,pk_image=? where pk_id=?";
                
                    PreparedStatement pts1=con.prepareStatement(sql);
                    pts1.setString(1, pname);
                    pts1.setString(2, ptype);
                    pts1.setString(3, pseason);
                    pts1.setString(4, plocation);
                    pts1.setInt(5, pprice);
                    pts1.setString(6, pdescription);
                    pts1.setInt(7, pduration);
                    if(pstatus!=null)
                    {
                        pts1.setString(8, pstatus);
                    }
                    else
                    {
                        pts1.setString(8, pk_status);
                    }
                    if(file!=null && file.getSubmittedFileName()!=null && !file.getSubmittedFileName().isEmpty())
                    {
                        pts1.setString(9, newPath);
                    }
                    else
                    {
                        pts1.setString(9,image );
                    }
                    
                    pts1.setInt(10, pk_id);
                
                    int row=pts1.executeUpdate();
                
                    if(row>0)
                    {
                        if(file!=null && file.getSubmittedFileName()!=null && !file.getSubmittedFileName().isEmpty())
                        {
                            try {
                                boolean delete=Files.deleteIfExists(Paths.get(existingFilePath));
                            } catch (Exception e) {
                            }
                        }
                        response.sendRedirect("admin/admin-package.jsp");
                    }
                } catch (SQLException e) {
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
