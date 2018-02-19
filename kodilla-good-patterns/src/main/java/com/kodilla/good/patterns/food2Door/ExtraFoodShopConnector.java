package com.kodilla.good.patterns.food2Door;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExtraFoodShopConnector implements SupplierConnector {
    public boolean process(OrderToSupplier order) {
        System.out.println("Order successfully sent to ExtraFoodShop.");
        return true;
    }

    public boolean receiveOrderConfirmation(Long orderId) {
        System.out.println("ExtraFoodShop confirmed order " + orderId + ".");
        return true;
    }

    public Map<Integer, SupplierProduct> importProductCatalog() {
        List<SupplierProduct> productList = ProductsRetriever.retrieve();
        Map<Integer, SupplierProduct> productCatalog =
                IntStream.range(0, productList.size())
                        .boxed()
                        .collect(Collectors.toMap(i -> i + 1, productList::get));
        System.out.println("Product catalog received from ExtraFoodShop.");
        return productCatalog;
    }
}
