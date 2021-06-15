package _07_abstrack_interface.exercise.bai2;

import _07_abstrack_interface.exercise.bai1.Shape.Shape;
import _07_abstrack_interface.exercise.bai1.Shape.Square;

public class TestSquare {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Square(3);
        shapes[1] = new Square(5);
        shapes[2] = new Square(7);
        for (Shape element : shapes) {
            ((Colorable) element).howToColor();
        }
    }
}
