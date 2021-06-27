package _15_exception_debug.practise;

import java.util.Scanner;

public class debugTest {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = 0', please enter constants:");
        System.out.print("a: ");
        double a = exceptionCheck();
        System.out.print("b: ");
        double b = exceptionCheck();
        
        if (a != 0) {
            double solution = -b / a;
            System.out.printf("The solution is: %f!", solution);
        } else {
            if (b == 0) {
                System.out.print("The solution is all x!");
            } else {
                System.out.print("No solution!");
            }
        }
    }
    private static double exceptionCheck(){
        double a=0;
        boolean check = false;
        while (!check) {
            try {
                a = Double.parseDouble(scanner.nextLine());
//                a = scanner.nextDouble(); // ép kiểu vào. lỗi
                check = true;
            } catch (NumberFormatException ex) {
// dùng NumberFormatException.
//                Exception
                System.out.println(ex.getMessage()+ " nhap vao la so ");

            }
        }
        return a;
    }

}
