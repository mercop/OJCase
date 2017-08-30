package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mercop on 2017/8/29.
 * <p>
 * public List<String> restoreIpAddresses(String s) {
 * IP的所有可能性
 * }
 */
public class LC93 {

    public static void main(String[] args) {
        String str = "1111";
        System.out.println(restoreIpAddresses(str));
    }

    static List<String> result = new ArrayList<>();

    /**
     * count 表示 点的个数
     *
     * @param s
     * @param index
     * @param res
     * @param count
     */
    public static void findCombations(String s, int index, String res, int count) {
        //点大于等于4时候 退出
        if (count == 4) return;

        if (index == s.length()) {
            //s遍历完，且点为3，则加入结果集
            if(count == 3){
                result.add(res);
            }
            return;
        }

        char digit = s.charAt(index);

        if (res.length() == 0) findCombations(s, index + 1, res + digit, count);
        else {

            String[] nums = res.split("\\.");
            String lastNum;
            if (nums.length != 0)
                lastNum = nums[nums.length - 1];
            else lastNum = res;

            int num = Integer.parseInt(lastNum);
            //数字为0
            if (num == 0) {
                findCombations(s, index + 1, res + "." + digit, count + 1);
                //数字之和小于等于255，则两种选择
            } else if (num * 10 + (digit - '0') <= 255) {
                findCombations(s, index + 1, res + digit, count);
                findCombations(s, index + 1, res + "." + digit, count + 1);
            } else {
                findCombations(s, index + 1, res + "." + digit, count + 1);
            }
        }

    }

    public static List<String> restoreIpAddresses(String s) {
        if (s == null || s.equals("")) return result;
        findCombations(s, 0, "", 0);
        return result;
    }
}

