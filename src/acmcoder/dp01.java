package acmcoder;

import java.util.Scanner;

/**
 * Created by mercop on 2017/9/2.
 */
public class dp01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }

        int status[] = new int[41];
        status[0] = 1;
        status[1] = 1;

        for (int i = 2; i < status.length; i++){
            status[i] = status[i -1] + status[i - 2];
        }
        for (int i = 0; i < n; i++){
            if(nums[i] == 1) System.out.println(0);
            else System.out.println(status[nums[i] - 1]);
        }
    }
}
