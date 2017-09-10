package LeetCode;

import java.util.Arrays;

/**
 * Created by mercop on 2017/9/9.
 * 贪心算法分饼干问题
 */
public class LC455 {

    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,2};
        System.out.println(findContentChildren(g,s));
    }

    //g 小朋友的贪心指数，s为饼干的大小
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length - 1;
        int m = s.length - 1;
        int res = 0;
        while (n >= 0 && m >= 0) {
            if (g[n] <= s[m]) {
                res ++;
                n--;
                m--;
            }else n--;
        }
        return res;
    }
}
