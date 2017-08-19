package LeetCode;

import java.util.*;

/**
 * Created by mercop on 2017/8/16.
 * 求交集 hash表
 */

public class LC350 {

    public static void main(String[] args) {
        int[] a = new int[]{-2147483648,1,2,3};
        int[] b = new int[]{1,-2147483648,-2147483648,2};
        System.out.println(Arrays.toString(intersect(a,b)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[0];
        int len1 = nums1.length;
        int len2 = nums2.length;

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        List<Integer> list = new ArrayList<>();
        if (len1 < len2) {
            for (int num : nums1){
                if(map.get(num) == null)
                    map.put(num,1);
                else{
                    int before = map.get(num);
                    map.put(num,before + 1);
                }
            }
            for (int num : nums2){
                Integer i = map.get(num);
                if(i != null && i > 0){
                    list.add(num);
                    map.put(num,i-1);
                }
            }
        } else {
            for (int num : nums2){
                if(map.get(num) == null)
                    map.put(num,1);
                else{
                    int before = map.get(num);
                    map.put(num,before + 1);
                }
            }
            for (int num : nums1){
                Integer i = map.get(num);
                if(i != null && i > 0){
                    list.add(num);
                    map.put(num,i-1);
                }
            }
        }
        int[] result = new int[list.size()];
        int i = 0;
        for (int num : list)
            result[i++] = num;
        return result;
    }
}
