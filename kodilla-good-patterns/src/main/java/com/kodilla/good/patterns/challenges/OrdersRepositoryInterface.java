package com.kodilla.good.patterns.challenges;

interface OrdersRepositoryInterface {
    ProductOrderDto reserveArtifacts(ProductOrderDto productOrderDto);
    ProductOrderDto checkInStock(ProductOrderDto productOrderDto);
    ProductOrderDto returnToStock(ProductOrderDto productOrderDto);
}
