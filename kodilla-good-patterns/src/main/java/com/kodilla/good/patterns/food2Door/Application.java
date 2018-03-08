package com.kodilla.good.patterns.food2Door;

public class Application {
    public static void main(String[] args) {
        InformationService informationService = new NotificationService();

        SupplierProductCatalogReceiver supplierProductCatalogReceiver = new SupplierProductCatalogReceiver(
                new RepositoryDb(), new ExtraFoodShopConnector());
        informationService.receivingStatusNotifier(supplierProductCatalogReceiver.receive());

        OrderToSupplierRetriever orderToSupplierRetriever = new OrderToSupplierRetriever();
        OrderToSupplier orderToSupplier = orderToSupplierRetriever.retrieve();
        SupplierOrderProcessor supplierOrderProcessor = new SupplierOrderProcessor(
                new RepositoryDb(), new ExtraFoodShopConnector());
        informationService.systemNotifier(supplierOrderProcessor.process(orderToSupplier));
    }
}
