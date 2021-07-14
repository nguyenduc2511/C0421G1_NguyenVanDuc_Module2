package exam_module2.utils;

import java.util.Scanner;

public class InputString {
    public Scanner input(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
    public String inputString(){
        String a = null;
        String regexCheck = "";
        boolean check = true;
        while (check){
            a =  new InputString().input().nextLine();
            if (!a.equals(regexCheck)) {
                check = false;
            }else {
                System.out.println("Vui lòng nhập lại không được để trống ");
            }
        }
        return a;
    }
}
