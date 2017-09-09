package LeetCode;

/**
 * Created by mercop on 2017/9/6.
 * 最长上升子序列问题(dp)
 * 状态转移方程： LIS(i) = max(1 + LIS(j) if nums[i] > nums[j])  {i > j}
 * LIS(i) 以i为末尾的最长子序列
 */
public class LC300 {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18,19};
        System.out.println(lengthOfLIS(nums));
    }

    //动态规划解法 O(n^2)
    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] meno = new int[n];
        int max = 1;
        for(int i =0; i < n; i ++) meno[i] = 1;

        for(int i =1; i < n; i ++){
            for(int j = 0; j < i;j ++){
                if(nums[j] < nums[i]) meno[i] = Integer.max(meno[i], meno[j] + 1);
            }
            if(meno[i] > max) max = meno[i];
        }
        return max;
    }
}
