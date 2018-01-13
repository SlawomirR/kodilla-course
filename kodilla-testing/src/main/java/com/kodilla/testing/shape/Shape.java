package com.kodilla.testing.shape;

public interface Shape {
    double PI = 3.14;

    double getField();

    default String getShapeName() {
        return getClass().getSimpleName().toLowerCase();
    }
}
