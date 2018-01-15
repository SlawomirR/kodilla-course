package com.kodilla.testing.shape;

import java.util.Objects;

public class Triangle implements Shape {
    private double baseWidth;
    private double height;

    public double getBaseWidth() {
        return baseWidth;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getField() {
        return (baseWidth * height) / 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.baseWidth, baseWidth) == 0 &&
                Double.compare(triangle.height, height) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(baseWidth, height);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "baseWidth=" + baseWidth +
                ", height=" + height +
                '}';
    }
}
