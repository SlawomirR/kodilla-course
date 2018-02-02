package com.kodilla.good.patterns.challenges;

class OrdersProcessor implements ProductOrderServiceInterface {
    private ProcessOrderInterface processOrder;
    private OrdersRepositoryInterface ordersRepository;
    private NotificationInterface notification;
    private VerificationInterface verification;

    OrdersProcessor(final ProcessOrderInterface processOrder,
            final OrdersRepositoryInterface ordersRepository,
            final NotificationInterface notification,
            final VerificationInterface verification
    ) {
        this.processOrder = processOrder;
        this.ordersRepository = ordersRepository;
        this.notification = notification;
        this.verification = verification;
    }

    @Override
    public ProductOrderDto process(ProductOrderDto productOrderDto) {
        processOrder.collectToBasket(productOrderDto);
        System.out.println("After collect to basket.");
        ordersRepository.checkInStock(productOrderDto);
        notification.sendEmail(productOrderDto);
        verification.trackStatusOfTheOrder(productOrderDto);
        return productOrderDto;
    }
}
