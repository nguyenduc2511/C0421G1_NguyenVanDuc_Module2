package exam_module2.utils;

import java.util.regex.Pattern;

public class CheckName {

    public  String checkTenSP() {
        boolean checkPatten = false;
        String regexCheck = "^(([a-zA-Z]{1,})(\\s?[a-zA-z]{1,}'?-?[a-zA-Z]+\\s?)?([a-zA-Z]{1,})?)$";
        String a = null;
        while (!checkPatten){
            a = new InputString().inputString();
            if (Pattern.matches(regexCheck, a)) {
                checkPatten = true;
            }
        }
        return a;
    }

}
