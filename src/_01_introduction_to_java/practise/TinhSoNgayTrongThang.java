package _01_introduction_to_java.practise;

import java.util.Scanner;

public class TinhSoNgayTrongThang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your month: ");
        int month = input.nextInt();
        switch (month){
            case 2:
                System.out.println(" month 2 has 28 or 29 day");
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println(" month "+ month +" has 31 day");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("month "+ month+ " has 30 day");
                break;
            default:
                System.out.println("Invalid input!");
                break;
        }
    }
}
