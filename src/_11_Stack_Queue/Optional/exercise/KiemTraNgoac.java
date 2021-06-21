package _11_Stack_Queue.Optional.exercise;

import java.util.Scanner;
import java.util.Stack;

public class KiemTraNgoac {

    public static void main(String[] args) {
        String bieuThuc1 = "anh yeu em-)*_*(-";
        checkStr(bieuThuc1);
        printCheck(bieuThuc1);
        String bieuThuc2 = "s * (s – a) * (s – b) * (s – c)";
        checkStr(bieuThuc2);
        printCheck(bieuThuc2);
        String bieuThuc3 = "(– b + (b2 – 4*a*c)^0.5) / 2*a";
        checkStr(bieuThuc3);
        printCheck(bieuThuc3);
        String bieuThuc4 = "s * (s – a) * (s – b * (s – c)";
        checkStr(bieuThuc4);
        printCheck(bieuThuc4);
        String bieuThuc5 = "s * (s – a) * s – b) * (s – c) ";
        checkStr(bieuThuc5);
        printCheck(bieuThuc5);
        String bieuThuc6 = "(– b + (b^2 – 4*a*c)^(0.5/ 2*a))";
        checkStr(bieuThuc6);
        printCheck(bieuThuc6);

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("nhap bieu thuc ");
//        String bieuThuc = scanner.nextLine();
//        printCheck(bieuThuc);

    }

    private static boolean checkBieuThuc(String[] data) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals("(")) {
                stack.push(data[i]);
            }
            if (data[i].equals(")")) {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    private static void printCheck(String data) {
        System.out.println(data);
        String[] checkStr = data.split("");
        if (checkBieuThuc(checkStr)) {
            System.out.print(" bieu thuc dung");
        } else {
            System.out.print(" bieu thuc sai ");
        }
        System.out.println("\n");
    }

    private static boolean checkStr(String str) {
        Stack<Character> strack = new Stack<>();
        char left;
        for (int i = 0; i < str.length(); i++) {
            left = str.charAt(i);
            if (left == '(') {
                strack.push(left);
            } else if (left == ')') {
                if (strack.isEmpty()) {
                    return false;
                } else {
                    strack.pop();
                }
            }
        }
        return strack.isEmpty();
    }
}