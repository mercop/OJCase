package LeetCode;

import org.junit.Test;

/**
 * Created by mercop on 2017/8/31.
 */
public class LC312 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,1,5,8};
        System.out.println(maxCoins(nums));
    }
    //暴力递归--超时
    public static int maxCoins(int[] nums) {
        int[] numsNew = new int[nums.length + 2];
        numsNew[0] = 1;
        numsNew[numsNew.length -1 ] = 1;
        for(int i = 0; i < nums.length; i++){
            numsNew[i + 1] = nums[i];
        }
        return process(numsNew,1, numsNew.length - 2);
    }

    public static int process(int[] nums, int p, int q){
        if(p == q) return nums[p - 1]* nums[p] * nums[ q + 1];
        if(p > q) return 0;
        int maxp = nums[p -1] * nums[p] * nums[ q + 1] + process(nums, p + 1,q);
        int maxq = nums[p - 1] * nums[q] * nums[q + 1] + process(nums, p, q - 1);
        int max = Integer.max(maxp,maxq);

        for(int i = p; i <= q; i++){
            int maxi = nums[p - 1] * nums[i] * nums[q + 1] + process(nums,p,i-1) + process(nums,i+1,q);
            if(maxi > max) max = maxi;
        }

        return max;
    }


    @Test
    public void test(){
        int[] nums = new int[]{3,1,5,8};
        System.out.println(maxCoins2(nums));
    }
    //动态规划-
    public int maxCoins2(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;

        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int l = 0; l < n - k; ++l) {
                int r = l + k;
                for (int m = l + 1; m < r; ++m)
                    dp[l][r] = Math.max(dp[l][r],
                            nums[l] * nums[m] * nums[r] + dp[l][m] + dp[m][r]);
            }

        return dp[0][n - 1];
    }
}
