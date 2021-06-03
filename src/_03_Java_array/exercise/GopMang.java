package _03_Java_array.exercise;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr1= new int[5];
        int[] arr2= new int[5];
        for (int i=0;i<arr1.length;i++){
            System.out.println("nhap gia tri vong mang 1 tai vi tri thu "+ i);
            arr1[i]= input.nextInt();
        }
        for (int i=0;i<arr2.length;i++){
            System.out.println("nhap gia tri vong mang 2 tai vi tri thu "+ i);
            arr2[i]= input.nextInt();
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        int a = arr2.length;
        int[] arr3 = new int[arr1.length+arr2.length];

        for (int i=0;i<arr1.length;i++){
            arr3[i]=arr1[i];
        }
        for (int i=0;i<arr2.length;i++){
            arr3[a]=arr2[i];
            a++;
        }
        System.out.println("mang sau khi gop la ");
        System.out.println(Arrays.toString(arr3));
    }
}
