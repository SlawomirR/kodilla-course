package com.kodilla.good.patterns.food2Door;

import java.util.Map;

public class SupplierProductCatalogReceiver {
    private Repository repository;
    private SupplierConnector supplierConnector;

    SupplierProductCatalogReceiver(final Repository repository, final SupplierConnector supplierConnector) {
        this.repository = repository;
        this.supplierConnector = supplierConnector;
    }

    boolean receive() {
        Map<Integer, SupplierProduct> productCatalog = supplierConnector.importProductCatalog();
        if (!productCatalog.isEmpty()) {
            repository.importSupplierProducts(productCatalog);
            return true;
        }
        return false;
    }
}
