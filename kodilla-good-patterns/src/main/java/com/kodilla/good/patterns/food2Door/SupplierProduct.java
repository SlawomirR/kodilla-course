package com.kodilla.good.patterns.food2Door;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplierProduct)) return false;
        if (!super.equals(o)) return false;
        SupplierProduct that = (SupplierProduct) o;
        return Double.compare(that.productQuantity, productQuantity) == 0 &&
                Objects.equals(supplierID, that.supplierID) &&
                Objects.equals(productPrice, that.productPrice);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), supplierID, productPrice, productQuantity);
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
