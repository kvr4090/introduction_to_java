package oop.task2;

import java.util.ArrayList;

/*
 * Создать класс Payment с внутренним классом, с помощью
 * объектов которого можно сформировать покупку из нескольких товаров.
 */

public class Payment {
    private ArrayList<Product> shoppingCart;

    public Payment(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void addBuy(double addPrice, String addName) {
        shoppingCart.add(new Product(addPrice,addName));
    }

    private class Product {
        double price;
        String name;

        public Product(double price, String name) {
            this.price = price;
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public String getName() {
            return name;
        }
    }
}
