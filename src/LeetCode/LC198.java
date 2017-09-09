package LeetCode;

import org.junit.Test;

/**
 * Created by mercop on 2017/9/5.
 * 动态规划-偷取最大值，保证不相邻
 */
public class LC198 {
    public static void main(String[] args) {

        int[] nums = new int[]{4, 3, 2, 1};
        System.out.println(rob(nums));
    }

    //记忆化搜索
    public static int rob(int[] nums) {
        memo = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            memo[i] = -1;
        return tryRob(nums, 0);
    }

    static int[] memo;

    public static int tryRob(int[] nums, int index) {
        if (index >= nums.length) return 0;

        int res = 0;
        if (memo[index] != -1) return memo[index];
        for (int i = index; i < nums.length; i++) {
            res = Integer.max(res, nums[i] + tryRob(nums, i + 2));
        }
        memo[index] = res;
        return res;
    }


    @Test
    public void test(){
        int[] nums = new int[]{4, 3, 2, 1};
        System.out.println(rob2(nums));
        System.out.println(rob3(nums));
    }
    //动态规划
    public static int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        int[] memo = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            memo[i] = -1;
        int n = nums.length;
        memo[n - 1] = nums[n - 1];
        //考虑偷取[x, n -1]的值
        for(int i = n - 2 ; i >= 0; i--){
            for(int j = i; j < n; j++){
                memo[i] = Integer.max(memo[i],nums[j] + (j+2 < n ? memo[j + 2]:0));
            }
        }
        return memo[0];
    }

    //动态规划思路二
    public static int rob3(int[] nums){
        int n = nums.length;
        if (n == 0) return 0;
        int[] memo = new int[n];
        //考虑偷取[0,x]
        memo[0] = nums[0];
        for(int i = 2; i< n; i++){
            for(int j = i; j >= 2; j--){
                memo[i] = Integer.max(memo[i],nums[j] + memo[j - 2]);
            }
        }
        return memo[n-1];
    }

}
