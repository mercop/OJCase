package LeetCode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by mercop on 2017/8/16.
 * Happy Number
 * 19 -> 1^2+9^2 = 82 ... 最后为1
 */

public class LC202 {
    public static void main(String[] args) {
        int n = 19;
        //System.out.println(isHappy(n));
        System.out.println(isHappy(103));
    }
    public static boolean isHappy(int n) {
        if(n == 1 || n == 100)
            return true;
        int[] happyNums100 = new int[]{1, 7, 10, 13, 19, 23, 28, 31, 32, 44, 49, 68, 70, 79, 82, 86, 91, 94, 97, 100};
        if(n < 100){
            if(Arrays.binarySearch(happyNums100,n) > -1)
                return true;
            else return false;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(n);
        int result = 0;
        int digit = 0;
        while(true){
            while(n > 0){
                digit =  n % 10;
                result += digit * digit;
                n /= 10;
            }
            if(result < 100){
                if(Arrays.binarySearch(happyNums100,result) > -1)
                    return true;
                else return false;
            }
            if(set.contains(result))
                return false;
            else set.add(result);
            n = result;
            result = 0;
        }
    }
}
