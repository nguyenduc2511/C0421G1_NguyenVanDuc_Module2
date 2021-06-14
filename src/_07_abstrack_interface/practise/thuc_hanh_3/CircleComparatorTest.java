package _07_abstrack_interface.practise.thuc_hanh_3;

import _06_inheritance.practise.Circle;

import java.util.Arrays;
import java.util.Comparator;

public class CircleComparatorTest {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(3.7);
        circles[1] = new Circle();
        circles[2] = new Circle("indigo",false , 3.2);

        System.out.println("Pre-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }

        Comparator circleComparator = new CircleComparator();
        Arrays.sort(circles, circleComparator);

        System.out.println("After-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }

        Comparator circleComparator2 = new CircleComparator2();
        Arrays.sort(circles, circleComparator2);

        System.out.println("After-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }

    }
}
