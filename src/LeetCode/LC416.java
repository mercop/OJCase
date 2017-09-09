package LeetCode;

/**
 * Created by mercop on 2017/9/6.
 * 给定一个数组，求能否分割成两个子集合，使其之和相等
 * 找到元素 完全填满 sum/2的容积
 */
public class LC416 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        System.out.println(canPartition(nums));
    }

    //动态规划 空间复杂度O(n)
    //状态转移方程：f(x,w) = f(x -1,w)||f(x-1,w - nums[x])
    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += nums[i];
        if (sum % 2 != 0) return false;
        int half = sum / 2;
        boolean[] memo = new boolean[half + 1];

        for (int j = 0; j <= half; j++)
            if (j == nums[0]) {
                memo[j] = true;
                break;
            }
        for (int i = 1; i < n; i++) {
            for (int j = half; j >= nums[i]; j--) {
                memo[j] = memo[j - nums[i]] || memo[j];
            }
        }
        return memo[half];
    }
}
