package _03_Java_array.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ThemPhanTuVaoMang2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array = new int[10];
        System.out.println(Arrays.toString(array));
        System.out.println("nhap do dai mang ban muon nhap");
        int a = input.nextInt();
        if (a > array.length) {
            System.out.println("vuot qua do dai cua mang ");
        } else {
            for (int i = 0; i < a; i++) {
                System.out.println(" nhap gia trị tai vi tri " + i);
                array[i] = input.nextInt();
            }
            while (true) {
                System.out.println(" vi tri ban muon them ");
                int index = input.nextInt();
                System.out.println("gia tri ban muon them vao tai vi tri " + index);
                int number = input.nextInt();
                if (array[array.length - 1] == 0) {
                    if (index < array.length && index >= 0) {
                        ThemPhanTu(array, number, index);
                    } else {
                        System.out.println("vi tri nam ngoai mang");
                        break;
                    }
                } else {
                    System.out.println("mang full gia tri khong the them ");
                    break;
                }
            }
        }
    }

    public static void ThemPhanTu(int[] array, int value, int index) {
        for (int i = array.length - 2; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = value;
        System.out.println("mang sau khi them ");
        System.out.println(Arrays.toString(array));
    }
}
