/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mactu
 */
public class Product {
    private int product_id;
    private int product_quantity;
    private String product_name;
    private int cartegory_id;
    private int brand_id;
    private double product_price;
    private double product_price_sale;
    private String product_img;
    private String product_desc;


    public Product() {
    }

    public Product(int product_id, int product_quantity, String product_name, int cartegory_id, int brand_id, double product_price, double product_price_sale, String product_img, String product_desc) {
        this.product_id = product_id;
        this.product_quantity = product_quantity;
        this.product_name = product_name;
        this.cartegory_id = cartegory_id;
        this.brand_id = brand_id;
        this.product_price = product_price;
        this.product_price_sale = product_price_sale;
        this.product_img = product_img;
        this.product_desc = product_desc;
    }

    public Product(int product_quantity, String product_name, int cartegory_id, int brand_id, double product_price, double product_price_sale, String product_img, String product_desc) {
        this.product_quantity = product_quantity;
        this.product_name = product_name;
        this.cartegory_id = cartegory_id;
        this.brand_id = brand_id;
        this.product_price = product_price;
        this.product_price_sale = product_price_sale;
        this.product_img = product_img;
        this.product_desc = product_desc;
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

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getCartegory_id() {
        return cartegory_id;
    }

    public void setCartegory_id(int cartegory_id) {
        this.cartegory_id = cartegory_id;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public double getProduct_price_sale() {
        return product_price_sale;
    }

    public void setProduct_price_sale(double product_price_sale) {
        this.product_price_sale = product_price_sale;
    }

    public String getProduct_img() {
        return product_img;
    }

    public void setProduct_img(String product_img) {
        this.product_img = product_img;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }
    
}
