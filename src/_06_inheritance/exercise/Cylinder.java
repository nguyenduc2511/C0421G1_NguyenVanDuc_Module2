package _06_inheritance.exercise;

public class Cylinder extends Circle {
    private double height;
    public Cylinder(){}
    public Cylinder(double height){
        this.height=height;
    }
    public Cylinder(double radius,String color, double height){
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume() {   // thể tích V = (π. r2)dientichhinhtron. h

        return super.getArea()*this.height;
    }
    public double getAroundArea() {   //S xung quanh hinh tru = 2. Π.R.H

        return super.getPerimeter()*this.height;
    }
    public double getBaseArea() {   //S 2 mat day = 2.Π.R2

        return super.getArea()*2;
    }
    public double getWholeArea() {   //S =  S_2day + S_xq

        return this.getAroundArea()+this.getBaseArea();
    }

    @Override
    public String toString() {
        return "Cylinder{" +
//                super.toString()+
                "radius=" + super.getRadius() +
                ", color='" + super.getColor() + '\'' +
                ", height=" + height +
                '}';
    }

    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(5);
        System.out.println(cylinder.toString());
        System.out.println("the tich = " + cylinder.getVolume());
        System.out.println("dien tich xung quanh = " + cylinder.getAroundArea());
        System.out.println("ien tich 2 mat day = " + cylinder.getBaseArea());
        System.out.println("dien tich hinh tru = " + cylinder.getWholeArea());

        Cylinder cylinder2 = new Cylinder(5,"hot pink",5);
        System.out.println(cylinder2.toString());
        System.out.println("the tich = " + cylinder2.getVolume());
        System.out.println("dien tich xung quanh = " + cylinder2.getAroundArea());
        System.out.println("dien tich 2 mat day = " + cylinder2.getBaseArea());
        System.out.println("dien tich hinh tru = " + cylinder2.getWholeArea());
    }
}
