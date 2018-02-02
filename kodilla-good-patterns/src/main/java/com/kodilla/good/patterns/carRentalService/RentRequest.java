package com.kodilla.good.patterns.carRentalService;

import java.time.LocalDateTime;

public class RentRequest {
    public User user;
    public LocalDateTime from;
    public LocalDateTime to;

    public RentRequest(final User user, final LocalDateTime from, final LocalDateTime to) {
        this.user = user;
        this.from = from;
        this.to = to;
    }

    public User getUser() {
        return user;
    }
    public LocalDateTime getFrom() {
        return from;
    }
    public LocalDateTime getTo() {
        return to;
    }
}
