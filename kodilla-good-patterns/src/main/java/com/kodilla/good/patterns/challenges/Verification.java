package com.kodilla.good.patterns.challenges;

public class Verification implements VerificationInterface {
    @Override
    public void findingDelayedOrders(int daysToRiseAlarm) {
        System.out.println("FindingDelayedOrders");
    }

    @Override
    public void trackStatusOfTheOrder(ProductOrderDto productOrderDto) {
        System.out.println("TrackStatusOfTheOrder: " + productOrderDto.getOrderId());
    }

    @Override
    public void showUserOrdersHistory(User user) {
        System.out.println("ShowUserOrdersHistory");
    }
}
