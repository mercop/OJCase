package LeetCode;

/**
 * Created by mercop on 2017/9/4.
 * 动态规划实现爬楼梯问题
 */
public class LC70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(10));
    }

    public static int climbStairs(int n) {
        int[] climbs = new int[n + 1];
        climbs[0] = 1;
        climbs[1] = 1;
        for(int i = 2; i <= n; i++){
            climbs[i] = climbs[i -1] + climbs[i -2];
        }
        return climbs[n];
    }
}
