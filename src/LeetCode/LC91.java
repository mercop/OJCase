package LeetCode;


/**
 * Created by mercop on 2017/9/5.
 * 字母与数字一一对应，给定一个数字，求其解码可能性
 */
public class LC91 {

    public static void main(String[] args) {
        String s = "1234";
        System.out.println(numDecodings(s));
    }

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] sa = s.toCharArray();
        int[] nums = new int[sa.length+1];
        nums[0] = 1;
        for(int i=1; i<=sa.length; i++) {
            if (sa[i-1] != '0') nums[i] += nums[i-1];
            if (i>1 && sa[i-2] == '1') nums[i] += nums[i-2];
            if (i>1 && sa[i-2] == '2' && sa[i-1] >= '0' && sa[i-1] <= '6') nums[i] += nums[i-2];
        }
        return nums[sa.length];
    }
}
