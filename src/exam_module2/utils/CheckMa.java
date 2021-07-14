package exam_module2.utils;

import java.util.regex.Pattern;

public class CheckMa {
    public  String checkTenSP() {
        boolean checkPatten = false;
        String regexCheck1 = "^(SPNK\\-)(\\d){5}";
        String regexCheck2 = "^(SPXK\\-)(\\d){5}";

        String a = null;
        while (!checkPatten){
            a = new InputString().inputString();
            if (Pattern.matches(regexCheck1, a)) {
                checkPatten = true;
            }
            if (Pattern.matches(regexCheck2, a)) {
                checkPatten = true;
            }
        }
        return a;
    }
}
