package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mercop on 2017/8/16.
 * 存在相同，则返回true
 */

public class LC217 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {

        int len = nums.length;
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < len; i ++){
            if(set.contains(nums[i]))
                return true;
            else set.add(nums[i]);
        }
        return false;
    }
}
