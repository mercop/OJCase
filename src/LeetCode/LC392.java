package LeetCode;

/**
 * Created by mercop on 2017/9/9.
 * 给定两个字符串，问s是不是t的子串
 */
public class LC392 {
    public static void main(String[] args) {
        String s = "abd";
        String t = "abcdedf";
        System.out.println(isSubsequence(s,t));
    }

    public static boolean isSubsequence(String s, String t) {
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        int j = 0;
        int count =0;
        for(int i =0;j < tchars.length && i < schars.length; i ++){
            while(j < tchars.length){
                if(schars[i] == tchars[j++]) {
                    count ++;
                    break;
                }
            }
        }
        if(count == schars.length) return true;
        else return false;
    }
}
