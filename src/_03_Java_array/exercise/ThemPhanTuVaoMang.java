package _03_Java_array.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] array= new int[3];
        System.out.println(Arrays.toString(array));
        while (true) {
            System.out.println("1. xem gia tri mang ");
            System.out.println("2. them gia tri vao mang ");
            System.out.println("3. thoat khoi chuong trinh");
            System.out.println("chon chuc nang su dung: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(Arrays.toString(array));
                    break;
                case 2:
                System.out.println(" vi tri ban muon them ");
                int index = input.nextInt();
                System.out.println("gia tri ban muon them vao tai vi tri " + index);
                int number = input.nextInt();
                if(array[array.length-1]==0) {
                    if (index < array.length && index >= 0) {
                        ThemPhanTu(array, number, index);
                    } else {
                        System.out.println("vi tri nam ngoai mang");
                    }
                }else {
                    System.out.println("mang full gia tri khong the them ");
                }
                break;
                case 3:
                    System.exit(0);
            }
        }
    }

    public static void ThemPhanTu(int[] array,int value,int index) {
        for(int i=array.length-2;i>= index;i--){
            array[i+1]=array[i];
        }
        array[index]=value;
        System.out.println("mang sau khi them ");
        System.out.println(Arrays.toString(array));
    }
}
