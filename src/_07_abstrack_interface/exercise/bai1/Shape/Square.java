package _07_abstrack_interface.exercise.bai1.Shape;

import _07_abstrack_interface.exercise.bai1.Resizeable;
import _07_abstrack_interface.exercise.bai2.Colorable;

public class Square extends Shape implements Resizeable, Colorable {
    double size;

    public Square(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Square{" +
                "size=" + size +
                '}';
    }

    @Override
    public void howToColor() {
        System.out.println(" fill full " + getArea());
    }

    @Override
    public String getArea() {
        return "Square area = " +this.size*this.size;
    }

    @Override
    public void resize(double percent) {
        this.size+=(percent / 100) * this.size;
    }
}
