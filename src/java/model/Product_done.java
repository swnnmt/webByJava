/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mactu
 */
public class Product_done {
    private String username,product_size,name_custom,phone_number,province,districts,address;
    private int product_id, product_quantity, id_done;
    private double product_done_price;

    public Product_done() {
    }

    public Product_done(String username, String product_size, String name_custom, String phone_number, String province, String districts, String address, int product_id, int product_quantity, int id_done, double product_done_price) {
        this.username = username;
        this.product_size = product_size;
        this.name_custom = name_custom;
        this.phone_number = phone_number;
        this.province = province;
        this.districts = districts;
        this.address = address;
        this.product_id = product_id;
        this.product_quantity = product_quantity;
        this.id_done = id_done;
        this.product_done_price = product_done_price;
    }

    public int getId_done() {
        return id_done;
    }

    public void setId_done(int id_done) {
        this.id_done = id_done;
    }

    public Product_done(String username, String product_size, String name_custom, String phone_number, String province, String districts, String address, int product_id, int product_quantity, double product_done_price) {
        this.username = username;
        this.product_size = product_size;
        this.name_custom = name_custom;
        this.phone_number = phone_number;
        this.province = province;
        this.districts = districts;
        this.address = address;
        this.product_id = product_id;
        this.product_quantity = product_quantity;
        this.product_done_price = product_done_price;
    }

    public double getProduct_done_price() {
        return product_done_price;
    }

    public void setProduct_done_price(double product_done_price) {
        this.product_done_price = product_done_price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProduct_size() {
        return product_size;
    }

    public void setProduct_size(String product_size) {
        this.product_size = product_size;
    }

    public String getName_custom() {
        return name_custom;
    }

    public void setName_custom(String name_custom) {
        this.name_custom = name_custom;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistricts() {
        return districts;
    }

    public void setDistricts(String districts) {
        this.districts = districts;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }
    
}
