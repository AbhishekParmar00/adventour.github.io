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
public class userdatabase {
    Connection con;
    
    public userdatabase(Connection con)
    {
        this.con=con;
    }
    
    //for register user
    
    public boolean saveuser(user user)
    {
        boolean set=false;
        
        try {
            String query="insert into user_info(f_name,l_name,u_email,password,age,hint,state,city,gender,image) values(?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement pt=this.con.prepareStatement(query);
            pt.setString(1, user.getf_name());
            pt.setString(2, user.getl_name());
            pt.setString(3, user.getu_email());
            pt.setString(4, user.getpassword());
            pt.setInt(5, user.getage());
            pt.setInt(6, user.gethint());
            pt.setString(7, user.getstate());
            pt.setString(8, user.getcity());
            pt.setString(9, user.getgender());
            pt.setString(10, user.getimage());
            
            pt.execute();
            set=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return set;
    }
    
    public user loguser(String u_email,String password)
    {
        user user1=null;
        
        try {
            String query="select * from user_info where u_email=? and password=?";
            
            PreparedStatement pst=this.con.prepareStatement(query);
            pst.setString(1, u_email);
            pst.setString(2, password);
            
            ResultSet rs=pst.executeQuery();
            
            if(rs.next())
            {
                user1=new user();
                user1.setu_id(rs.getInt("u_id"));
                user1.setf_name(rs.getString("f_name"));
                user1.setl_name(rs.getString("l_name"));
                user1.setu_email(rs.getString("u_email"));
                user1.setpassword(rs.getString("password"));
                user1.setage(rs.getInt("age"));
                user1.sethint(rs.getInt("hint"));
                user1.setstate(rs.getString("state"));
                user1.setcity(rs.getString("city"));
                user1.setgender(rs.getString("gender"));
            }
            
        } catch (Exception e) {
        }
        return user1;
    }
    
    
}
