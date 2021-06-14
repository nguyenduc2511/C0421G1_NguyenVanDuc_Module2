package bai_tap_them.Array;

import java.util.Arrays;
import java.util.Scanner;

public class bai1 {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("nhap do dai cua mang");
        int a = Integer.parseInt(input.nextLine());
        String styles[] = new String[a];
        styles[0] = "Jazz";
        styles[3] = "Blues";
        styles[styles.length - 1] = "Rock-n-Roll";

        System.out.println(Arrays.toString(styles));

        while (true) {
            displayMenu();
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
//                    hien thi mang khong co null
                    showArray(styles);
                    break;
                case 2:
//                    them ten vao giua mang
                    midArray(styles);
                    break;
                case 3:
//                    them ten vao vi tri bat ki
                    System.out.println("nhap vi tri ban muon them gia tri");
                    int index = Integer.parseInt(input.nextLine());
                    System.out.println(" nhap ten ban muon them vao vi tri " + index);
                    String value = input.nextLine();
                    addNewValue(styles, value, index);
                    break;
                case 4:
//                    xoa ten
                    deleteValue(styles);
                    break;
                case 5:
//                    sua ten
                    editValue(styles);
                    break;
                case 6:
                    System.out.println(Arrays.toString(styles));
                    break;
                case 7:
                    System.out.println("da thoat chuong trinh ");
                    System.exit(0);
                default:
                    System.out.println("moi ban nhap lai");
            }
        }
    }

    public static void displayMenu() {
        System.out.println("1. hien thi mang chi co gia tri");
        System.out.println("2. them ten vao giua mang");
        System.out.println("3. them ten vao vi tri bat ki trong mang");
        System.out.println("4. xoa ten tai vi tri bat ki");
        System.out.println("5. sua ten ");
        System.out.println("6. hien thi mang day du ");
        System.out.println("7. thoat");
        System.out.println(" moi ban chon so ");
    }

    public static void showArray(String[] array) {
//        hien thi mang
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                System.out.print(array[i] + " , ");
            }
        }
        System.out.println("]");
    }

    public static void addNewValue(String[] array, String value, int index) {
        int ind = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                ind = i;
                break;
            }
        }
        if (index >= 0 && index < array.length) {
            if (array[ind] == null) {
                if (ind > index) {
                    for (int i = ind; i > index; i--) {
                        array[i] = array[i - 1];
                    }
                    array[index] = value;
                } else if (ind < index) {
                    for (int i = ind; i < index; i++) {
                        array[i] = array[i + 1];
                    }
                    array[index] = value;
                } else {
                    array[index] = value;
                }
            } else {
                System.out.println("mang da full ten; khong the them moi ");
            }
        } else {
            System.out.println(" vi tri nam ngoai mang ");
        }
    }

    public static void midArray(String[] array) {
        System.out.println(" nhap ten ban muon them vao gia mang ");
        String value = input.nextLine();
        if (array.length % 2 == 0) {
            System.out.println(" mang co do dai la so chan khong the them gia tri vao giua mang");
        } else if (array[array.length / 2] == null) {
            array[array.length / 2] = value;
        } else {
            addNewValue(array, value, array.length / 2);
        }
    }

    public static void deleteValue(String[] array) {
        System.out.println(" nhap ten ban muon xoa");
        String value = input.nextLine();
        for (int i = 0; i < array.length; i++) {
            if (value.equals(array[i])) {
                array[i] = null;
            }
        }
    }

    public static void editValue(String[] array) {
        System.out.println(" nhap ten ban muon sua :");
        String value = input.nextLine();
        System.out.println(" ban mua sua ten " + value + " thanh : ");
        String value2 = input.nextLine();
        boolean check = false;
        int ind = 0;
        for (int i = 0; i < array.length; i++) {
            if (value.equals(array[i])) {
                check = true;
                ind = i;
            }
        }
        if (check) {
            array[ind] = value2;
        } else {
            System.out.println(" khong co ten nay trong mang ");
        }
    }
}

