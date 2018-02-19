package com.kodilla.good.patterns.food2Door;

public class Application {
    public static void main(String[] args) {
        System.out.println("Updating products catalog.");
        SupplierProductCatalogReceiver supplierProductCatalogReceiver = new SupplierProductCatalogReceiver(
                new RepositoryDb(), new ExtraFoodShopConnector()
        );
        boolean receiveStatus = supplierProductCatalogReceiver.receive();
        if (receiveStatus) {
            System.out.println("New products added to catalog. All information updated.");
        } else {
            System.out.println("Update products information failed.");
        }

        System.out.println("Ordering products.");
        OrderToSupplierRetriever orderToSupplierRetriever = new OrderToSupplierRetriever();
        OrderToSupplier orderToSupplier = orderToSupplierRetriever.retrieve();
        SupplierOrderProcessor supplierOrderProcessor = new SupplierOrderProcessor(
                new RepositoryDb(), new ExtraFoodShopConnector()
        );
        boolean orderStatus = supplierOrderProcessor.process(orderToSupplier);
        if (orderStatus) {
            System.out.println("Order placed.");
        } else {
            System.out.println("Order rejected or could not be sent.");
        }
    }
}
