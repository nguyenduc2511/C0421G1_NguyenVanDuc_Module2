package test;

import java.util.Map;
import java.util.TreeMap;

public class CayChay {
    //    Bài 1: Với s1 = "aabcc" và s2 = "adcaa", thì kết quả commonCharacterCount(s1, s2) = 3.
//2 xâu s1 và s2 có 3 kí tự chung: 2 kí tự 'a' và 1 kí tự 'c'.
//
//●	Bài 2: Với inputString = "abac", thì kết quả differentSubstringsTrie(inputString) = 9.
//9 xâu con khác nhau của xâu đầu vào là:
//"a", "b", "c", "ab", "ac", "ba", "aba", "bac", "abac"
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "adcaa";
        Map<Character, Integer> map = new TreeMap<>();
        Map<Character, Integer> map2 = new TreeMap<>();
        String[] strings = s1.split("");
        String[] strings2 = s2.split("");
        if(strings.length>strings2.length){

        }
//        for(String a : strings){
//            int count = 0;
//            for(int i =0 ; i< strings2.length;i++){
//                if(a.equals(strings2[i])){
//                    strings2[i]="";
//                    count++;
//                }
//            }
//            System.out.println(a + count);
//        }

        for(String a : strings2){
            int count = 0;
            for(int i =0 ; i< strings.length;i++){
                if(a.equals(strings[i])){
                    strings[i]="";
                    count++;
                }
            }
            System.out.println(a + count);
        }
    }


}
