package _07_abstrack_interface.practise.thuc_hanh_3;

import _06_inheritance.practise.Circle;

import java.util.Comparator;

public class CircleComparator2 implements Comparator<Circle> {

    //giam dan 3 2 1
//        chưa sắp xếp được giảm dần nếu cùng số nguyên vd: 3.6  3.5
//        int chỉ lấy phần nguyên so sánh
    @Override
//    public int compare(Circle o1, Circle o2) {
//        if(o2.getRadius()/1 != o1.getRadius()/1){
//            return (int) (o2.getRadius() - o1.getRadius());}
//        else {
//            return (int) ((o2.getRadius()-Math.floor(o2.getRadius()))*10 - (o1.getRadius()-Math.floor(o1.getRadius()))*10);}
//
//    }
    public int compare(Circle c1, Circle c2) {
        if (c1.getRadius() < c2.getRadius()) return 1;
        else if (c1.getRadius() > c2.getRadius()) return -1;
        else return 0;

    }
}

