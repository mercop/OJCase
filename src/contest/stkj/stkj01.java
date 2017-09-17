package contest.stkj;

import java.util.Scanner;

/**
 * Created by mercop on 2017/9/17.
 */
public class stkj01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[][] nums = new int[k][n];
        for(int i = 0; i < k;i ++){
            for(int j = 0; j < n; j++){
                nums[i][j] = sc.nextInt();
            }
        }
        int min = Integer.MAX_VALUE;
        int max = -1;
        for(int i = 0; i < k ; i++){
            if(nums[i][0] > max) max = nums[i][0];
            if(nums[i][0] < min) min = nums[i][0];
        }
        System.out.println(min + " " + max);

    }
}
