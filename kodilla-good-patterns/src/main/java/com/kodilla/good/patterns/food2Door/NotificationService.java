package com.kodilla.good.patterns.food2Door;

public class NotificationService implements InformationService {

    @Override
    public void systemNotifier(boolean orderStatus) {
        if (orderStatus) {
            System.out.println("Order placed.");
        } else {
            System.out.println("Order rejected or could not be sent.");
        }
    }

    @Override
    public void receivingStatusNotifier(boolean receiveStatus) {
        if (receiveStatus) {
            System.out.println("New products added to catalog. All information updated.");
        } else {
            System.out.println("Update products information failed.");
        }
    }
}
