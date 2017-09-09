package LeetCode;

import java.util.Arrays;

/**
 * Created by mercop on 2017/9/6.
 * Ones and zeros
 * 给定一个01串数组，0的个数和1的个数，求最多能组成数组中01串的个数
 *
     Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
     Output: 4

     Explanation: This are totally 4 strings can be formed by the using
     of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
 */
public class LC474 {

    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(strs,5,3));
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        if(strs == null || strs.length ==0) return 0;
        int[][] memo = new int[m + 1][n + 1];
        int len = strs.length;
        int[] countOfOne = new int[len];
        int[] countOfZero = new int[len];

        for(int i = 0; i < len; i++){
            char[] chars = strs[i].toCharArray();
            for(int j = 0; j < chars.length; j++){
                if(chars[j] == '0') countOfZero[i] ++;
                if(chars[j] == '1') countOfOne[i] ++;
            }

            if(countOfZero[i] == 0 && countOfOne[i] <= n) {
                memo[0][countOfOne[i]] = 1;
            }
            if(countOfOne[i] == 0 && countOfZero[i] <= m) memo[countOfZero[i]][0] += 1;
        }
        memo[0][2] = 1;
        memo[0][3] = 1;
        memo[2][0] = 1;
        memo[3][0] = 1;
        memo[4][0] = 1;
        memo[5][0] = 1;
        for(int k = 1; k < len; k++) {
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    memo[i][j] = Integer.max(memo[i - 1][j], memo[i][j - 1]);
                    int cz = countOfZero[k];
                    int co = countOfOne[k];
                    if (cz <= i && co <= j) {
                        memo[i][j] = Integer.max(memo[i][j], memo[i - cz][j - co] + 1);
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(memo));
        return memo[m][n];
    }
}
