package contest.meituan;

import java.util.Scanner;

/**
 * Created by mercop on 2017/9/14.
 */
public class meituan02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i =0; i < n ; i++)
            nums[i] = sc.nextInt();
        if(nums[n -1]  == 1) System.out.println("Alice");
        else System.out.println("Bob");
    }
}
