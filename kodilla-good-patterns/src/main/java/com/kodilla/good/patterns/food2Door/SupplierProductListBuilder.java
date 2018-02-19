package com.kodilla.good.patterns.food2Door;

import java.math.BigDecimal;

public final class SupplierProductListBuilder {
    private String productID;
    private String productDesc;
    private String usedUnit;
    private String supplierID;
    private BigDecimal productPrice;
    private double productQuantity;

    private SupplierProductListBuilder() {
    }

    public static SupplierProductListBuilder aSupplierProduct() {
        return new SupplierProductListBuilder();
    }

    public SupplierProductListBuilder withProductID(String productID) {
        this.productID = productID;
        return this;
    }

    public SupplierProductListBuilder withProductDesc(String productDesc) {
        this.productDesc = productDesc;
        return this;
    }

    public SupplierProductListBuilder withSupplierID(String supplierID) {
        this.supplierID = supplierID;
        return this;
    }

    public SupplierProductListBuilder withUsedUnit(String usedUnit) {
        this.usedUnit = usedUnit;
        return this;
    }

    public SupplierProductListBuilder withProductQuantity(double productQuantity) {
        this.productQuantity = productQuantity;
        return this;
    }

    public SupplierProductListBuilder withProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
        return this;
    }

    public SupplierProduct buildList() {
        return new SupplierProduct(productID, productDesc, usedUnit, supplierID, productPrice, productQuantity);
    }
}
