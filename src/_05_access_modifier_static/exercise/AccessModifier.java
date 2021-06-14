package _05_access_modifier_static.exercise;

public class AccessModifier {
    private double radius = 1.0;
    private String color = "red";

    public AccessModifier() {
    }
    public AccessModifier(double r){
        this.radius = r;
    }
    public double getRadius() {

        return radius;
    }

    public double getArea() {

        return Math.pow(this.radius,2)*Math.PI;
    }

    public static void main(String[] args) {
        AccessModifier circle = new AccessModifier(5);
        System.out.println(circle.getArea());
        System.out.println(circle.getRadius());
    }
}
