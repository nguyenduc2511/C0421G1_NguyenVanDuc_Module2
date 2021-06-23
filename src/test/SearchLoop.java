package test;

public class SearchLoop {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 19, 96,21};
        int result= binarySearch(arr, 10);
        if(result>=0){
            System.out.println(result);
        }else {
            System.out.println(" rong ");
        }
    }

    private static int binarySearch(int[] arr, int x) {
        int low = 0;
        int hight = arr.length - 1;
        while (low <= hight) {
            int mid = (low + hight) / 2;
            if (x < arr[mid]) {
                hight = mid - 1;
            } else if (x > arr[mid]) {
                low = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
