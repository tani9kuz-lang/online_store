package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIX_PRICE = 1000;
    public static int countFixPriceProduct = 0;


    public FixPriceProduct(String name) {
        super(name);
        countFixPriceProduct++;
    }

    @Override
    public double getProductPrice() {
        return FIX_PRICE;
    }


    @Override
    public String toString() {
        return super.getProductName() + " : Фиксированная цена " + FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
