package test;

import java.util.Arrays;

public class SapXepBeDenLon {
    public static void main(String[] args) {
//        sx lua chon
        int[] arrays = {6, 4, 10, 15, 8, 7, 5, 7};
        bubbleSort(arrays);
        System.out.print(Arrays.toString(arrays));

    }
    private static void bubbleSort(int[] arrays){
        boolean check = true;
        for(int i=0;i<arrays.length-1 && check;i++){
            check=false;
            for(int j=i+1;j<arrays.length;j++){
                if(arrays[i] > arrays[j]){
                    int x = arrays[i];
                    arrays[i] = arrays[j];
                    arrays[j] = x;
                    check= true;
                }
            }
        }
    }
}

