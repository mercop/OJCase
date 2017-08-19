package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mercop on 2017/8/16.
 * 找到含有相同字符的 组
 */

public class LC49 {

    //Time Limit Exceeded
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> result = new HashMap<String,List<String>>();
        int len = strs.length;
        boolean founded;
        for(int i = 0; i < len ; i++){
            founded = false;
            for(String str: result.keySet()){
                if(isAnagram(str,strs[i])){
                    result.get(str).add(strs[i]);
                    founded = true;
                    break;
                }
            }
            if(!founded){
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                result.put(strs[i],list);
            }
        }
        List<List<String>> resultList = new ArrayList<List<String>>(result.values());
        return resultList;
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
