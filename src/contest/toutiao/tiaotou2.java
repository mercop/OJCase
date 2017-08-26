package contest.toutiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by mercop on 2017/8/22.
 */

public class tiaotou2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextInt()){
            int n = cin.nextInt();
            int[] nums = new int[n];
            int max = -1;
            for(int i = 0 ; i < n ; i++){
                int val = cin.nextInt();
                nums[i] = val;
                val = val * val;
                if(val > max) max = val;
            }
            Arrays.sort(nums);
            int[] sum = new int[n];
            sum[0] = nums[0];
            for(int i = 1 ; i < n; i ++)
                sum[i] = nums[i] + sum[i -1];

            for(int i = 0; i < n; i ++)
                for(int j = i + 1; j < n; j ++){
                    int val = (sum[j] - sum[i] + nums[i]) * nums[i];
                    if(val > max) max = val;
                }
            System.out.println(max);
        }

    }
}
