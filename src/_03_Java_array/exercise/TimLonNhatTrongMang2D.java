package _03_Java_array.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TimLonNhatTrongMang2D {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[2][4];
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[i].length; j++){
                System.out.println("nhap gia tri vao mang tai vi tri : [" + i+"][" + j+"]");
                arr[i][j] = input.nextInt();
            }
        }
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                System.out.print(arr[row][column] + " ");
            }
            System.out.println();
        }
        MaxMang2D(arr);
    }

    public static void MaxMang2D(int[][] array) {
        int max = array[0][0];
        int row = 0, col = 0;
        for (byte i = 0; i < array.length; i++) {
            for (byte j = 1; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        System.out.println("gia tri lon nhat trong mang 2 chieu la " + max);
        System.out.println(" tai vi tri [" + row + "][" + col + "]");
    }
}
