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
@MultipartConfig()
public class UserprofileServlet extends HttpServlet {

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
            out.println("<title>Servlet UserpofileServlet</title>");
            out.println("</head>");
            out.println("<body>");

            String f_name = request.getParameter("f_name");
            String l_name = request.getParameter("l_name");
            String u_email = request.getParameter("u_email");
            int age = Integer.parseInt(request.getParameter("age"));
            String state1 = request.getParameter("state1");
            String state = request.getParameter("state");
            String city1 = request.getParameter("city1");
            String city = request.getParameter("city");
            String gender1 = request.getParameter("gender1");
            String gender = request.getParameter("gender");
            String image1 = request.getParameter("image1");
            int u_id = Integer.parseInt(request.getParameter("u_id"));
            Part file = request.getPart("image");

            String imageName = file.getSubmittedFileName();
            String existingFile = "D:/project/new project/adventour/web/" + image1;
            String uploadpath = "D:/project/new project/adventour/web/images/" + imageName;
            String newPath = "images/" + imageName;
            
            String default1 = "images/defaultImg/unknown.jpg";
            boolean check=image1.equalsIgnoreCase(default1);
            System.out.println(imageName);
            
            try {
                FileOutputStream fos = new FileOutputStream(uploadpath);
                InputStream is = file.getInputStream();

                byte[] data = new byte[is.available()];
                is.read(data);
                fos.write(data);
                fos.close();

            } catch (IOException e) {
            }
            
            try {
                Connection con = connection.getconnection();

                String sql = "update user_info set f_name=?,l_name=?,u_email=?,age=?,state=?,city=?,gender=?,image=? where u_id=?";

                PreparedStatement pts = con.prepareStatement(sql);
                pts.setString(1, f_name);
                pts.setString(2, l_name);
                pts.setString(3, u_email);
                pts.setInt(4, age);
                if (state == null) {
                    pts.setString(5, state1);
                } else {
                    pts.setString(5, state);
                }
                if (city == null) {
                    pts.setString(6, city1);
                } else {
                    pts.setString(6, city);
                }
                if (gender == null) {
                    pts.setString(7, gender1);
                } else {
                    pts.setString(7, gender);
                }
                if (file != null && file.getSubmittedFileName() != null && !file.getSubmittedFileName().isEmpty()) {
                    pts.setString(8, newPath);
                } else {
                    pts.setString(8, image1);
                }

                pts.setInt(9, u_id);
                
                int row = pts.executeUpdate();

                if (row > 0) {
                   if(check==false)
                   {
                        if (file != null && file.getSubmittedFileName() != null && !file.getSubmittedFileName().isEmpty()) {
                            try {
                                boolean delete = Files.deleteIfExists(Paths.get(existingFile));
                            } catch (Exception e) {
                            }
                        }
                    }
                }
                response.sendRedirect("user/userprofile.jsp");
            } catch (IOException | SQLException e) {
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
