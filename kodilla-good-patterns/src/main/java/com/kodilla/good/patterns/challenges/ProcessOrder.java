package com.kodilla.good.patterns.challenges;

class ProcessOrder implements ProcessOrderInterface {
    private String orderId;

    ProcessOrder(ProductOrderDto process) {
        this.orderId = process.getOrderId();
    }

    @Override
    public ProductOrderDto collectToBasket(ProductOrderDto productOrderDto) {
        System.out.println("Tell me what you want to buy.");
        Basket basket = new Basket();
        Product item1 = new Product("IT.Hardware.000001", "SSD", "IT.Hardware", 3.14);
        basket.addItem(item1, 2, orderId);
        return productOrderDto;
    }

    @Override
    public ProductOrderDto createOrder(ProductOrderDto productOrderDto) {
        System.out.println("CreateOrder");
        return productOrderDto;
    }

    @Override
    public ProductOrderDto cancelOrder(ProductOrderDto productOrderDto) {
        System.out.println("CancelOrder");
        return productOrderDto;
    }

    @Override
    public ProductOrderDto changeOrder(ProductOrderDto productOrderDto) {
        System.out.println("ChangeOrder");
        return productOrderDto;
    }

    @Override
    public ProductOrderDto reservationOfItems(ProductOrderDto productOrderDto) {
        System.out.println("ReservationOfItems");
        return productOrderDto;
    }

    @Override
    public ProductOrderDto confirmationOfTheContractOrder(ProductOrderDto productOrderDto) {
        System.out.println("ConfirmationOfTheContractOrder");
        return productOrderDto;
    }
}
