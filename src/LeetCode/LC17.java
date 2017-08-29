package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mercop on 2017/8/29.
 * 给定一个数字，求出所有字母组合 2-9 0
 * Input:Digit string "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LC17 {
    public static void main(String[] args) {
        String digit = "";
        System.out.println(letterCombinations(digit));
    }
    final static String[] digitMap={
            " ",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };
    public static void findCombations(String digits, int index, String str){
        if(index == digits.length())
            result.add(str);
        else{
            char digit = digits.charAt(index);
            String s = digitMap[digit - '0'];
            char[] chars = s.toCharArray();
            for(int i = 0; i < chars.length; i++)
                findCombations(digits,index + 1,str + chars[i]);
        }
    }

    static List<String> result = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
        if(digits == null||digits.equals("")) return result;
        findCombations(digits,0,"");
        return result;
    }
}
