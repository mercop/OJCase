package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mercop on 2017/8/16.
 * 求两个数组的公共元素
 */

public class LC349 {
    public static void main(String[] args) {
        int[] a= new int[]{4,7,9,7,6,7};

        int[] b = new int[]{5,0,0,6,1,6,2,2,4};
        System.out.println(Arrays.toString(intersection(a,b)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null||nums2 ==null || nums1.length ==0 || nums2.length == 0)
            return new int[0];
        int len1= nums1.length;
        int len2 = nums2.length;
        Set<Integer> numsSet;
        Set<Integer> resultSet = new HashSet<Integer>();
        if(len1 < len2){
            numsSet = new HashSet<Integer>(len1);
            for(int i : nums1)
                numsSet.add(i);
            for(int j : nums2){
                if(numsSet.contains(j))
                    resultSet.add(j);
            }
        } else{
            numsSet = new HashSet<Integer>(len2);
            for(int i : nums2)
                numsSet.add(i);
            for(int j : nums1){
                if(numsSet.contains(j))
                    resultSet.add(j);
            }
        }
        int[] result = new int[resultSet.size()];
        int i = 0;
        for(int num  : resultSet)
            result[i ++] = num;
        return result;
    }
}
