package com.kodilla.good.patterns.challenges;

class DeleteProductOrder implements DeleteProductOrderInterface {
    @Override
    public ProductOrderDto process(ProductOrderDto productOrderDto) {
        return productOrderDto;
    }
}
