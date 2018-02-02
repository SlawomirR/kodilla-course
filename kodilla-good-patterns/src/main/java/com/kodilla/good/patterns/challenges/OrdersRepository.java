package com.kodilla.good.patterns.challenges;

class OrdersRepository implements OrdersRepositoryInterface {
    @Override
    public ProductOrderDto reserveArtifacts(ProductOrderDto productOrderDto) {
        System.out.println("ReserveArtifacts");
        return productOrderDto;
    }

    @Override
    public ProductOrderDto checkInStock(ProductOrderDto productOrderDto) {
        System.out.println("CheckInStock");
        return productOrderDto;
    }

    @Override
    public ProductOrderDto returnToStock(ProductOrderDto productOrderDto) {
        System.out.println("ReturnToStock");
        return productOrderDto;
    }
}
