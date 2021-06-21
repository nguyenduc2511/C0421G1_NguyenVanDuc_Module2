package _11_Stack_Queue.exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class DaoNguocStack {

    public static void main(String[] args) {

        Stack<Integer> myStack = new java.util.Stack<>();
        int[] myArrays = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i = 0; i < myArrays.length; i++) {
            myStack.push(myArrays[i]);
        }
        for (int i = 0; i < myArrays.length; i++) {
            myArrays[i] = myStack.pop();
        }
        for (int mytest : myArrays) {
            System.out.println(mytest);
        }
        Stack<String> wStack = new java.util.Stack<>();
        String word = "maN teiV";
        StringBuilder output = new StringBuilder();

        String[] mWord = word.split("");
        for (int i = 0; i < mWord.length; i++) {
            wStack.push(mWord[i]);
        }
        for (int i = 0; i < mWord.length; i++) {
            output.append(wStack.pop());
        }
        System.out.println(output);
    }
}
