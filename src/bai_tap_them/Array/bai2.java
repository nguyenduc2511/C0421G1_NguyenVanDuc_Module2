package bai_tap_them.Array;

import java.util.Arrays;
import java.util.Scanner;

public class bai2 {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            System.out.println(" nhap gia tri vao vi tri "+ i);
            arr[i]= input.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        int sumArr = sumArray(arr);
        System.out.println("tong cac gia tri trong mang = "+sumArr);

        System.out.println("so nguyen to co trong mang = "+ pimeNumber(arr));

        System.out.println(negativeInteger(arr));
    }

    public static int sumArray(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static int pimeNumber(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 2; j < array[i]; j++) {
                if (array[i] % j == 0) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    public static boolean negativeInteger(int[] array){
        boolean check = false;
        for (int i = 0; i < array.length; i++) {
            if(array[i]<0){
                check = true;
            }
        }
        return check;
    }

}
