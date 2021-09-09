package module2.case_Study.utils;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Scan {

    public Scanner input(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    public String inputString(){
        String a = null;
        String regexCheck = "^(\\S+)([\\w\\s]*)$";
        boolean check = true;
        while (check){
            a =  new Scan().input().nextLine();
            if (Pattern.matches(regexCheck, a)) {
                check = false;
            }else {
                System.out.println("vui long nhap lai khong duoc de trong ");
            }
        }
        return a;
    }
}
