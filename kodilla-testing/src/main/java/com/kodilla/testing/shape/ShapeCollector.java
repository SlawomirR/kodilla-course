package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {
    private ArrayList<Shape> shapeCollector;

    int getShapeCollectorSize() {
        return shapeCollector.size();
    }

    ShapeCollector() {
        shapeCollector = new ArrayList<>();
    }

    void addFigure(Shape shape) {
        shapeCollector.add(shape);
    }

    boolean removeFigure(Shape shape) {
        if ( ! shapeCollector.contains(shape)) {
            return false;
        } else {
            shapeCollector.remove(shape);
            return true;
        }
//        return true;
    }

    Shape getFigure(int index) {
        return shapeCollector.get(index);
//        return null;
    }

    String showFigures() {
        if (shapeCollector.size() == 0) {
            return "The stack of shapes is empty!";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Shape temp: shapeCollector) {
            stringBuilder.append(temp);
        }
        return stringBuilder.toString();
//        return null;
    }
}
