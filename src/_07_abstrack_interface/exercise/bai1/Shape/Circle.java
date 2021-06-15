package _07_abstrack_interface.exercise.bai1.Shape;

import _07_abstrack_interface.exercise.bai1.Resizeable;

public class Circle extends Shape implements Resizeable {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public String getArea() {

        return "Circle Area = " + this.radius * this.radius * Math.PI;
    }

    @Override
    public void resize(double percent) {
        this.radius += (percent / 100) * this.radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                " radius= " + radius +
                '}';
    }
}