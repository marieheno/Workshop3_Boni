package org.example;

import java.util.ArrayList;
import java.util.List;

//One of the properties of the shopping cart
//should be the products in the shopping cart
//What data structure would make sense here?


public class ShoppingCart {

    //Be sure to instantiate the list before using it
    public List<Product> cart = new ArrayList<>();

    //These methods are just placeholders, fill them in
    //With real logic
    public void addToCart(Product product){
        cart.add(product);
    }

    public void removeFromCart(Product product){
        cart.remove(product);
    }

    public double getCartTotal(){
        double total =  0;

        for (Product p : cart) {
            total += p.getPrice();
        }
        return total;
    }

    public  void displayCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        for (Product product : cart){
            System.out.println(product);
        }
        System.out.printf("Total: $%.2f" ,getCartTotal());
    }

}
