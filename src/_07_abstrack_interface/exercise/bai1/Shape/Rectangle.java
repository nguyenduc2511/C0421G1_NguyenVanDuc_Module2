package _07_abstrack_interface.exercise.bai1.Shape;

import _07_abstrack_interface.exercise.bai1.Resizeable;

public class Rectangle extends Shape implements Resizeable {
    double width;
    double height;
    public Rectangle(double width, double height){
        this.width = width;
        this.height =  height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    @Override
    public String getArea() {
        return "area rectangle = "+this.height * this.width;
    }

    @Override
    public void resize(double percent) {
        this.width += (percent / 100) * this.width;
        this.height += (percent / 100) * this.height;
    }
}
