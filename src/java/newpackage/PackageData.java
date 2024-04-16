/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

public class PackageData {
    int pk_id;
    String pk_name;
    String pk_type;
    String pk_season;
    String pk_location;
    int pk_price;
    String pk_description;
    String pk_duration;
    String pk_status;
    String pk_image;

    public PackageData(int pk_id, String pk_name, String pk_type, String pk_season, String pk_location, int pk_price, String pk_description, String pk_duration, String pk_status, String pk_image) {
        this.pk_id = pk_id;
        this.pk_name = pk_name;
        this.pk_type = pk_type;
        this.pk_season = pk_season;
        this.pk_location = pk_location;
        this.pk_price = pk_price;
        this.pk_description = pk_description;
        this.pk_duration = pk_duration;
        this.pk_status = pk_status;
        this.pk_image = pk_image;
    }

    
    
    public int getpk_id() {
        return pk_id;
    }

    public void setpk_id(int pk_id) {
        this.pk_id = pk_id;
    }

    public String getpk_name() {
        return pk_name;
    }

    public void setpk_name(String pk_name) {
        this.pk_name = pk_name;
    }

    public String getpk_type() {
        return pk_type;
    }

    public void setpk_type(String pk_type) {
        this.pk_type = pk_type;
    }

    public String getpk_season() {
        return pk_season;
    }

    public void setpk_season(String pk_season) {
        this.pk_season = pk_season;
    }

    public String getpk_location() {
        return pk_location;
    }

    public void setpk_location(String pk_location) {
        this.pk_location = pk_location;
    }

    public int getpk_price() {
        return pk_price;
    }

    public void setpk_price(int pk_price) {
        this.pk_price = pk_price;
    }

    public String getpk_description() {
        return pk_description;
    }

    public void setpk_description(String pk_description) {
        this.pk_description = pk_description;
    }

    public String getpk_duration() {
        return pk_duration;
    }

    public void setpk_duration(String pk_duration) {
        this.pk_duration = pk_duration;
    }

    public String getpk_status() {
        return pk_status;
    }

    public void setpk_status(String pk_status) {
        this.pk_status = pk_status;
    }

    public String getpk_image() {
        return pk_image;
    }

    public void setpk_image(String pk_image) {
        this.pk_image = pk_image;
    }
    
    
}
