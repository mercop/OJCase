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

        int digitCount[] = new int[n];
        int lastThreeNumsCount[] = new int[n];
        for(int i =0 ; i< n;i++){
            nums[i] = sc.nextInt();
            //long res[] = getDigitCount(nums[i]);
//            digitCount[i] = res[0];
//            lastThreeNumsCount[i] =res[1];
        }
        long temp = 0;
        int res = 0;
        long count[];
        for(int i =0; i < n;i ++){
            for(int j = i; j < n; j ++){
                temp = nums[i] * 1000 + nums[j];
                if(getDigitCount(temp))res++;
            }
        }
        System.out.println(res);

    }

    public static boolean getDigitCount(long num){
        if(num / 1000 == 0) return num%7 == 0? true:false;
        long res[] = new long[2];
        int total = 0;
        int three = (int)num % 1000;
        num = num /1000;

        if(Math.abs(three - num) % 7 ==0)return true;
        else return  false;
    }
}
