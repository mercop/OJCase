package contest.dji;

import java.util.Scanner;

//4294967294
public class dji01 {
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNext())
        {
            int n = cin.nextInt();
            long[] nums = new long[n];
            for(int i = 0; i < n; i++){
                nums[i] = cin.nextLong();
            }
            int sum = 0;
            for(int i = 0; i < n; i ++){
                for(int j =0; j <i;j ++){
                    sum += countBit(nums[i],nums[j]);
                }
            }
            System.out.println(sum);
        }
    }
    public static int countBit(long m, long n) {
        long temp = m^n;
        int count = 0;
        while (temp != 0) {
            temp = temp & (temp-1);
            count ++;
        }
        return count;
    }
}
