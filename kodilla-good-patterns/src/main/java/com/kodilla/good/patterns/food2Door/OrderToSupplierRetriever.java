package com.kodilla.good.patterns.food2Door;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class OrderToSupplierRetriever {
    public OrderToSupplier retrieve() {
        List<SupplierProduct> productsList = ProductsRetriever.retrieve();
        Map<Integer, SupplierProduct> orderProductMap = new HashMap();
        orderProductMap.put(0, productsList.get(0));
        orderProductMap.put(1, productsList.get(1));

        OrderToSupplier.OrderToSupplierBuilder orderBuilder = OrderToSupplier.OrderToSupplierBuilder.aSupplierOrder();
        orderBuilder.withId(20180212103252L);
        orderBuilder.withDescription("Food replacement needed, ASAP!");
        orderBuilder.withOrderList(orderProductMap);

        return orderBuilder.build();
    }
}
