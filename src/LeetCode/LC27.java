package LeetCode;

import java.util.Arrays;

/**
 * Created by mercop on 2017/8/13.
 * 去除某个值为val的所有元素
 */

public class LC27 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,2,2,3};
        System.out.println(removeElement(nums,2));
        System.out.println(Arrays.toString(nums));
    }
    public static int removeElement(int[] nums, int val) {
        if(nums ==null || nums.length <=0)
            return 0;
        int p = 0;
        int q = nums.length - 1;
        while(p <= q){
            if(nums[p] == val)
                nums[p] = nums[q--];
            else
                p++;
        }
        return p;
    }
}
