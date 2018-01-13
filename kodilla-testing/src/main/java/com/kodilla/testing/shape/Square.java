package com.kodilla.testing.shape;

import java.util.Objects;

public class Square implements Shape {
    private double sideA;
    private double sideB;

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    Square(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double getField() {
        return getSideA() * getSideB();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.sideA, sideA) == 0 &&
                Double.compare(square.sideB, sideB) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(sideA, sideB);
    }

    @Override
    public String toString() {
        return "Square{" +
                "sideA=" + getSideA() +
                ", sideB=" + getSideB() +
                "} has area of: " + getField();
    }
}
