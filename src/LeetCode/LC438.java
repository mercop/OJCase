package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mercop on 2017/8/15.
 * Find All Anagrams in a String
 */

public class LC438 {

    public static void main(String[] args) {

        String str = "abab";
        String p = "ab";
        System.out.println(findAnagrams(str, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> results = new ArrayList<Integer>();
        if(s == null || s.length() == 0 || p == null || p.length() == 0)
            return results;

        int[] hash = new int[256];
        char[] pp = p.toCharArray();
        for(char c : pp)
            hash[c] ++;
        int left = 0, right = 0, count = p.length();
        int len = s.length();
        while(right < len){
            if(hash[s.charAt(right++)]-- > 0)
                count --;
            if(count == 0)
                results.add(left);
            if(right - left ==  p.length() && hash[s.charAt(left++)] ++ >= 0)
                count++;
        }
        return results;
    }
}
