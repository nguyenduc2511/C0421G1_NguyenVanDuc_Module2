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
            System.out.print("Enter element " + (i + 1) + " : ");
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
//        for (int l = 0; l < array.length; l++) {
//                if (array[l] == number) {
//                    check = true;
//                    array[l]=0;
//                    for (int j = l; j < array.length - 1; j++) {
//                        array[j] = array[j + 1];
//                        array[j + 1] = 0;
//                    }
//                l--;
//                }
//        }
//        if (check) {
//            System.out.println("mang sau khi xoa : ");
//            System.out.println(Arrays.toString(array));
//        } else {
//            System.out.println(" khong co gia tri " + number + " trong mang");
//        }
                DeleteValue(array, number);

    }



    public static void DeleteValue(int[] array, int valuve) {
        boolean check = false;
        for (int i = 0; i < array.length; i++) {
            while (true) {
                if (array[i] == valuve) {
                    check = true;
                    array[i]=0;
                    for (int j = i; j < array.length - 1; j++) {
                        array[j] = array[j + 1];
                        array[j + 1] = 0;
                    }
                } else {
                    break;
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
