package _06_inheritance.exercise;

import java.util.Arrays;

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point2D() {
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x, float y) {
        this.setX(x);
        this.setY(y);
    }
    public float[] getXY() {
        float[] getXY = {this.getX(), this.getY()};
        return getXY;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x= " + x +
                ", y= " + y +
                '}';
    }

    public static void main(String[] args) {
        Point2D point2D = new Point2D(3.5f,4.8f);
        System.out.println(point2D.toString());
        point2D.setXY(5.5f,6.9f);
        System.out.println(point2D.toString());
    }
}
