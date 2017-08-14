package LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by mercop on 2017/8/14.
 * Sorted Color
 *
 * 思路：计数排序
 */

public class LC75 {

    //该方法扫描数组两遍
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1,2,0,0,1,2,2};
        int[] count = new int[3];
        for(int i =0;i < arr.length; i++){
            count[arr[i]]++;
        }
        int k = 0;
        for(int i =0; i < count.length;i++){
            int counti = count[i];
            for(int j = k; j < counti + k;j ++)
                arr[j] = i;
            k += counti;
        }

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void betterSolution(){

        int[] arr = new int[]{1,2,1,2,0,0,1,2,2};
        sortColors2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //一趟循环，运用思路：3路快排序,pivot设置为1
    static void sortColors2(int[] nums) {

        int zero = -1;          // [0...zero] == 0
        int two = nums.length;  // [two...n-1] == 2
        for( int i = 0 ; i < two ; ){
            if( nums[i] == 1 )
                i ++;
            else if ( nums[i] == 2 )
                swap( nums, i , --two);
            else{ // nums[i] == 0
                assert( nums[i] == 0 );
                swap( nums,++zero, i++);
            }
        }
    }
}
