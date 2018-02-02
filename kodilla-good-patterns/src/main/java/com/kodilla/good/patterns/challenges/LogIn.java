package com.kodilla.good.patterns.challenges;

class LogIn implements LogInInterface {
    @Override
    public ProductOrderDto process(ProductOrderDto productOrderDto) {
        System.out.println("Read user identification data.");
        return productOrderDto;
    }
}
