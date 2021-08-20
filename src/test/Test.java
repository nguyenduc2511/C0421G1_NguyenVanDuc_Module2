package test;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 2, 3, 3, 3};
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i]=arr[i];
        }
        int[] countNum = new int[arr.length];
        int a = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr2.length; j++) {
                if (arr[i] == arr2[j]) {
                    count++;
                    arr2[j] = 0;
                }
            }
            if (count > 0) {
                System.out.println("so " + arr[i] + " xuat hien " + count);
                countNum[a] = count;
                a++;
            }
        }
        boolean check = true;
        int isRight = countNum[0];
        for (int i=0; i< a; i++){
            if (countNum[i] != isRight) {
                check = false;
                break;
            }
        }
        System.out.println("Kết quả là : " + check);
    }




}
