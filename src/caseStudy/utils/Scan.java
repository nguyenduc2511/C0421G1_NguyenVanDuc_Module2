package caseStudy.utils;

import java.util.Scanner;

public class Scan {
    public Scanner input(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
    public String inputString(){
        String a = null;
        boolean check = true;
        while (check){
            a =  new Scan().input().nextLine();
            if(a.equals("")){
                System.out.println("vui long nhap lai khong duoc de trong ");
            }else {
                check = false;
            }
        }
        return a;
    }
}
