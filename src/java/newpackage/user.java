/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

/**
 *
 * @author Admin
 */
public class user {
    int u_id;
    String f_name;
    String l_name;
    String u_email;
    String password;
    int age;
    int hint;
    String state;
    String city;
    String gender;
    String image;
    
    public user()
    {
    
    }
    
    public user(String u_email,String password)
    {
        this.u_email=u_email;
        this.password=password;
    }
    
    public user(String f_name,String l_name,String u_email,String password,int age,int hint,String state,String city,String gender,String image)
    {
        
        this.f_name=f_name;
        this.l_name=l_name;
        this.u_email=u_email;
        this.password=password;
        this.age=age;
        this.hint=hint;
        this.state=state;
        this.city=city;
        this.gender=gender;
        this.image=image;
    }
    
     public user(int u_id,String f_name,String l_name,String u_email,String password,int age,int hint,String state,String city,String gender,String image)
    {
        this.u_id=u_id;
        this.f_name=f_name;
        this.l_name=l_name;
        this.u_email=u_email;
        this.password=password;
        this.age=age;
        this.hint=hint;
        this.state=state;
        this.city=city;
        this.gender=gender;
        this.image=image;
    }
    
    public void setu_id(int u_id)
    {
        this.u_id=u_id;
    }
    
    public int getu_id()
    {
        return u_id;
    }
    
    public String getf_name()
    {
        return f_name;
    }
    
    public String getl_name()
    {
        return l_name;
    }
    
    public String getu_email()
    {
        return u_email;
    }
    
    public String getpassword()
    {
        return password;
    }
    
    public int getage()
    {
        return age;
    }
    
    public int gethint()
    {
        return hint;
    }
    
    public String getstate()
    {
        return state;
    }
    
    public String getcity()
    {
        return city;
    }
    
    public String getgender()
    {
        return gender;
    }
    
    public void setf_name(String f_name)
    {
        this.f_name=f_name;
    }
    
    public void setl_name(String l_name)
    {
        this.l_name=l_name;
    }
    
    public void setu_email(String u_email)
    {
        this.u_email=u_email;
    }
    
    public void setpassword(String password)
    {
        this.password=password;
    }
    
    public void setage(int age)
    {
        this.age=age;
    }
    
    public void sethint(int hint)
    {
        this.hint=hint;
    }
    
    public void setstate(String state)
    {
        this.state=state;
    }
    
    public void setcity(String city)
    {
        this.city=city;
    }
    
    public void setgender(String gender)
    {
        this.gender=gender;
    }
    
    public String getimage()
    {
        return image;
    }
    
    public void setimage(String image)
    {
        this.image=image;
    }
            
}
