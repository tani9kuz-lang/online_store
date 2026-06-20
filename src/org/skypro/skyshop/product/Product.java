package org.skypro.skyshop.product;

import org.skypro.skyshop.product.search.Searchable;

public abstract class Product implements Searchable {
    private String productName;

    public Product(String productName)throws IllegalArgumentException {
        //this.productName = productName;
        if (productName.isBlank()) {
            throw  new IllegalArgumentException("Название не может быть пустой строкой");
        }else {
            this.productName = productName;
        }
    }

    //Getters
    public String getProductName() {
        return this.productName;
    }

    public abstract double getProductPrice();
    public abstract boolean isSpecial();

    @Override
    public String searchTerm(){
        return productName;
    }

    @Override
    public String getOfTypeContent(){
        return "PRODUCT";
    }

}