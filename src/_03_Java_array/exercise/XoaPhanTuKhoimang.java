package _03_Java_array.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class XoaPhanTuKhoimang {
    public static void main(String[] args) {

        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Size should not exceed 20");
        } while (size > 20);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element" + (i + 1) + " : ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.print("Property list: ");
//        for (int j = 0; j < array.length; j++) {
//            System.out.print(array[j] + "\t");
//        }
        System.out.println(Arrays.toString(array));

        System.out.println("input number want delete");
        int number = scanner.nextInt();

//tim vi tri va xoa phan tu CACH 1:
//        boolean check = false;
//        int index = 0;
//        for (int l = 0; l < array.length; l++) {
//            if (array[l] == number) {
//                index = l;
//                check = true;
//            }
//        }
//        if (check) {
//            for (int j = index; j < array.length - 1; j++) {
//                array[j] = array[j + 1];
//                array[j + 1] = 0;
//            }
//        } else {
//            System.out.println(" khong co gia tri trong mang ");
//        }
////        for (int k = 0; k < array.length; i++) {
////            System.out.print(array[k] + "\t");
////        }
//        System.out.println(Arrays.toString(array));

        DeleteValue(array, number);
    }

    public static void DeleteValue(int[] array, int valuve) {
        boolean check = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valuve) {
                check = true;
                for (int j = i; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                    array[j + 1] = 0;
                }
            }
        }
        if (check) {
            System.out.println("mang sau khi xoa : ");
            System.out.println(Arrays.toString(array));
        } else {
            System.out.println(" khong co gia tri " + valuve + " trong mang");
        }
    }
}
