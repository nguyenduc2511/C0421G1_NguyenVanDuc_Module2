package test;

import java.util.Arrays;
import java.util.Scanner;

public class GopMang {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int i;
        System.out.println("nhap do dai mang1 ");
        int size1 = scanner.nextInt();
        System.out.println("nhap do dai mang 2");
        int size2 = scanner.nextInt();
        int size3 = size1 + size2;
        int[] arr1 = new int[size1];
        int[] arr2 = new int[size2];
        int[] arr3 = new int[size3];
        for (i = 0; i < arr1.length; i++) {
            System.out.println("nhap phan tu mang 1");
            arr1[i] = scanner.nextInt();
            arr3[i] = arr1[i];
        }
        for (i = 0; i < arr2.length; i++) {
            System.out.println("nhap phan tu mang 2");
            arr2[i] = scanner.nextInt();
            arr3[arr1.length + i] = arr2[i];
        }
        for (i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i]);
        }

    }
}
