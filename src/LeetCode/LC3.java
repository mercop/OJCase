package LeetCode;

/**
 * Created by mercop on 2017/8/14.
 * 最短不重复子串 （滑动窗口解决）
 */

public class LC3 {

    public static void main(String[] args) {
        String str = "abcbcabdbde";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s){
        int l = 0;
        int r = -1;
        int[] freq = new int[256];
        int max = 0;
        int len = s.length();
        while(l < len){
            if(r+1 < len && freq[s.charAt(r+1)] == 0){
                freq[s.charAt(++r)] = 1; //出现频率+1
            } else{
                freq[s.charAt(l++)] = 0;
            }
            if(max < r - l + 1)
                max = r -l + 1;
        }
        return max;
    }
}
