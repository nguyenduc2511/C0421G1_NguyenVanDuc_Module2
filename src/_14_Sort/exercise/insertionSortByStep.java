package _14_Sort.exercise;

public class insertionSortByStep {
    public static void main(String[] args) {
        int[] list = {5,6,8,7,4,2,6,9,1,2,3};
        insertionSort(list);
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];
            int j;
            for (j = i - 1; j >= 0 && arr[j] > key; j--) {
                System.out.println("Swap " + arr[j+1] + " with " + arr[j]);
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = key;
            System.out.print("List after the  " + i + "' sort: ");
            for ( j = 0; j < arr.length; j++) {
                System.out.print(arr[j] + "\t");
            }
            System.out.println("\n");
        }
    }
}
