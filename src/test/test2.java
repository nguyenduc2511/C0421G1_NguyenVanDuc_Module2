package test;

public class test2 {
//    Với inputString = "abac", thì kết quả differentSubstringsTrie(inputString) = 9.
//9 xâu con khác nhau của xâu đầu vào là:
//"a", "b", "c", "ab", "ac", "ba", "aba", "bac", "abac".

    public static void main(String[] args) {
        String a = "abac";
        String[] b = new String[50];
        int c = 0;
        for (int i = 1; i <= a.length(); i++) {
            String teamp = "";
            for (int j = 0; j < a.length() && (i + j) <= a.length(); j++) {
//                for (int i = 0; i <= a.length(); i++) {
//            String teamp = "";
//            for (int j = i+1; j <= a.length(); j++) {
//                teamp = a.substring(i, j);
                teamp = a.substring(j, j + i);
                if (c != 0) {
                    boolean check = true;
                    for (int k = 0; k < c; k++) {
                        if ((b[k].equals(teamp))) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        b[c] = teamp;
                        c++;
                    }
                } else {
                    b[c] = teamp;
                    c++;
                }
            }
        }
        int count =0;
        for (String d : b) {
            if (d != null) {
                count++;
                System.out.println(d);
            }
        }
        System.out.println("so chuoi khac nhau = " + count);
    }
}
//public static int test(String str)
//    {
//        String [] input = new String[20];
//        int a = 0;
//        int count = 0;
//        for (int i = 0; i <= str.length(); i++) {
//            for (int j = i + 1; j <= str.length(); j++) {
//                input[a] = (str.substring(i, j));
//                a++;
//                count++;
//            }
//
//        }
//        System.out.println(Arrays.toString(input));
//        return count;
//    }

