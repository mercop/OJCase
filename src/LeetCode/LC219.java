package LeetCode;

import java.util.HashSet;

/**
 * Created by mercop on 2017/8/16.
 * 给定一个数组，和一个K，判断是否存在nums[i] == numsp[j]，且i、j距离小于k
 */

public class LC219 {
    public static void main(String[] args) {

        int[] nums = new int[]{1};
        System.out.println(containsNearbyDuplicate(nums,1));

    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0)
            return false;
        HashSet<Integer> set = new HashSet<Integer>(1024);
        int len = nums.length;

        int left = 0;
        int right = Integer.min(k,len -1);
        for(int i = 0 ; i <= right; i++){
            if(set.contains(nums[i])) return true;
            else set.add(nums[i]);
        }
        while(right + 1 < len){
            set.remove(nums[left ++]);
            if(set.contains(nums[++right]))
                return true;
            else set.add(nums[right]);
        }
        return false;
    }
}
