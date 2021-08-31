package module2._31_8_test;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số dòng của mảng: ");
       int soDong = scanner.nextInt();
        System.out.println("Nhập vào số cột của mảng: ");
        int soCot = scanner.nextInt();
        int[][] a = new int[soDong][soCot];
        for (int i = 0; i < soDong; i++) {
            for (int j = 0; j < soCot; j++) {
                System.out.print("Nhập phần tử thứ [" + i + ", " + j + "]: ");
                a[i][j] = scanner.nextInt();
            }
        }
        int[] b = new int[soDong];
        for(int i =0;i<soDong;i++){
            for (int j = 0; j < soCot-1; j++) {
                if(a[i][j] < a[i][j+1]){
                    b[i]=a[i][j+1];
                }
            }
        }
        System.out.println(Arrays.toString(b));
    }
}
