package module2._27_8_test;

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

    public static Character[] findst(String string) {
        Character[] characters = new Character[string.length()];
        Character[] characters1 = new Character[string.length()];
        int temp = 0;
        for (int i = 0; i < string.length(); i++) {
            characters[i] = string.charAt(i);
        }
        for (int i = 0; i < characters.length - 1 ; i++) {
            int count = 0;
            for (int j = i + 1; j < characters.length; j++) {
                if (characters[i].equals(characters[j]) && characters[i] !=' ') {
                    count++;
                    characters[j] = ' ';
                }
                if(count != 0 && j == characters.length -1 && characters[i] !=' '){
                    characters1[temp] = characters[i];
                    temp++;
                }
            }
        }
        Character[] characters2 = new Character[temp];
        for (int i = 0; i < temp ; i++) {
            characters2[i] = characters1[i];

        }
        return characters2;
    }

    public static void main(String[] args) {
        String a = "abcbdcef a b cbc";
        find(a);
        System.out.println(Arrays.toString(findst(a)));
        String b = "aaaaaaaaa a b cbcbbcc";
        find(b);
        System.out.println(Arrays.toString(findst(b)));
    }
}
