package com.kodilla.exception.test;

class RouteNotFoundException extends Exception {
    RouteNotFoundException(final String message) {
        super(message);
    }
}
