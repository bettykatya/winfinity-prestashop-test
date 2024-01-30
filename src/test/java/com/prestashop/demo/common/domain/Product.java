package com.prestashop.demo.common.domain;

import lombok.Data;

@Data
public class Product {
    int id;
    String name;
    double price;
    int discount;
    double discountedPrice;


    public Product(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = 0;
        this.discountedPrice = price;
    }

    public Product(int id, String name, Double price, Integer discount, Double discountedPrice) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.discountedPrice = discountedPrice;
    }
}
