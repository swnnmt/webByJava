/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mactu
 */
public class Statistical_customer {
    private String username;
    private int total_products_bought;

    public Statistical_customer(String username, int total_products_bought) {
        this.username = username;
        this.total_products_bought = total_products_bought;
    }

    public Statistical_customer() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTotal_products_bought() {
        return total_products_bought;
    }

    public void setTotal_products_bought(int total_products_bought) {
        this.total_products_bought = total_products_bought;
    }
    
}
