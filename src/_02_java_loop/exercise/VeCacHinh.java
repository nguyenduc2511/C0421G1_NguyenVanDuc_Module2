package _02_java_loop.exercise;

import java.util.Scanner;

public class VeCacHinh {
    public static  Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1;
        while(choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Print isosthmbal triangle ");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    HinhChuNhat();
                    break;
                case 2:
                    TamGiacGocvuongTraiDuoi();
                    break;
                case 3:
                    TamGiacGocvuongTraiTren();
                    break;
                case 4:
                    TamGiacCan();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }

    public static void HinhChuNhat() {
//        Scanner input = new Scanner(System.in);
        System.out.println("nhap chieu dai");
        int a = input.nextInt();
        System.out.println("nhap chieu rong");
        int b = input.nextInt();
        for(int i=1;i<=a;i++){
            for (int j=1;j<=b;j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    public static void TamGiacGocvuongTraiDuoi() {
//        Scanner input = new Scanner(System.in);
        System.out.println("nhap chieu cao");
        int h = input.nextInt();
        for(int i=1;i<=h;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
    public static void TamGiacGocvuongTraiTren() {
//        Scanner input = new Scanner(System.in);
        System.out.println("nhap chieu cao");
        int h = input.nextInt();
        for(int i=1;i<=h;i++){
            for(int j=h;j>=i;j--){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    public static void TamGiacCan() {
        System.out.println("nhap chieu cao");
        int h = input.nextInt();
        for( int i=1;i<=h;i++){
            for (int k = h ; k > i; k--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j == i*2-1 || j == 1 || i == h||i==1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("\n");
        }
    }
}

