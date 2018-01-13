package com.kodilla.testing.shape;

import java.util.Objects;

public class Circle implements Shape {
    private double radiusR;

    public double getRadiusR() {
        return radiusR;
    }

    Circle(double radiusR) {
        this.radiusR = radiusR;
    }

    @Override
    public double getField() {
        return Shape.PI * getRadiusR() * getRadiusR();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radiusR, radiusR) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(radiusR);
    }
}
