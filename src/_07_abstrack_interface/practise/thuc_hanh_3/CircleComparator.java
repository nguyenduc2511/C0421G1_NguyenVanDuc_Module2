package _07_abstrack_interface.practise.thuc_hanh_3;

import _06_inheritance.practise.Circle;

import java.util.Comparator;

public class CircleComparator  implements Comparator<Circle> {
//    sap xep tang dan 1 2 3
    @Override
    public int compare(Circle c1, Circle c2) {
//        if (c1.getRadius() > c2.getRadius()) return 1;
//        else if (c1.getRadius() < c2.getRadius()) return -1;
//        else return 0;
//        return c1.getRadius() > c2.getRadius() ? 1 : -1;

        return (int) (c1.getRadius() - c2.getRadius());
    }
}
