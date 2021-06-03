package _01_introduction_to_java.practise;

import java.util.Scanner;

public class ChiSoBMI {
    public static void main(String[] args) {
        double weight, height, bmi;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Your weight (in kilogram):");
        weight = scanner.nextDouble();

        System.out.print("Your height (vd: 1,65 in meter) :");
        height = scanner.nextDouble();

        bmi = weight / Math.pow(height, 2);
        System.out.println(bmi);
        if (bmi < 18)
            System.out.println(bmi + " Underweight");
        else if (bmi < 25.0)
            System.out.println(bmi + " Normal");
        else if (bmi < 30.0)
            System.out.println(bmi + " Overweight");
        else
            System.out.println(bmi + " Obese");
    }
}
