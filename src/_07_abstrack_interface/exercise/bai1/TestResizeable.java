package _07_abstrack_interface.exercise.bai1;

import _07_abstrack_interface.exercise.bai1.Shape.Circle;
import _07_abstrack_interface.exercise.bai1.Shape.Rectangle;
import _07_abstrack_interface.exercise.bai1.Shape.Shape;
import _07_abstrack_interface.exercise.bai1.Shape.Square;

public class TestResizeable {
    public static void main(String[] args) {
        Shape[] shape = new Shape[3];
        shape[0] = new Circle(5);
        shape[1] = new Rectangle(5,10);
        shape[2] = new Square(10);

        System.out.println("truoc khi tang size ");
        for (Shape element : shape) {
            System.out.println(element.toString());
        }
        System.out.println(" tang size random ... ");
        for (int i = 0; i < shape.length; i++) {
            shape[i].resize(Math.floor(Math.random() * 100 + 1));
        }
        System.out.println("sau khi tang :");
        for (Shape element : shape) {
            System.out.println(element.toString());
        }
    }
}
