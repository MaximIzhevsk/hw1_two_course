package org.skypro.skyshop;

public class Product {
    private String productName;
    private int costOfTheProduct;

    public Product(String productName, int costOfTheProduct) {
        this.productName = productName;
        this.costOfTheProduct = costOfTheProduct;
    }

    public String getProductName() {
        return productName;
    }

    public int getCostOfTheProduct() {
        return costOfTheProduct;
    }
}
