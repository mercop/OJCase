package LeetCode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
/**
 * Created by mercop on 2017/8/16.
 * 同LC167 ,不同之处在于数组无序
 * 给定一个无序数组，和一个整数target，找到两个元素，使其等于target，返回索引(索引从1开始)
 * 查找表实现
 */

public class LC1 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2};
        System.out.println(Arrays.toString(twoSum(nums,4)));
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int len = nums.length;

        // 问题：{2，2}这种情况，map只存一次，不过LeetCode能够跑通这样的case，
        // 原因是我们覆盖相同值得元素为最后指针，而我们后序遍历时候，从头开始，
        // 这样就保证i为第一个，map里面的值为后面重复元素。
        for (int i = 0; i < len; i++){
            map.put(nums[i], i);
        }
        Integer foundIndex;
        for(int i = 0; i < len; i ++){
            if((foundIndex = map.get(target - nums[i])) != null && i != foundIndex){
                result[0] = i;
                result[1] = foundIndex;
                return result;
            }
        }
        return result;
    }

    // 更为健壮、更快的解决方法:当前值与前面的hashmap找
    @Test
    public void test(){
        int[] nums = new int[]{1,2,7,4,5,2};
        int target = 11;
        System.out.println(Arrays.toString(twoNum2(nums,target)));
    }

    public static int[] twoNum2(int[] nums,int target){
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int len = nums.length;
        map.put(nums[0],0);
        Integer foundIndex;
        for (int i = 1; i < len; i++){
            if((foundIndex = map.get(target - nums[i])) != null){
                result[1] = i;
                result[0] = foundIndex;
                return result;
            } else
                map.put(nums[i],i);
        }
        return result;
    }
}
