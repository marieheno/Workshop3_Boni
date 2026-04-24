package org.example;

//This class is a POJO
//Plain ol' Java object
//No question asking, no files, no scanner, just product data

public class Product {

    //properties
    private String sku;
    private String name;
    private double price;
    private String department;

    //constructor(s)

    public Product(String sku, String name, double price, String department) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.department = department;
    }


    //getters and setters


    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    //HINT a to string method like this might be useful!
    //It can pipe format the information about the product
    @Override
    public String toString() {
        return String.format("%s - %s - $%.2f - %s", sku, name, price, department);
    }
}
