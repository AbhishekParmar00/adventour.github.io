/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

/**
 *
 * @author jsoni
 */
public class BookingData {
    
    int b_id;
    String f_name;
    String l_name;
    String mobile;
    String email;
    int passenger;
    String pick_city;
    String pick_point;
    String from_date;
    String to_date;
    int tprice;
    String pk_name;
    int pk_id;
    int u_id;
    String pk_image;
    String purchased_date;

    public BookingData(String f_name, String l_name, String mobile, String email, int passenger, String pick_city, String pick_point, String from_date, String to_date, int tprice, String pk_name, int pk_id, int u_id,String pk_image) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.mobile = mobile;
        this.email = email;
        this.passenger = passenger;
        this.pick_city = pick_city;
        this.pick_point = pick_point;
        this.from_date = from_date;
        this.to_date = to_date;
        this.tprice = tprice;
        this.pk_name = pk_name;
        this.pk_id = pk_id;
        this.u_id = u_id;
        this.pk_image=pk_image;
    }

    public BookingData(int b_id,int passenger, int tprice, String pk_name, int pk_id, String pk_image,String purchased_date,String from_date) {
        this.b_id=b_id;
        this.passenger = passenger;
        this.tprice = tprice;
        this.pk_name = pk_name;
        this.pk_id = pk_id;
        this.pk_image = pk_image;
        this.purchased_date=purchased_date;
        this.from_date=from_date;
    }

    public BookingData(int b_id, String f_name, String l_name, String mobile, String email, int passenger, String pick_city, String pick_point, String from_date, String to_date, int tprice, String pk_name, int u_id,String purchased_date) {
        this.b_id = b_id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.mobile = mobile;
        this.email = email;
        this.passenger = passenger;
        this.pick_city = pick_city;
        this.pick_point = pick_point;
        this.from_date = from_date;
        this.to_date = to_date;
        this.tprice = tprice;
        this.pk_name = pk_name;
        this.u_id = u_id;
        this.purchased_date=purchased_date;
    }

    
    
    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPassenger() {
        return passenger;
    }

    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }

    public String getPick_city() {
        return pick_city;
    }

    public void setPick_city(String pick_city) {
        this.pick_city = pick_city;
    }

    public String getPick_point() {
        return pick_point;
    }

    public void setPick_point(String pick_point) {
        this.pick_point = pick_point;
    }

    public String getFrom_date() {
        return from_date;
    }

    public void setFrom_date(String from_date) {
        this.from_date = from_date;
    }

    public String getTo_date() {
        return to_date;
    }

    public void setTo_date(String to_date) {
        this.to_date = to_date;
    }

    public int getTprice() {
        return tprice;
    }

    public void setTprice(int tprice) {
        this.tprice = tprice;
    }

    public String getPk_name() {
        return pk_name;
    }

    public void setPk_name(String pk_name) {
        this.pk_name = pk_name;
    }

    public int getPk_id() {
        return pk_id;
    }

    public void setPk_id(int pk_id) {
        this.pk_id = pk_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getPk_image() {
        return pk_image;
    }

    public void setPk_image(String pk_image) {
        this.pk_image = pk_image;
    }

    public String getPurchased_date() {
        return purchased_date;
    }

    public void setPurchased_date(String purchased_date) {
        this.purchased_date = purchased_date;
    }
    
    
}
