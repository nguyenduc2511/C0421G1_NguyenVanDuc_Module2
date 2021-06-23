package _13_Search.optional;

public class DiaQuy {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 19, 96,21};
        int result= binarySearch(arr, 19,0,arr.length);
        if(result>=0){
            System.out.println(result);
        }else {
            System.out.println(" rong ");
        }
    }

    private static int binarySearch(int[] arr, int x,int low,int hight) {
        if(hight>=low){
            int mid = (hight + low)/2;
            if(x<arr[mid]){
                return binarySearch(arr, x, low, mid -1);
            }else if(x>arr[mid]){
                return binarySearch(arr, x, mid + 1, hight);
            }else {
                return mid;
            }
        }
        return -1;
    }
}
