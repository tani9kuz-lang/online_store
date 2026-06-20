package org.skypro.skyshop.product;

public class SimpleProduct extends Product{
    private int productPrice;


    public SimpleProduct(String productName, int productPrice) throws IllegalArgumentException{
        super(productName);
        if (productPrice<= 0){
            throw new IllegalArgumentException("Стоимость товара не может быть меньше 1");
        } else {
            this.productPrice = productPrice;
        }
    }

    @Override
    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public String toString() {
        return "Name " + getProductName() + " price=" + productPrice;
    }
    @Override
    public boolean isSpecial() {
        return true;
    }

}
