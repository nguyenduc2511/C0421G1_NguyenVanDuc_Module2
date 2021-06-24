package _14_Sort.practise;


import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
         int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        bubbleSort(list);
        System.out.println(Arrays.toString(list));
        bubbleSortHightToLow(list);
        System.out.println(Arrays.toString(list));
    }

    public static void bubbleSort(int[] list) {
        boolean check = true;
        for (int k = 1; k < list.length && check; k++) {
            check = false;
            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    check = true;
                }
            }
        }
    }
    public static void bubbleSortHightToLow(int[] list) {
        boolean check = true;
        for (int k = 0; k < list.length && check; k++) {
            check = false;
            for (int i = 0; i < list.length - k-1; i++) {
                if (list[i] < list[i + 1]) {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    check = true;
                }
            }
        }
    }




}
