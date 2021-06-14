package _06_inheritance.exercise;

public class Circle {
    private double radius;
    private String color;

    public Circle() {
    }

    public Circle(double radius, String color) {
        this.color = color;
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return this.radius * this.radius * Math.PI;
    }

    public double getPerimeter() {
        return this.radius * 2 * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Circle myCircle = new Circle(5, "blue");
        System.out.println(myCircle.toString());
        System.out.println(myCircle.getRadius());
        System.out.println(myCircle.getPerimeter());
        System.out.println(myCircle.getArea());
        Circle myCircle2 = new Circle();
        System.out.println(myCircle2.toString());
    }
}
