package _01_introduction_to_java.exercise;

import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        double vnd = 23000;
        double usd;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap so tien ");
        usd = sc.nextDouble();
        double quydoi = usd * vnd;
        System.out.println("gia tri quy doi ra VND: " + quydoi);
    }
}
