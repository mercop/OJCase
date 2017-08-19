package LeetCode;

import org.junit.Test;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by mercop on 2017/8/16.
 * LC219加入nums[i] nums[j]差值小于t
 * 给定一个数组，和一个K，判断是否存在nums[i]，numsp[j]，且i、j距离小于k，nums[i] nums[j]差值小于t
 */

public class LC220 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2147483648,-2147483647};
        System.out.println(containsNearbyAlmostDuplicate(nums,3,3));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0 || k == 0)
            return false;
        TreeSet<Long> set = new TreeSet<Long>();
        int len = nums.length;

        for(int i = 0 ; i < len; i++){
            if(set.ceiling(Long.valueOf(nums[i]) - Long.valueOf(t)) != null && set.ceiling(Long.valueOf(nums[i]) - t) <= Long.valueOf(nums[i]) + t)
                return true;
            set.add(Long.valueOf(nums[i]));
            if(set.size() == k + 1){
                set.remove(Long.valueOf(nums[i - k]));
            }
        }
        return false;
    }


    @Test
    public void test(){
        int[] nums = new int[]{4,1,6,3};
        System.out.println(containsNearbyAlmostDuplicate2(nums,100,1));
    }

    public static boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0 || k == 0)
            return false;
        HashSet<Long> set = new HashSet<Long>();
        int len = nums.length;
        long num;
        for(int i = 0 ; i < len; i++){
            num = (long)nums[i];

            for(int j = 0; j <= t;j++){
                if(set.contains(num + j) || set.contains(num -j))
                    return true;
            }
            set.add(Long.valueOf(nums[i]));
            if(set.size() == k + 1){
                set.remove(Long.valueOf(nums[i - k]));
            }
        }
        return false;
    }
}
