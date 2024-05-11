/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mactu
 */
public class Product_detail {
    private int product_id;
    private String product_img_desc_1,product_img_desc_2,product_img_desc_3,product_img_desc_4;
    private String product_color;
    private String product_intro;
    private String product_prever;

    public Product_detail(int product_id, String product_img_desc_1, String product_img_desc_2, String product_img_desc_3, String product_img_desc_4, String product_color, String product_intro, String product_prever) {
        this.product_id = product_id;
        this.product_img_desc_1 = product_img_desc_1;
        this.product_img_desc_2 = product_img_desc_2;
        this.product_img_desc_3 = product_img_desc_3;
        this.product_img_desc_4 = product_img_desc_4;
        this.product_color = product_color;
        this.product_intro = product_intro;
        this.product_prever = product_prever;
    }

    public Product_detail() {
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_img_desc_1() {
        return product_img_desc_1;
    }

    public void setProduct_img_desc_1(String product_img_desc_1) {
        this.product_img_desc_1 = product_img_desc_1;
    }

    public String getProduct_img_desc_2() {
        return product_img_desc_2;
    }

    public void setProduct_img_desc_2(String product_img_desc_2) {
        this.product_img_desc_2 = product_img_desc_2;
    }

    public String getProduct_img_desc_3() {
        return product_img_desc_3;
    }

    public void setProduct_img_desc_3(String product_img_desc_3) {
        this.product_img_desc_3 = product_img_desc_3;
    }

    public String getProduct_img_desc_4() {
        return product_img_desc_4;
    }

    public void setProduct_img_desc_4(String product_img_desc_4) {
        this.product_img_desc_4 = product_img_desc_4;
    }

    public String getProduct_color() {
        return product_color;
    }

    public void setProduct_color(String product_color) {
        this.product_color = product_color;
    }

    public String getProduct_intro() {
        return product_intro;
    }

    public void setProduct_intro(String product_intro) {
        this.product_intro = product_intro;
    }

    public String getProduct_prever() {
        return product_prever;
    }

    public void setProduct_prever(String product_prever) {
        this.product_prever = product_prever;
    }
    
}
