package com.kodilla.good.patterns.carRentalService;

import java.time.LocalDateTime;

public class CarRentalService implements RentalService {
    public boolean rent(final User user, final LocalDateTime carRentFrom, final LocalDateTime carRentTo) {
        System.out.println("Renting car for: " + user.getName() + user.getSurname() + " from: "
                + carRentFrom.toString() + " to: " + carRentTo.toString());

        MailService mailService = new MailService();
        mailService.sendEmail(user);

        CarRentalRepository carRentalRepository = new CarRentalRepository();
        carRentalRepository.createCarRental(user, carRentFrom, carRentTo);

        return true;
    }
}
