package org.example;

import java.time.LocalDate;
import java.util.Set;

public class Product {
    String name;
    int price;
    LocalDate expirationDate;
    Set<String> category;

    public Product(String name, int price, LocalDate expirationDate, Set<String> category) {
        this.name = name;
        this.price = price;
        this.expirationDate = expirationDate;
        this.category = category;
    }
}
