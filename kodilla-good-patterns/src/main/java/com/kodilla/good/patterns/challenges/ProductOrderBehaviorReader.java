package com.kodilla.good.patterns.challenges;

class ProductOrderBehaviorReader implements ProductOrderBehaviorReaderInterface {
    @Override
    public ProductOrderDto process(ProductOrderDto productOrderDto) {
        System.out.println("Read and set User preferences.");
        productOrderDto.setUserWantAccount(false);
        productOrderDto.setUserWantNotification(true);
        return productOrderDto;
    }
}
