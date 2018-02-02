package com.kodilla.good.patterns.challenges;

class Notification implements NotificationInterface {
    @Override
    public ProductOrderDto sendEmail(ProductOrderDto productOrderDto) {
        System.out.println("Email sent.");
        return productOrderDto;
    }

    @Override
    public ProductOrderDto sendSMS(ProductOrderDto productOrderDto) {
        System.out.println("SMS sent.");
        return productOrderDto;
    }
}
