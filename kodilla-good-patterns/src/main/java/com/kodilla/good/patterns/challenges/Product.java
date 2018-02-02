package com.kodilla.good.patterns.challenges;

final class Product {
    private String productId;
    private String productName;
    private String productCategory;
    private double productPrice;

    Product(final String productId, final String productName, final String productCategory, final double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
    }
}
