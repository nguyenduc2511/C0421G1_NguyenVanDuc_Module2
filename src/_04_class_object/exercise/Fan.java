package _04_class_object.exercise;

import java.util.Scanner;

public class Fan {
    static Scanner sc = new Scanner(System.in);

    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public Fan() {
    }

    public Fan(final int newSpeed, boolean newOn, double newRadius, String newColor) {
        this.speed = newSpeed;
        this.on = newOn;
        this.radius = newRadius;
        this.color = newColor;
    }

    void setSpeed(int speed) {

        this.speed = speed;
    }

    int getSpeed() {

        return this.speed;
    }

    boolean turnOn() {
        on = true;
        System.out.println("Turned ON the fan");
        return on;
    }

    boolean turnOff() {
        on = false;
        System.out.println("Turned OFF the fan");
        return on;
    }

    void setRadius(double radius) {
        this.radius = radius;
    }

    double getRadius() {
        return this.radius;
    }

    void setColor(String color) {
        this.color = color;
    }

    String getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        if (this.on) {
            return "Fan {" + "Speed = " + speed + "\t Color = " + color + "\t Radius = " + radius + "\t Fan is ON" + "}";
        } else {
            return "Fan {" + "Color = " + color + "\t Radius = " + radius + "\t Fan is OFF" + "}";
        }
    }

    public static void main(String[] args) {

        System.out.println(new _04_class_object.exercise.Fan().toString());
        //khởi tạo đối tượng Fan 1:
        System.out.println("\n Fan 1: ");

        _04_class_object.exercise.Fan fan1;
        fan1 = new _04_class_object.exercise.Fan(_04_class_object.exercise.Fan.FAST, true, 10, "yellow");
        System.out.println(fan1.toString());
        fan1.turnOff();
        System.out.println(fan1.toString());

        //khởi tạo đối tượng fan 2:
        System.out.println("\n Fan 2:");
        _04_class_object.exercise.Fan fan2 = new _04_class_object.exercise.Fan(_04_class_object.exercise.Fan.MEDIUM, false, 5, "blue");
        System.out.println(fan2.toString());
        fan2.setColor("pink");
        System.out.println("Color = " + fan2.getColor());
        fan2.setRadius(20);
        System.out.println("Radius = " + fan2.getRadius());
        fan2.setSpeed(_04_class_object.exercise.Fan.FAST);
        System.out.println("Speed = " + fan2.getSpeed());
        fan2.turnOn();
        System.out.println(fan2.toString());
    }
}
