package _04_class_object.exercise;

import java.util.Scanner;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;
    public QuadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public void getter(){
        System.out.println("Phương trình có dạng: "+ a + " x^2 + " + b +" x +" + c +" = 0");
    }
    public double getDiscriminant(){
        double delta = Math.pow(b,2) - (4*a*c);
        return delta;
    }
    public String getRoot(){
        double rootOne , rootTwo;
        if (this.getDiscriminant()>0){
            rootOne = (-b - Math.sqrt(this.getDiscriminant()))/(2*a);
            rootTwo =(-b + Math.sqrt(this.getDiscriminant()))/(2*a);
            return "Nghiệm của 2 phương trình lần lượt là: "+ rootOne + "; " + rootTwo;
        }else if (this.getDiscriminant() ==0){
            return "Phương trình có 1 nghiệm: "+ (-b/2*a);
        } else {
            return "Phương trình vô nghiệm";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập hệ số a:");
        double a = scanner.nextDouble();
        System.out.println("Nhập hệ số b:");
        double b = scanner.nextDouble();
        System.out.println("Nhập hệ số c:");
        double c = scanner.nextDouble();
        QuadraticEquation newObject = new QuadraticEquation(a,b,c);
        newObject.getter();
        System.out.println(newObject.getRoot());
    }
}
