package com.kodilla.good.patterns.food2Door;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductsRetriever {
    public static List<SupplierProduct> retrieve() {

        List<SupplierProduct> productList = new ArrayList<>();
        SupplierProductListBuilder productListBuilder = SupplierProductListBuilder.aSupplierProduct();

        productListBuilder.withSupplierID("a000178");
        productListBuilder.withProductID("sea513");
        productListBuilder.withProductDesc("small food product");
        productListBuilder.withUsedUnit("pcs");
        productListBuilder.withProductPrice(new BigDecimal("1.18"));
        productListBuilder.withProductQuantity(1000);

        productList.add(productListBuilder.buildList());

        productListBuilder.withSupplierID("fruit0179");
        productListBuilder.withProductID("fru786");
        productListBuilder.withProductDesc("heavy food product");
        productListBuilder.withUsedUnit("kg");
        productListBuilder.withProductPrice(new BigDecimal("3.42"));
        productListBuilder.withProductQuantity(67);

        productList.add(productListBuilder.buildList());

        return productList;
    }
}
