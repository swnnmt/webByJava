/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mactu
 */
public class Brand {
    private int brand_id;
    private int cartegory_id;
    private String brand_name;

    public int getBrand_id() {
        return brand_id;
    }

    public Brand(int cartegory_id, String brand_name) {
        this.cartegory_id = cartegory_id;
        this.brand_name = brand_name;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public int getCartegory_id() {
        return cartegory_id;
    }

    public void setCartegory_id(int cartegory_id) {
        this.cartegory_id = cartegory_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public Brand(int brand_id, int cartegory_id, String brand_name) {
        this.brand_id = brand_id;
        this.cartegory_id = cartegory_id;
        this.brand_name = brand_name;
    }

    public Brand() {
    }
}
