package com.kodilla.good.patterns.food2Door;

import java.math.BigDecimal;

public class SupplierProduct extends Product {
    private String supplierID;
    private BigDecimal productPrice;
    private double productQuantity;

    SupplierProduct(final String productID, final String productDesc, final String usedUnit,
                           final String supplierID, final BigDecimal productPrice, double productQuantity) {
        super(productID, productDesc, usedUnit);
        this.supplierID = supplierID;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    String getSupplierID() {
        return supplierID;
    }

    BigDecimal getProductPrice() {
        return productPrice;
    }

    double getProductQuantity() {
        return productQuantity;
    }

    @Override
    public String toString() {
        return "SupplierProduct{" +
                "supplierID='" + getSupplierID() + '\'' +
                ", productPrice=" + getProductPrice() +
                ", productQuantity=" + getProductQuantity() +
                ", productID='" + getProductID() + '\'' +
                ", productDesc='" + getProductDesc() + '\'' +
                ", usedUnit='" + getUsedUnit() + '\'' +
                '}';
    }
}
