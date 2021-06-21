package _11_Stack_Queue.Optional.exercise;




import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        String str = "Able was I e0re I saw Elba";
        if (checkPalindrome(str)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
    private static boolean checkPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.toLowerCase().charAt(i));
            queue.add(str.toLowerCase().charAt(i));
        }
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.poll())) {
                return false;
            }
        }
        return true;
    }
}
