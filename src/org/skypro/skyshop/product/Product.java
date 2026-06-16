package org.skypro.skyshop.product;

public abstract class Product implements Searchable{
    private String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    //Getters
    public String getProductName() {
        return this.productName;
    }

    public abstract double getProductPrice();
    public abstract boolean isSpecial();


    public String searchTerm(){
        return productName;
    }

    @Override
    public String getOfTypeContent(){
        return "PRODUCT";
    }

}