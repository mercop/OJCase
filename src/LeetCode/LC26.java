package LeetCode;

import java.util.Arrays;

/**
 * Created by mercop on 2017/8/13.
 * Remove Duplicates from Sorted Array
 */

public class LC26 {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,2,3,4,5,5,6};

        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }
    public static int removeDuplicates(int[] nums) {
        if(nums ==null || nums.length <= 0)
            return 0;
        int cur = 0;
        int len = nums.length;
        int curValue = nums[0];
        int temp;
        for(int i = 1; i < len;i++){
            if(curValue != (temp = nums[i])){
                nums[++cur] = temp;
                curValue = temp;
            }
        }
        return cur + 1;
    }
}
