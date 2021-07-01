package _19_String_Regex.exercise;

import java.util.regex.Pattern;

public class ValidatePhone {
    public static void main(String[] args) {
        String[] validate = {};
        String[] invalidate = {"(84)-(0978489648)", "(96)-(0986058250)","(ah)-(0123456789)", "(123)-(0123456789)", "(1)-(0123456789)", "(12)-(5123456789)", "(12)-(0123456)"};

        System.out.println("----------test PhoneNumber------------");
        for (String value : invalidate) {
            System.out.println(value + " : " + validatePhone(value));
        }

    }

    public static boolean validatePhone(String phone) {
        String regex = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$";
        boolean check = Pattern.matches(regex, phone);
        return check;
    }
}
