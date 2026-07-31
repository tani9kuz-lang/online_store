package org.skypro.skyshop.product;

import org.skypro.skyshop.product.search.Searchable;

public abstract class Product implements Searchable {
    private String productName;
    private String getOfTypeContent;

    public Product(String productName)throws IllegalArgumentException {
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
    public String getOfTypeContent() {
        return "PRODUCT";
    }

    @Override
    public String toString() {
        return productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return java.util.Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(productName);
    }
}