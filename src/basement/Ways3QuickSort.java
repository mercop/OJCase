package basement;

import java.util.Arrays;

/**
 * Created by mercop on 2017/8/14.
 * 三路快排序
 */

public class Ways3QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,5,6,7,4,3,10,11,12,6};
        partition(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void partition(int[] arr){
        int p = 0;
        int i = 1;
        int q =  arr.length -1;
        while(arr[i] >= arr[p]) p = i++;

        int pivotVal = arr[p];

        while(arr[q] >= pivotVal)
            q --;
        int k = p;
        for(int j = k +1; j <= q;j++){
            if(arr[j] == pivotVal)
                continue;
            else if(arr[j] > pivotVal)
                swap(arr,j,q--);
            else
                swap(arr,k++,j);
        }
    }

    public static void partition2(int[] arr){

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
