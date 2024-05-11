/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mactu
 */
public class Cartegory {
    private int cartegory_id;
    private String  cartegory_name; 

    public Cartegory() {
    }

    public Cartegory(String cartegory_name) {
        this.cartegory_name = cartegory_name;
    }

    public Cartegory(int cartegory_id, String cartegory_name) {
        this.cartegory_id = cartegory_id;
        this.cartegory_name = cartegory_name;
    }

    public int getCartegory_id() {
        return cartegory_id;
    }

    public void setCartegory_id(int cartegory_id) {
        this.cartegory_id = cartegory_id;
    }

    public String getCartegory_name() {
        return cartegory_name;
    }

    public void setCartegory_name(String cartegory_name) {
        this.cartegory_name = cartegory_name;
    }
    
}
