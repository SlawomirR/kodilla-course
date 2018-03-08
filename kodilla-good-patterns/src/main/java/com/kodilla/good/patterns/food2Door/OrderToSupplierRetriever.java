package com.kodilla.good.patterns.food2Door;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class OrderToSupplierRetriever {
    public OrderToSupplier retrieve() {
        List<SupplierProduct> productsList = ProductsRetriever.retrieve();
        Map<SupplierProduct, Integer> orderProductMap = new HashMap<>();
        orderProductMap.put(productsList.get(0), 150);
        orderProductMap.put(productsList.get(1), 200);
        System.out.println("Ordering products.");
        OrderToSupplier.OrderToSupplierBuilder orderBuilder = OrderToSupplier.OrderToSupplierBuilder.aSupplierOrder();
        orderBuilder.withId(20180212103252L);
        orderBuilder.withDescription("Food replacement needed, ASAP!");
        orderBuilder.withOrderList(orderProductMap);

        return orderBuilder.build();
    }
}
