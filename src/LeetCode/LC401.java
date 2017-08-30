package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mercop on 2017/8/30.
 * 二进制表
 */
public class LC401 {
    public static void main(String[] args) {
        int[] nums =new int[]{1,0,1,0,0,0,0,0,0,0};
        System.out.println(getTime(nums));
        System.out.println(readBinaryWatch(2));
    }
    static List<String> lists = new ArrayList<>();

    public static void getAllCombinations(int num,int[] res, int index){

        if(num == 0) {
            String str = getTime(res);
            if(str != null)
                lists.add(str);
            return;
        }
        if(index == res.length) return;
        for(int i = index ; i < res.length; i ++){
            res[i] = 1;
            getAllCombinations(num - 1, Arrays.copyOf(res,res.length),i + 1);
            res[i] = 0;
        }
    }
    // 转换时间
    public static String getTime(int[] nums){
        int hour = 0;
        int minute = 0;
        for(int i =3, j = 1; i >=0; j *=2,i --){
            hour += nums[i] * j;
        }
        if(hour > 11 || hour < 0) return null;
        for(int i = 9,j = 1; i >= 4; i--,j *= 2){
            minute += nums[i] * j;
        }
        if(minute > 59 || minute < 0) return null;
        if(minute < 10){
            return String.valueOf(hour) + ":0" + String.valueOf(minute);
        } else  return String.valueOf(hour) + ":" + String.valueOf(minute);
    }

    public static List<String> readBinaryWatch(int num) {
        getAllCombinations(num,new int[10],0);
        return lists;
    }
}
