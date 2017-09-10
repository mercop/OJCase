package aliqiyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by mercop on 2017/9/10.
 */
public class aqy002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int res = 1;
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length; i ++){
            res *= nums[i] - i;
        }
        System.out.println(res);
    }
}
