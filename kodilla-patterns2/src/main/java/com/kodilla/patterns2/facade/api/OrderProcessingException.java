package com.kodilla.patterns2.facade.api;

public class OrderProcessingException extends Exception {
    public static final String ERR_NOT_AUTHORISED = "User is not authorised.";
    public static final String ERR_PAYMENT_REJECTED = "Payment was rejected.";
    public static final String ERR_VERIFICATION_ERROR = "Verification error.";
    public static final String ERR_SUBMITTING_ERROR = "Cannot submit order.";

    public OrderProcessingException(String message) {
        super(message);
    }
}
