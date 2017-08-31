package contest.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by mercop on 2017/8/31.
 */
public class meituan01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(getANS(nums, k));
    }

    static int[] sums;

    public static int getANS(int[] nums, int k) {
        Arrays.sort(nums);
        sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] += (sums[i] + nums[i]);
        }

        return process(nums, sums[nums.length - 1], 0, nums.length - 1, k);
    }

    public static int process(int[] nums, int sum, int p, int q, int k) {
        if(p < 0 || p >= nums.length || q <0 || q >= nums.length) return 0;
        if (sum % k == 0) return q - p + 1;
        else {
            return Integer.max(process(nums, sum - nums[q], p, q - 1, k), process(nums, sum - nums[p], p + 1, q, k));
        }
    }
}
