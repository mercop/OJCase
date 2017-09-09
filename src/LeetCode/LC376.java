package LeetCode;

/**
 * Created by mercop on 2017/9/7.
 * 求最长升降序列
 * LIS(i) = max(1 + LIS(j) if nums[j] >或者< nums[i]) {>,< 通过一个记录当前升降状态的数组}
 */
public class LC376 {

    public static void main(String[] args) {
        int[] nums = {1,17,5,10,13,15,10,5,16,8};
        int[] nums2 = {0,0};

        System.out.println(wiggleMaxLength(nums));
        System.out.println(wiggleMaxLength(nums2));
    }

    public static int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] memo = new int[n];
        //-1表示该元素降序状态，0表示初始状态，1表示该元素处于升序状态
        int[] status = new int[n];

        for (int i = 0; i < n; i++) {
            memo[i] = 1;
            status[i] = 0;
        }
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((status[j] == 0 && nums[i] != nums[j])||
                        (status[j] == 1 && nums[i] < nums[j]) ||
                        (status[j] == -1 && nums[i] > nums[j]))
                    if (memo[i] < 1 + memo[j]) {
                        status[i] = (nums[i] > nums[j] ? 1 : -1);
                        memo[i] = 1 + memo[j];
                    }
            }
            if(max < memo[i]) max = memo[i];
        }
        return max;
    }
}
