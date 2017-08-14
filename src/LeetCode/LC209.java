package LeetCode;

/**
 * Created by mercop on 2017/8/14.
 *  最短连续子数组，使得和大于 S给定值
 */

public class LC209 {

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,arr));
    }

    public static int minSubArrayLen(int s ,int[] nums){
        if(nums == null || nums.length <=0 || s > nums.length)
            return 0;
        int i = 0;
        int j = -1;
        int len = nums.length;
        int minLen = len + 1;
        int total = 0;
        while(i < len){
            if(j + 1 <len&&total < s){
                total +=nums[++j];
            }
            else{
                total -= nums[i++];
            }
            if(total >= s && minLen > j - i + 1)
                minLen = j - i + 1;
        }
        if(minLen == len + 1)
            return 0;
        return minLen;
    }
}
