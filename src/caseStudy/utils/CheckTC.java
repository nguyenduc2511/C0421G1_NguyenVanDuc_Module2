package caseStudy.utils;

import java.util.regex.Pattern;

public class CheckTC {
    public boolean checkTChouse(String string) {
        boolean checkPatten = false;
        String regexCheck = "^[T][C][H][O][-]\\d{2}$";
        if (Pattern.matches(regexCheck, string)) {
            checkPatten = true;
        }
        return checkPatten;
    }
    public boolean checkTCRoom(String string) {
        boolean checkPatten = false;
        String regexCheck2 = "^[T][C][R][O][-]\\d{2}$";
        if (Pattern.matches(regexCheck2, string)) {
            checkPatten = true;
        }
        return checkPatten;
    }
    public boolean checkTCVilla(String string) {
        boolean checkPatten = false;
        String regexCheck3 = "^[T][C][V][L][-]\\d{2}$";
        if (Pattern.matches(regexCheck3, string)) {
            checkPatten = true;
        }
        return checkPatten;
    }
}
