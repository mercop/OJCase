package basement;

/**
 * Created by mercop on 2017/9/7.
 * 最长公共子序列
 *   LCS(m,n) 表示S1串 (0,m),S2串 (0,n)的最长公共子序列
     LCS(m,n) = LCS(m-1,n-1) + 1 if S1(m) == S2(n);
     LCS(m,n) = max(LCS(m-1,n),LCS(m,n-1))
 */
public class LCS {

    public static void main(String[] args) {
        String s1 = "ABCDFxxx";
        String s2 = "ACEDVFx";
        System.out.println(findMaxLenSeq(s1,s2));
        System.out.println(findMaxLenOfSubsequence2(s1,s2));
    }
    public static int findMaxLenSeq(String s1, String s2){
        int len1 = s1.toCharArray().length;
        int len2 = s2.toCharArray().length;
        memo = new int[len1][len2];
        for(int i =0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                memo[i][j] = -1;
            }
        }
        return findMaxLenOfSubsequence(s1,s2,len1 -1 ,len2 -1);
    }
    //暴力递归 + 记忆化搜索
    public static int findMaxLenOfSubsequence(String s1, String s2, int m, int n) {
        if (m < 0 || n < 0) return 0;
        if(memo[m][n] != -1) return memo[m][n];
        int res;
        if (s1.charAt(m) == s2.charAt(n))
            res = findMaxLenOfSubsequence(s1, s2, m - 1, n - 1) + 1;
        else
            res = Integer.max(findMaxLenOfSubsequence(s1,s2,m-1,n),findMaxLenOfSubsequence(s1,s2,m,n-1));
        memo[m][n] = res;
        return res;
    }
    static int[][] memo;


    //动态规划求解
    public static int findMaxLenOfSubsequence2(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) return 0;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int len1 = chars1.length;
        int len2 = chars2.length;
        int[][] memo = new int[len1][len2];
        char s20 = s2.charAt(0);
        int k =0;
        while(k < len1 &&s20 != s1.charAt(k)) k ++;

        for(int i = k; i < len1; i++) memo[i][0] = 1;
        char s10 = s1.charAt(0);
        k = 0;
        while(k < len2 && s10 != s2.charAt(k)) k ++;
        for(int j = k;j < len2; j++) memo[0][j] = 1;

        for(int i = 1; i < len1; i ++){
            for(int j = 1; j< len2; j++){
                if(s1.charAt(i) == s2.charAt(j)) memo[i][j] = 1 + memo[i - 1][j - 1];
                else memo[i][j] = Integer.max(memo[i - 1][j],memo[i][j - 1]);
            }
        }
        return memo[len1 -1][len2 -1];
    }
}
