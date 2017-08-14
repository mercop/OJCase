package LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by mercop on 2017/8/14.
 * 字符串反转
 */

public class LC344 {

    //对撞指针方式
    @Test
    public void test(){
        String str = "hello";
        char[] chars = str.toCharArray();
        int p = 0;
        int q = chars.length -1;
        while(p < q){
            swap(chars,p++,q--);
        }

        System.out.println(Arrays.toString(chars));
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    //递归方式
    @Test
    public void test2(){
        String str = "hello";
        System.out.println(reverse(str));
    }

    public String reverse(String originStr){
        if(originStr == null || originStr.length() <= 1)
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }
}
