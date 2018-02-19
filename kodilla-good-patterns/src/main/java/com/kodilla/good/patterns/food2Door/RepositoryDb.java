package com.kodilla.good.patterns.food2Door;

import java.util.Map;
import java.util.stream.Collectors;

public class RepositoryDb implements Repository {

    public boolean importSupplierProducts(final Map<Integer, SupplierProduct> catalog) {
        System.out.println("Importing products to system database:");
        String importedProducts = catalog.entrySet().stream()
                .map(e -> e.getKey() + "\t" + e.getValue())
                .collect(Collectors.joining("\n"));
        System.out.println(importedProducts);
        System.out.println("All products imported successfully.");
        return true;
    }

    public boolean createSupplierOrder(final OrderToSupplier order) {
        System.out.println("Placing created order " + order.getId() + " to the queue." );
        return true;
    }

    public boolean saveConfirmationStatus(Long orderId, boolean isConfirmed) {
        String status = isConfirmed ? "confirmed" : "rejected";
        System.out.println("Order " + orderId + " has been " + status + " by supplier.");
        return true;
    }
}
