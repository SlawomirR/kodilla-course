package com.kodilla.good.patterns.food2Door;

import java.util.Map;

public interface SupplierConnector {

    boolean process(OrderToSupplier order);

    boolean receiveOrderConfirmation(Long orderId);

    Map<Integer, SupplierProduct> importProductCatalog();
}
