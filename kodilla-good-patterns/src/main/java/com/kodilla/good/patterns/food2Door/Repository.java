package com.kodilla.good.patterns.food2Door;

import java.util.Map;

public interface Repository {

    boolean importSupplierProducts(final Map<Integer, SupplierProduct> catalog);

    boolean createSupplierOrder(final OrderToSupplier order);

    boolean saveConfirmationStatus(Long orderId, boolean isConfirmed);
}
