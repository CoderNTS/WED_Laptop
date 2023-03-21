/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Southern Alula
 */
public class OrderDetail {

    private int id;
    private int order_id;
    private int product_id;
    private String product_tite;
    private double price;
    private int quantity;
    private double total_money;

    public OrderDetail() {
    }

    public OrderDetail(int id, int order_id, int product_id, double price, int quantity, double total_money) {
        this.id = id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.price = price;
        this.quantity = quantity;
        this.total_money = total_money;
    }

    public OrderDetail(String product_tite, double price, int quantity, double total_money) {
        this.product_tite = product_tite;
        this.price = price;
        this.quantity = quantity;
        this.total_money = total_money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal_money() {
        return total_money;
    }

    public void setTotal_money(double total_money) {
        this.total_money = total_money;
    }

    public String getProduct_tite() {
        return product_tite;
    }

    public void setProduct_tite(String product_tite) {
        this.product_tite = product_tite;
    }

}
