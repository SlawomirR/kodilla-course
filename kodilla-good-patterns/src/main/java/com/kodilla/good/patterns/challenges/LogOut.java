package com.kodilla.good.patterns.challenges;

class LogOut implements LogOutInterface {
    @Override
    public ProductOrderDto process(ProductOrderDto productOrderDto) {
        return productOrderDto;
    }
}
