package module2._24_8_test;

import java.util.Arrays;

public class Find_String {

    public static void find(String string) {
        String[] a = string.split("");
        String[] b = new String[string.length()];

        for (int i = 0; i < a.length; i++) {
            int count = 0;
            for (int j = i + 1; j < a.length - 1; j++) {
                if (a[i] != null && !a[i].equals(" ")) {
                    if (a[i].equals(a[j])) {
                        count++;
                        a[j] = null;
                    }
                }
            }
            if (count > 0) {
                b[i] = a[i];
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (b[i] != null) {
                System.out.println(b[i]);
            }
        }
    }

    public static String[] findst(String string) {
        String[] strings = new String[string.length()];
        String[] strings1 = new String[string.length()];
        int temp = 0;
        for (int i = 0; i < string.length(); i++) {
            strings[i] = String.valueOf(string.charAt(i));
        }
        for (int i = 0; i < strings.length - 1; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                if (strings[i].equals(strings[j]) && strings[i] != " ") {
                    strings1[temp] = strings[i];
                    temp++;
                    strings[j] = " ";
                    break;
                }
            }
        }
        String[] strings2 = new String[temp];
        for (int i = 0; i < temp; i++) {
            strings2[i] = strings1[i];

        }
        return strings2;
    }

    public static void main(String[] args) {
        String a = "abcbdcef a b cbc";
        find(a);
        System.out.println(Arrays.toString(findst(a)));
    }
}
