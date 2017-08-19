package LeetCode;

/**
 * Created by mercop on 2017/8/16.
 * 一个字符串包含字符与另一个字符串相同
 */

public class LC242 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagarama";
        System.out.println(isAnagram(s,t));
    }

    public static boolean isAnagram(String s, String t) {

        if (s.length() == 0 && t.length() == 0)
            return true;
        if (s.length() == 0 || t.length() == 0 || s.length() != t.length())
            return false;

        int[] hash = new int[256];
        char[] schar = s.toCharArray();

        int lens = schar.length;
        int count = lens;
        for (int i = 0; i < lens; i++) {
            hash[schar[i]]++;
        }
        char[] tchar = t.toCharArray();
        int lent = tchar.length;
        for (int i = 0; i < lent; i++) {
            if (hash[tchar[i]] > 0) {
                count--;
                hash[tchar[i]]--;
            } else
                return false;
        }
        if (count == 0) return true;
        else return false;
    }
}
