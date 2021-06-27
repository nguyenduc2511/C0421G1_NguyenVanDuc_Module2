package _15_exception_debug.exercise;

import java.util.Scanner;

public class Triangle {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean check = false;
        double a = 0;
        double b = 0;
        double c = 0;
        while (!check) {
            try {
                System.out.print("a: ");
                a = exceptionCheck();
                System.out.print("b: ");
                b = exceptionCheck();
                System.out.print("c: ");
                c = exceptionCheck();
                Triangle triangle = new Triangle(a,b,c);
                    check = true;
            } catch (IllegalTriangleException ex) {
                System.out.println(ex.getMessage());
            }
        }
        double sum = a + b + c;
        System.out.println(" chu vi tam giac = " + sum);
    }

    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) throws IllegalTriangleException {
        this.a = a;
        this.b = b;
        this.c = c;
        if (((a + b) < c) || ((a + c) < b) || ((c + b) < a)) {
            throw new IllegalTriangleException("");
        }
    }

    static double exceptionCheck() {
        double a = 0;
        boolean check = false;
        while (!check) {
            try {
                a = Double.parseDouble(scanner.nextLine());
                if (a <= 0) {
                    throw new NegativeNumberException("");
                }
                check = true;
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage() + " nhap vao la so vui long nhap lai ");
            } catch (NegativeNumberException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return a;
    }
}
