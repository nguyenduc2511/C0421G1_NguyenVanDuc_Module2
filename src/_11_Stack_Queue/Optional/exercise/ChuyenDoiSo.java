package _11_Stack_Queue.Optional.exercise;
import java.util.Scanner;
import java.util.Stack;
public class ChuyenDoiSo {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("nhap so thap phan:");
        int thapPhan = sc.nextInt();
        chuyenNhiPhan(thapPhan);
    }

    private static void chuyenNhiPhan(int number){
        Stack<Integer> stack = new Stack<>();
//        buoc chuyen doi qua nhi phan 10101
        for (int i = 0; number != 0; i++) {
            int value = number % 2;
            stack.push(value);
            number = number / 2;
            if (number == 0) {
                value = 0;
                stack.push(value);
            }
        }
        String nhiPhan = "";
        for (int i = 0; stack.size() != 0; i++) {
            nhiPhan += stack.pop();
        }
        System.out.println("sau khi chuyen doi : " + nhiPhan);
    }
}
