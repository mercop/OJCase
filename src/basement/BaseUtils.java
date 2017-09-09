package basement;

import org.junit.Test;

/**
 * Created by mercop on 2017/9/5.
 * 1.   递归求解幂运算
 * 2.   判断一个数是否是素数
 * 3.   交换两个数
 * 4.   获得一个数的位数
 * 5.   整数转字符串
 * 6.   字符串反转
 * 7.   三数最小
 * 8.   三数最大
 */
public class BaseUtils {

    @Test
    public void test() {
        System.out.println(pow(0,-1));
        System.out.println(pow(2.0,5));
        System.out.println(pow(2.0,4));
    }
    //递归求解幂运算
    public static double pow(double x, int n){
        if(n == 0)
            return 1;
        double t = pow(x,n/2);
        if(n % 2 == 1)
            return t * t * x;
        else
            return t * t;
    }

    //判断一个数是否是素数
    public static boolean isPrime(int n){
        if(n == 1 || n ==0)
            return false;
        for(int i = 2; i * i < n; i ++){
            if(n % i == 0)
                return false;
        }
        return true;
    }

    //交换两个数
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    //获得一个数的位数
    final static int [] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE };
    static int stringSize(int x) {
        for (int i=0; ; i++)
            if (x <= sizeTable[i])
                return i+1;
    }

    //整数转字符串
    public static String IntToString(int num){
        String result = "";
        while(num > 0){
            int digit =  num % 10;
            result += String.valueOf(digit);
            num /= 10;
        }

        return reverse(result);
    }

    //字符串反转
    public static String reverse(String originStr){
        if(originStr == null || originStr.length() <= 1)
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }

    //三数最大ba
    public static int min3(int a, int b, int c){
        return a > b ? Integer.max(b,c):Integer.max(a,c);
    }

    //三数最大
    public static int max3(int a, int b, int c){
        return a > b ? Integer.max(a,c):Integer.max(b,c);
    }
}
