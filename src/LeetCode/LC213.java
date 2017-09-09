package LeetCode;

/**
 * Created by mercop on 2017/9/6.
 * 动态规划-偷取最大值，保证不相邻,环形街区
 */
public class LC213 {

    public static void main(String[] args) {
        int[] nums = new int[]{7,6};
        System.out.println(rob(nums));
    }
    //记忆化搜索
    public static int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int n = nums.length;
        memo = new int[n];
        for(int i =0; i< n; i++)
            memo[i] = -1;
        int x = tryRob(nums,1,n);
        for(int i =0; i< n; i++)
            memo[i] = -1;
        int y = tryRob(nums,0,n-1);
        return Integer.max(x,y);
    }
    static int[] memo;
    public static int tryRob(int[] nums,int startIndex,int lastIndex){
        if(startIndex >= lastIndex) return 0;
        int res = 0;
        if(memo[startIndex] != -1) return memo[startIndex];
        for(int i = startIndex; i< lastIndex ;i++){
            res = Integer.max(res,nums[i] + tryRob(nums,i + 2,lastIndex));
        }
        memo[startIndex] = res;
        return res;
    }

}
