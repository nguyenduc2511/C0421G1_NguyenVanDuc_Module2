package _11_Stack_Queue.exercise;


import java.util.Arrays;
import java.util.TreeMap;

public class MyTreeMap {

    public static void main(String[] args) {

        TreeMap<String, Integer> myTreeMap = new java.util.TreeMap<>();
        String arr = "I belive, i can   fly aa bb cc";
        System.out.println(arr);
        String[] countStr = arr.toLowerCase().split("");

        int count = 0;
        for (int i = 0; i < countStr.length; i++) {
            if (countStr[i].equals(",") || countStr[i].equals(" ")) {
                continue;
            }
            if (myTreeMap.containsKey(countStr[i])) {
                count = myTreeMap.get(countStr[i]) + 1;
                myTreeMap.put(countStr[i], count);
            } else {
                myTreeMap.put(countStr[i], 1);
            }
        }
        System.out.println(myTreeMap);
    }
}
