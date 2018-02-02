package com.kodilla.good.patterns.challenges;

class CheckProductOrderExistence implements CheckProductOrderExistenceInterface {
    @Override
    public ProductOrderDto process(ProductOrderDto productOrderDto) {
        System.out.println("User NOT exist.");
        productOrderDto.setUserExist(false);
        return productOrderDto;
    }
}
