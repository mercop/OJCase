package contest.meituan;

import org.junit.Test;

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
        sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] += (sums[i - 1] + nums[i]);
        }

        return process(nums, sums[nums.length - 1], 0, nums.length - 1, k);
    }

    public static int process(int[] nums, int sum, int p, int q, int k) {
        if (p < 0 || p >= nums.length || q < 0 || q >= nums.length) return 0;
        if (sum % k == 0) return q - p + 1;
        else {
            return Integer.max(process(nums, sum - nums[q], p, q - 1, k), process(nums, sum - nums[p], p + 1, q, k));
        }
    }

    //Dp
    @Test
    public void test() {

        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(getANS2(nums, 5));
    }

    static int[][] pq;

    public static int getANS2(int[] nums, int k) {
        int len = nums.length;
        sums = new int[len];
        pq = new int[len][len];
        sums[0] = nums[0];
        for (int i = 1; i < len; i++) {
            sums[i] += (sums[i - 1] + nums[i]);
        }

        for (int i = 0; i < len; i++)
            pq[i][i] = nums[i] % k == 0 ? 1 : 0;

        for (int m = 1; m < len; m++) {
            for (int i = 0; i <len - m; i++){
                int j = i + m;
                pq[i][j] = Integer.max((sums[j] - sums[i] + nums[i]) % k == 0 ? j - i + 1 : 0,
                        Integer.max(pq[i][j - 1], pq[i + 1][j]));
            }
        }
        return pq[0][len - 1];
    }
}
