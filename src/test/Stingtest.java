package test;

import module2.case_Study.utils.Choice;

public class Stingtest {
    public static void main(String[] args) {
        int salary = 0;
        boolean check = true;
        while (check){
            salary =new Choice().choice();
            if(salary == 0){
                System.out.println(" luong > 0 va khong duoc de trong gia tri");
            }else {
                check = false;
            }
        }
        String a = "duc"+","+salary;
        String[] b = a.split(",");
        int c = Integer.parseInt(b[1]);
        System.out.println(c);

    }
}
