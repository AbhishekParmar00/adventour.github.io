/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class bookingservlet extends HttpServlet {

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
            out.println("<title>Servlet bookingservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            String f_name=request.getParameter("bfname");
            String l_name=request.getParameter("blname");
            String email=request.getParameter("bemail");
            String pick_city=request.getParameter("pick_city");
            String pick_point=request.getParameter("pick_point");
            int totalpricehidden=Integer.parseInt(request.getParameter("totalpricehidden"));
            int totaltouristhidden=Integer.parseInt(request.getParameter("totaltouristhidden"));
            String mobile=request.getParameter("bmobile");
            String from_date=request.getParameter("from_date");
            String to_date=request.getParameter("to_date");
            String pk_name=request.getParameter("pk_name");
            int pk_id=Integer.parseInt(request.getParameter("pk_id"));
            int u_id=Integer.parseInt(request.getParameter("u_id"));
            int b_id=0;
            
            LocalDate today1=LocalDate.now();
            String today=today1.toString();
            Connection con=connection.getconnection();
            
            try {
                String sql1="insert into booking(f_name,l_name,mobile,email,passenger,pick_city,pick_point,from_date,to_date,tprice,pk_name,pk_id,u_id,purchased_date) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                
                PreparedStatement pts1=con.prepareStatement(sql1);
                pts1.setString(1, f_name);
                pts1.setString(2, l_name);
                pts1.setString(3, mobile);
                pts1.setString(4, email);
                pts1.setInt(5, totaltouristhidden);
                pts1.setString(6, pick_city);
                pts1.setString(7, pick_point);
                pts1.setString(8, from_date);
                pts1.setString(9, to_date);
                pts1.setInt(10, totalpricehidden);
                pts1.setString(11, pk_name);
                pts1.setInt(12, pk_id);
                pts1.setInt(13, u_id);
                pts1.setString(14, today);

                
                int row=pts1.executeUpdate();
                
                if (row>0) 
                {
                    
                    HttpSession setId=request.getSession();
                    setId.setAttribute("pk_id", pk_id);
                    int tseat;
                    
                    try {
                        String sql3="select seat_no from transport where location=?";
                        
                        PreparedStatement pts3=con.prepareStatement(sql3);
                        pts3.setString(1, pick_city);
                        
                        ResultSet rs3=pts3.executeQuery();
                        
                        if (rs3.next()) 
                        {
                            tseat=rs3.getInt("seat_no");
                            
                            if(tseat>=55)
                            {
                                tseat=0;
                                tseat=tseat+totaltouristhidden;
                            }
                            else if((tseat+totaltouristhidden)>=55)
                            {
                                tseat=0;
                                tseat=tseat+totaltouristhidden;
                            }
                            else
                            {
                                tseat=tseat+totaltouristhidden;
                            }
                            
                            String sql4="update transport set seat_no=? where location=?";
                            PreparedStatement pts4=con.prepareStatement(sql4);
                            pts4.setInt(1, tseat);
                            pts4.setString(2, pick_city);
                            
                            int rows2=pts4.executeUpdate();
                        }
                        
                    } catch (Exception e) {
                    }
                }
                
                response.sendRedirect("user/thankspage.jsp");
                
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
