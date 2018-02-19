package com.kodilla.good.patterns.food2Door;

public class SupplierOrderProcessor {
    private Repository repository;
    private SupplierConnector supplierConnector;

    SupplierOrderProcessor(final Repository repository, final SupplierConnector supplierConnector) {
        this.repository = repository;
        this.supplierConnector = supplierConnector;
    }

    boolean process(OrderToSupplier orderToSupplier) {
        boolean isOrdered = supplierConnector.process(orderToSupplier);
        if (isOrdered) {
            repository.createSupplierOrder(orderToSupplier);
            boolean isOrderConfirmed = supplierConnector.receiveOrderConfirmation(orderToSupplier.getId());
            repository.saveConfirmationStatus(orderToSupplier.getId(), isOrderConfirmed);
            return isOrderConfirmed;
        }
        return false;
    }
}
