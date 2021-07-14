package exam_module2.utils;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputString {
    public Scanner input(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
    public String inputString(){
        String a = null;
        String regexCheck = "^\\S+$";
        boolean check = true;
        while (check){
            a =  new InputString().input().nextLine();
            if (Pattern.matches(regexCheck, a)) {
                check = false;
            }else {
                System.out.println("vui long nhap lai khong duoc de trong ");
            }
        }
        return a;
    }
}
