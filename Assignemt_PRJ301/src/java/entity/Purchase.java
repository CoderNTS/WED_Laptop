/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import dal.*;

/**
 *
 * @author msi
 */
public class Purchase {

    private String order_date;
    private String product_title;
    private double price;
    private int quantity;
    private double total_money;
    private int ststus;

    public Purchase(String order_date, String product_title, double price, int quantity, double total_money, int ststus) {
        this.order_date = order_date;
        this.product_title = product_title;
        this.price = price;
        this.quantity = quantity;
        this.total_money = total_money;
        this.ststus = ststus;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
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

    public int getStstus() {
        return ststus;
    }

    public void setStstus(int ststus) {
        this.ststus = ststus;
    }

}
