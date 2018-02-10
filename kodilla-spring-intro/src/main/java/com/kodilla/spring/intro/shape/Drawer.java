package com.kodilla.spring.intro.shape;

public class Drawer {
    final Shape shape;

    public Drawer(Shape shape) {
        this.shape = shape;
    }

    public String doDrawing() {
        return shape.draw();

/*
        Circle circle = new Circle();
        Triangle triangle = new Triangle();

        circle.draw();
        triangle.draw();
*/
/*
        Figure figure;

        figure = new Circle();
        figure.draw();

        figure = new Triangle();
        figure.draw();
*/
/*
        Shape shape;

        shape = new Circle();
        shape.draw();

        shape = new Triangle();
        shape.draw();
*/
    }
}
