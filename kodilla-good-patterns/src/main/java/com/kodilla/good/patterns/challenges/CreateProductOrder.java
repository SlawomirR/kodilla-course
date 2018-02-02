package com.kodilla.good.patterns.challenges;

class CreateProductOrder implements CreateProductOrderInterface {
    @Override
    public ProductOrderDto process(ProductOrderDto productOrderDto) {
        productOrderDto.setUser(new User("John", "O`Connor"));
        productOrderDto.setAutoOrderId();
        System.out.println("New user created: " + productOrderDto.getUser());
        return productOrderDto;
    }
}
