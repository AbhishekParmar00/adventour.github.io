/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class connection {
    private static Connection con;
    
    public static Connection getconnection()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adventour","root","12345");
            
        } catch (ClassNotFoundException | SQLException e) {
        }
        return con;
    }
}
