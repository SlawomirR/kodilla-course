package com.kodilla.good.patterns.challenges;

public class ApplicationProductOrderService {
    public static void main(String[] args) {
        ProductOrderDto productOrderDto = new ProductOrderDto();
        UsersProcessor usersProcessor = new UsersProcessor();
        OrdersProcessor ordersProcessor = new OrdersProcessor(
                new ProcessOrder(usersProcessor.process(productOrderDto)),
                new OrdersRepository(),
                new Notification(),
                new Verification()
        );
        ordersProcessor.process(productOrderDto);
    }
}
