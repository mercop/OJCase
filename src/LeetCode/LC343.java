package LeetCode;

/**
 * Created by mercop on 2017/9/5.
 * 动态规划将数分割使其乘积最大
 * 10 -> 3 + 3 + 4
 */
public class LC343 {

    public static void main(String[] args) {
        System.out.println(integerBreak(50));
    }

    //暴力递归
    public static int splitNums(int n) {
        if (n == 2) return 1;
        int maxValue = -1;
        for (int i = 1; i < n; i++) {

            //可优化
            maxValue = Integer.max(maxValue, splitNums(n - i) * splitNums(i));
            maxValue = Integer.max(maxValue, (n - i) * splitNums(i));
            maxValue = Integer.max(maxValue, splitNums(n - i) * i);
            maxValue = Integer.max(maxValue, (n - i) * i);
        }
        return maxValue;
    }

    //动态规划
    public static int integerBreak(int n) {
        int[] nums = new int[n + 1];
        nums[1] = 0;
        nums[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                nums[i] = Integer.max(nums[i], Integer.max(j * nums[i - j], (i - j) * j));
            }
        }
        return nums[n];
    }
}
