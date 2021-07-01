package _19_String_Regex.exercise;

import java.util.regex.Pattern;

public class Validate {
    public static void main(String[] args) {
        String[] validate = {"C1118G", "A0000H", "P4444K", "P03A", "AB0123C", "C345M", "K9876m"};
        System.out.println("----------test Account------------");
        for (String value : validate) {
            System.out.println(value + " : " + validateClassName(value));
        }
    }

    public static boolean validateClassName(String string) {
        String regexCheck = "^[CAP][\\d]{4}[GHIKLM]$";
        return Pattern.matches(regexCheck, string);
    }
}

