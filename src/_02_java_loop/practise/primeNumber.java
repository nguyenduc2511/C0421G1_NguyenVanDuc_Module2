package _02_java_loop.practise;

import java.util.Scanner;

public class primeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your number ");
        int number = scanner.nextInt();

        if(number<2){
            System.out.println(number + " is not prime number");
        }else {
            boolean check=true;
            for (int i=2;i<=Math.sqrt(number);i++){
                if(number%i==0){
                    check=false;
                    break;
                }
            }
            if(check){
                System.out.println(number + " is prime number ");
            }else {
                System.out.println(number+ " is not prime number ");
            }

        }
    }
}
