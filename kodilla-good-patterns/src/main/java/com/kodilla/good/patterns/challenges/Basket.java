package com.kodilla.good.patterns.challenges;

import java.util.HashMap;
import java.util.Map;

final class Basket {
    private String orderId;
    private Map<Product, Integer> productNameAndQuantity = new HashMap<>();

    void addItem(final Product item, final Integer quantity, final String orderId) {
        this.productNameAndQuantity.put(item, quantity);
    }
    Map<Product, Integer> getProductNameAndQuantity() {
        return productNameAndQuantity;
    }

    void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    void setProductNameAndQuantity(Map<Product, Integer> productNameAndQuantity) {
        this.productNameAndQuantity = productNameAndQuantity;
    }

    double calculateTotalPrice() {
        return 0;
    }
}
