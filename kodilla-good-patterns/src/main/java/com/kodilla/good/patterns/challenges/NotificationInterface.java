package com.kodilla.good.patterns.challenges;

interface NotificationInterface {
    ProductOrderDto sendEmail(ProductOrderDto productOrderDto);
    ProductOrderDto sendSMS(ProductOrderDto productOrderDto);
}
