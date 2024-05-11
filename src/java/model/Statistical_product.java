/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mactu
 */
public class Statistical_product {
    private int product_id,total_quantity_sold;

    public Statistical_product() {
    }

    public Statistical_product(int product_id, int total_quantity_sold) {
        this.product_id = product_id;
        this.total_quantity_sold = total_quantity_sold;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getTotal_quantity_sold() {
        return total_quantity_sold;
    }

    public void setTotal_quantity_sold(int total_quantity_sold) {
        this.total_quantity_sold = total_quantity_sold;
    }
    
}
