package _03_Java_array.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TimNhoNhatTrongMang {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("nhap do dai mang");
        int size = input.nextInt();
        int[] array= new int[size];
        for(int i = 0;i < array.length;i++) {
            System.out.print("them gia tri vao vi tri " + i + " : ");
            array[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(array));
        SoNhoNhat(array);
    }

    public static void SoNhoNhat(int[] array){
        int min = array[0];
        int index = 0;
        for(int i = 1; i<array.length;i++){
            if(min>array[i]){
                min = array[i];
                index = i;
            }
        }
        System.out.println("gia tri nho nhat la "+ min +"tai vi tri "+ index);
    }

}
