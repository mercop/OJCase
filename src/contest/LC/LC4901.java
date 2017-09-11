package contest.LC;

/**
 * Created by mercop on 2017/9/10.
 * Longest Continuous Increasing Subsequence
 */
public class LC4901 {

    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int res = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                res++;
            } else {
                res = 1;
            }
            max = Integer.max(max,res);
        }

        return max;
    }
}
