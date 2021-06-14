package _07_abstrack_interface.practise.thuc_hanh_2;

import _06_inheritance.practise.Circle;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle>{
    public ComparableCircle(){}
    public ComparableCircle(double radius) {

        super(radius);
    }

    public ComparableCircle(String color, boolean filled, double radius) {
        super(color, filled, radius);
    }
    @Override
    public int compareTo(ComparableCircle o) {
        if (super.getRadius() > o.getRadius()) {
            return 1;
        } else if (super.getRadius() < o.getRadius()) {
            return -1;
        } else {
            return 0;
        }
    }
}
