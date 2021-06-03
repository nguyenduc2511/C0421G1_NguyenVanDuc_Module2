package _01_introduction_to_java.exercise;

import java.util.Scanner;

public class _02_doc_so_thanh_chu {
    public static void main(String[] args) {
        int number;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your number: ");
        number = input.nextInt();
        int hangTram = number / 100;
        int hangChuc = (number - hangTram * 100) / 10;
        int hangDonVi = (number - hangTram * 100 - hangChuc * 10);

        if (number < 0 || number > 1000) {
            System.out.println("vuot qua gioi han");
        }
        if (number <= 10) {
            soHangDonVi(number);
        }
        if (number < 20) {
            soDacBiet(number);
        }
        if (number >= 20 && number < 1000) {
            soHangTram(hangTram);
            if (hangChuc == 1) {
                soDacBiet((number - hangTram * 100));
            } else {
                soHangChuc(hangChuc);
                soHangDonVi(hangDonVi);
            }
        }
    }

    public static void soHangDonVi(int number) {
        switch (number) {
            case 1:
                System.out.print("one");
                break;
            case 2:
                System.out.print("two");
                break;
            case 3:
                System.out.print("three");
                break;
            case 4:
                System.out.print("four");
                break;
            case 5:
                System.out.print("five");
                break;
            case 6:
                System.out.print("six");
                break;
            case 7:
                System.out.print("seven");
                break;
            case 8:
                System.out.print("eight");
                break;
            case 9:
                System.out.print("nine");
                break;
            case 10:
                System.out.print("ten");
                break;
        }
    }

    public static void soDacBiet(int number) {
        switch (number) {
            case 11:
                System.out.print("eleven ");
                break;
            case 12:
                System.out.print("twelve ");
                break;
            case 13:
                System.out.print("thirteen ");
                break;
            case 14:
                System.out.print("fourteen");
                break;
            case 15:
                System.out.print("fifteen ");
                break;
            case 16:
                System.out.print("sixteen ");
                break;
            case 17:
                System.out.print("seventeen");
                break;
            case 18:
                System.out.print("eighteen");
                break;
            case 19:
                System.out.print("nineteen");
                break;
        }
    }

    public static void soHangChuc(int number) {
        String word="";
        switch (number) {
            case 2:
                word="twenty ";
                break;
            case 3:
                word="thirty ";
                break;
            case 4:
                word="forty ";
                break;
            case 5:
                word="fifty ";
                break;
            case 6:
                word="sixty ";
                break;
            case 7:
                word="seventy ";
                break;
            case 8:
                word="eighty ";
                break;
            case 9:
                word="ninety ";
                break;
        }
        System.out.print(word);
    }

    public static void soHangTram(int number) {
        String word = "";
        switch (number) {
            case 1:
                word= "one hundred ";
                break;
            case 2:
                word="two hundred ";
                break;
            case 3:
                word="three hundred ";
                break;
            case 4:
                word="four hundred ";
                break;
            case 5:
                word="five hundred ";
                break;
            case 6:
                word="six hundred ";
                break;
            case 7:
                word="seven hundred ";
                break;
            case 8:
                word="eight hundred ";
                break;
            case 9:
                word="nine hundred ";
                break;
        }
        System.out.print(word);
    }
}


