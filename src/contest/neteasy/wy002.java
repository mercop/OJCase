package contest.neteasy;

import java.util.*;

/**
 * Created by mercop on 2017/9/9.
 */
public class wy002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        Set<String> set = permute(chars);
        set.remove(str);
        //System.out.println(set);
        int[] memo = new int[chars.length];
        int res = 0;
        for(String s : set){
            int count = findMaxLenOfSubsequence(s,str);
            memo[count] ++;
            if(memo[count] > res)
                res = memo[count];
        }
        System.out.println(res);
    }

    static Set<String> lists = new HashSet<>();

    public static Set<String> permute(char[] nums) {

        if (nums == null || nums.length == 0) return lists;

        used = new boolean[nums.length];
        generatePermutation(nums, 0, new StringBuilder(), 0);
        return lists;
    }

    static boolean[] used;

    static void generatePermutation(char[] nums, int index, StringBuilder sb, int left) {
        if (nums.length == index) {
            lists.add(sb.toString());
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (nums[i] == '(') {
                    sb.append(nums[i]);
                    used[i] = true;
                    generatePermutation(nums, index + 1, new StringBuilder(sb), left + 1);
                } else if (nums[i] == ')' && left > 0) {
                    sb.append(nums[i]);
                    used[i] = true;
                    generatePermutation(nums, index + 1, new StringBuilder(sb), left - 1);
                } else return;
                sb.deleteCharAt(sb.length() -1);
                used[i] = false;
            }
        }
    }

    public static int findMaxLenOfSubsequence(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) return 0;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int len1 = chars1.length;
        int len2 = chars2.length;
        int[][] memo = new int[len1][len2];
        char s20 = s2.charAt(0);
        int k = 0;
        while (k < len1 && s20 != s1.charAt(k)) k++;

        for (int i = k; i < len1; i++) memo[i][0] = 1;
        char s10 = s1.charAt(0);
        k = 0;
        while (k < len2 && s10 != s2.charAt(k)) k++;
        for (int j = k; j < len2; j++) memo[0][j] = 1;

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (s1.charAt(i) == s2.charAt(j)) memo[i][j] = 1 + memo[i - 1][j - 1];
                else {
                    if(memo[i - 1][j] > memo[i][j - 1] ) memo[i][j] = memo[i - 1][j];
                    else memo[i][j] = memo[i][j - 1];
                    //memo[i][j] = Integer.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }
        return memo[len1 - 1][len2 - 1];
    }
}
