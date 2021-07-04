package caseStudy.services.facility;

import java.util.regex.Pattern;

public class CheckValidateId {
    public  boolean checkIdName(String string) {
        boolean checkPatten = false;
        String regexCheck = "^[S][V][H][O][-]\\d{4}$";
        String regexCheck2 = "^[S][V][R][O][-]\\d{4}$";
        String regexCheck3 = "^[S][V][V][L][-]\\d{4}$";

        if (Pattern.matches(regexCheck, string)) {
            checkPatten = true;
        }
        if (Pattern.matches(regexCheck2, string)) {
            checkPatten = true;
        }
        if (Pattern.matches(regexCheck3, string)) {
            checkPatten = true;
        }
        return checkPatten;
    }
    public  boolean checkDate(String string) {
        boolean checkPatten = false;
        String regexCheck2 = "^[D][a][y][-]\\d{4}$";
        String regexCheck3 = "^[M][o][n][-]\\d{4}$";
        String regexCheck4 = "^[Y][e][a][-]\\d{4}$";
        String regexCheck5 = "^[H][o][u][-]\\d{4}$";
        if (Pattern.matches(regexCheck2, string)) {
            checkPatten = true;
        }
        if (Pattern.matches(regexCheck3, string)) {
            checkPatten = true;
        }
        if (Pattern.matches(regexCheck4, string)) {
            checkPatten = true;
        }
        if (Pattern.matches(regexCheck5, string)) {
            checkPatten = true;
        }
        return checkPatten;
    }
    public   boolean checkTC(String string) {
        boolean checkPatten = false;
        String regexCheck = "^[T][C][H][O][-]\\d{2}$";
        String regexCheck2 = "^[T][C][R][O][-]\\d{2}$";
        String regexCheck3 = "^[T][C][V][L][-]\\d{2}$";

        if (Pattern.matches(regexCheck, string)) {
            checkPatten = true;
        }
        if (Pattern.matches(regexCheck2, string)) {
            checkPatten = true;
        }
        if (Pattern.matches(regexCheck3, string)) {
            checkPatten = true;
        }
        return checkPatten;
    }
}
