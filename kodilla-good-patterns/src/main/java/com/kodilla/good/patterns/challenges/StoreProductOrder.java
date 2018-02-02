package com.kodilla.good.patterns.challenges;

class StoreProductOrder implements StoreProductOrderInterface {
    @Override
    public ProductOrderDto process(ProductOrderDto productOrderDto) {
        return productOrderDto;
    }
}
