package com.kodilla.good.patterns.challenges;

interface ProcessOrderInterface {
    ProductOrderDto collectToBasket(ProductOrderDto productOrderDto);
    ProductOrderDto createOrder(ProductOrderDto productOrderDto);
    ProductOrderDto cancelOrder(ProductOrderDto productOrderDto);
    ProductOrderDto changeOrder(ProductOrderDto productOrderDto);
    ProductOrderDto reservationOfItems(ProductOrderDto productOrderDto);
    ProductOrderDto confirmationOfTheContractOrder(ProductOrderDto productOrderDto);
}
