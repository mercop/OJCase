package LeetCode;

import org.junit.Test;

/**
 * Created by mercop on 2017/9/6.
 * 给定一个数组，求有多少种选择，使得其和为指定target，顺序性
 */
public class LC377 {

    @Test
    public void test(){
        int[] nums = new int[]{1,2,3};
        System.out.println(combinationSum4(nums, 4));
        System.out.println(combinationSum42(nums,4));
        System.out.println(combinationSum43(nums,4));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(combinationSum4(nums,4));
    }
    //暴力递归
    public static int combinationSum4(int[] nums, int target) {
        selectNums(nums,0,target);
        return count;
    }
    static int count = 0;
    public static void selectNums(int[] nums,int index, int target){
        if(target == 0) {
            count ++;
            return;
        }
        if(target < 0) return;
        for(int i = 0 ;i < nums.length; i++){
            if(nums[i] <= target){
                selectNums(nums,index + 1, target - nums[i]);
            }
        }
    }

    //记忆化搜索
    static int[] memo;
    public static int combinationSum43(int[] nums, int target) {
        memo = new int[target + 1];
        for(int i = 0; i < target + 1; i++) memo[i] = -1;
        return selectNums2(nums,0,target);
    }
    public static int selectNums2(int[] nums,int index, int target){
        if(target == 0) return 1;
        if(target < 0) return 0;

        if(memo[target] != -1) return memo[target];
        int res = 0;
        for(int i = 0 ;i < nums.length; i++){
            if(nums[i] <= target){
                res += selectNums2(nums,index + 1, target - nums[i]);
            }
        }
        memo[target] = res;
        return res;
    }



    //动态规划
    public static int combinationSum42(int[] nums,int target){
        if(nums == null || nums.length == 0) return 0;
        int[] memo = new int[target + 1];
        memo[0] = 1;
        for(int i =1; i <= target; i ++){
            for(int j = 0; j < nums.length; j ++){
                if(nums[j] <= i) memo[i] += memo[i - nums[j]];
            }
        }
        return memo[target];
    }
}
