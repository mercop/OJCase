package LeetCode;

import java.util.Arrays;

/**
 * Created by mercop on 2017/8/13.
 * 数组元素去重，最多保留两个
 */

public class LC80 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 1, 1, 2, 2, 3, 4, 5, 6, 6, 6, 7};

        int count = RemoveDup(arr);
        System.out.println(count);
        System.out.println(Arrays.toString(arr));
    }

    public static int RemoveDup(int[] arr) {
        if(arr ==null || arr.length <=0)
            return 0;

        int k = 1;
        int two = 1;
        int before = arr[0];
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int temp = arr[i];
            if (arr[i] == before && two < 2) {
                two++;
                swap(arr, i, k);
                k++;
            } else if (arr[i] != before) {
                two = 1;
                swap(arr, i, k);
                k++;
            }
            before = temp;
        }
        for (int i = k; i < len; i++)
            arr[i] = 0;
        return k;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
