package org.example;

import java.util.List;
import java.util.Scanner;

//Want to ask questions? Ask them here
//Want to use the scanner? Use it here
//User input? Also, here. You will have to call the file manager
//and the product class from here.

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static List<Product> products;
    static ShoppingCart cart = new ShoppingCart();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


            products = FileManager.getProducts();

            boolean running = true;


            while (running) {

                showMenu();
                String choice = scanner.nextLine();

                switch (choice) {

                    case "1":
                        showAllProducts();
                        break;

                    case "2":
                        showCart();
                        break;

                    case "0":
                        System.out.println("Goodbye!");
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid option.");
                }
            }
        }


        public static void showMenu() {
            System.out.println("\n=== STORE HOME ===");
            System.out.println("1. Display Products");
            System.out.println("2. Display Cart");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
        }


        public static void showAllProducts() {

            boolean back = false;

            while (!back) {

                System.out.println("\n=== PRODUCTS ===");

                for (Product p : products) {
                    System.out.println(p);
                }

                System.out.println("\n1. Search by Name");
                System.out.println("2. Search by Price");
                System.out.println("3. Search by Department");
                System.out.println("4. Add Product to Cart");
                System.out.println("0. Back");

                String choice = scanner.nextLine();

                switch (choice) {

                    case "1":
                        System.out.print("Enter name: ");
                        searchProductsByName(scanner.nextLine());
                        break;

                    case "2":
                        System.out.print("Min price: ");
                        double min = Double.parseDouble(scanner.nextLine());

                        System.out.print("Max price: ");
                        double max = Double.parseDouble(scanner.nextLine());

                        searchProductsByPriceRange(min, max);
                        break;

                    case "3":
                        System.out.print("Department: ");
                        searchProductsByCategory(scanner.nextLine());
                        break;

                    case "4":
                        System.out.print("Enter SKU: ");
                        Product productToAdd = selectProductBySku(scanner.nextLine());

                        if (productToAdd != null) {
                            cart.addToCart(productToAdd);
                            System.out.println("Added to cart!");
                        } else {
                            System.out.println("Product not found.");
                        }
                        break;

                    case "0":
                        back = true;
                        break;
                }
            }
        }

        public static void showCart() {

            boolean back = false;

            while (!back) {

                System.out.println("\n=== CART ===");
                cart.displayCart();

                System.out.println("\n1. Remove Product");
                System.out.println("0. Back");

                String choice = scanner.nextLine();

                switch (choice) {

                    case "1":
                        System.out.print("Enter SKU: ");
                        Product productToRemove = selectProductBySku(scanner.nextLine());

                        if (productToRemove != null) {
                            cart.removeFromCart(productToRemove);
                            System.out.println("Removed from cart.");
                        } else {
                            System.out.println("Product not found.");
                        }
                        break;

                    case "0":
                        back = true;
                        break;
                }
            }
        }


        public static Product selectProductBySku(String sku) {

            for (Product p : products) {
                if (p.getSku().equalsIgnoreCase(sku)) {
                    return p;
                }
            }

            return null;
        }

        public static void searchProductsByName(String name) {
            for (Product p : products) {
                if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                    System.out.println(p);
                }
            }
        }

        public static void searchProductsByPriceRange(double minPrice, double maxPrice) {
            for (Product p : products) {
                if (p.getPrice() >= minPrice && p.getPrice() <= maxPrice) {
                    System.out.println(p);
                }
            }
        }

        public static void searchProductsByCategory(String category) {
            for (Product p : products) {
                if (p.getDepartment().equalsIgnoreCase(category)) {
                    System.out.println(p);
                }
            }
        }
    }

//1. Use the File Manager to load the file and create a list of products
//2. Instantiate a shopping cart
//3. Show the menu to the user
//4. Based on what they select, use the right method
//5. Use the shopping cart object you made to add and remove things from the shopping cart
//6. The key thing is "How am I going to grab the specific item the user wants?"
