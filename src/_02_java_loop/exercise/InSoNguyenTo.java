package _02_java_loop.exercise;

import java.util.Scanner;

public class InSoNguyenTo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("ban muon in bao nhieu so nguyen to: ");
        int num = input.nextInt();
        int run = 2;
        int number = 0;
        while (true){
            boolean check = true;
            for (int i = 2; i < run; i++) {
                if (run % i == 0) {
                    check=false;
                    break;
                }
            }
            if (check) {
                System.out.println(run);
                number++;
            }
            if (number == num) {
                break;
            }
            run++;
        }
    }

}
