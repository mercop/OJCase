package contest.meituan;

import java.util.Scanner;

/**
 * Created by mercop on 2017/9/14.
 */
public class meituan001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        int[] endOfNums = new int[10];
        int temp;
        for(int i =0 ; i< n;i++){
            temp = sc.nextInt();
            endOfNums[temp%10] ++;
            nums[i] = temp;
        }
        int res = 0;
        for(int i =0 ; i< n;i++){
            for(int j = 0; j <= 9;j++){
                int x = nums[i] + 5*j;
                if(x % 7 == 0)
                    res +=endOfNums[j];
            }
        }
        System.out.println(res);

    }

}
