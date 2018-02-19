package com.kodilla.good.patterns.food2Door;

import java.util.Objects;

public abstract class Product {
    private String productID;
    private String productDesc;
    private String usedUnit;

    Product(final String productID, final String productDesc, final String usedUnit) {
        this.productID   = productID;
        this.productDesc = productDesc;
        this.usedUnit    = usedUnit;
    }

    String getProductID() {
        return productID;
    }

    String getProductDesc() {
        return productDesc;
    }

    String getUsedUnit() {
        return usedUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productID, product.productID) &&
                Objects.equals(productDesc, product.productDesc) &&
                Objects.equals(usedUnit, product.usedUnit);
    }

    @Override
    public int hashCode() {

        return Objects.hash(productID, usedUnit);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", usedUnit='" + usedUnit + '\'' +
                '}';
    }
}
