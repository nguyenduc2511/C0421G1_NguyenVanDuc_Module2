package test;

import java.util.Arrays;

public class SxLondenBeSxNoibot {
    public static void main(String[] args) {
        int[] arr = {6,4,10,15,8,7,5,7};
        boolean check = true;

        for(int i=0;i<arr.length-1 && check;i++){
            check = false;
            for(int j= i+1;j<arr.length;j++){
                if(arr[i]<arr[j]){
                    int x = arr[i];
                    arr[i] = arr[j];
                    arr[j] = x;
                    check = true;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
