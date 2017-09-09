package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mercop on 2017/9/6.
 * 给定不同面值的硬币，问最少需要多少枚，可以凑成指定金额
 * <p>
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * <p>
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 */
public class LC322 {
    public static void main(String[] args) {
        int[] coins = {1,2,5, 10};
        System.out.println(coinChange(coins, 27));
        int[] coins2 = {1,2,5};
        System.out.println(coinChange(coins2, 11));
    }
    //动态规划思路
    //状态转移方程：f(x,a) = min(f(x - 1, a),f(x - 1,a - nums[x]) + 1)
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins == null || coins.length == 0) return -1;
        int len = 0;
        int[] subLen = new int[coins.length];
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < coins.length; i++) {
            set.add(coins[i]);
            subLen[i] = amount / coins[i];
            len += subLen[i];
        }
        if (len == 0) return -1;
        Arrays.sort(coins);
        int[] allCoins = new int[len];
        int k = 0;
        for (int i = 0; i < subLen.length; i++) {
            for (int j = 1; j <= subLen[i]; j++) {
                //优化，如果该元素的倍数在数组中可以找到，则不继续加入
                //例如：1，3-> 1的个数最多为2
                if(j != 1 && set.contains(coins[i] * j)) break;
                allCoins[k++] = coins[i];
            }
        }

        int[] memo = new int[amount + 1];
        for (int j = 0; j < amount + 1; j++) {
            if (j % allCoins[0] == 0) {
                memo[j] = j / allCoins[0];
            } else memo[j] = -1;
        }
        //[1,len]优化为[1,k]
        for (int i = 1; i < k; i++) {
            for (int j = amount; j >= allCoins[i]; j--) {
                if (memo[j] == -1) {
                    memo[j] = memo[j - allCoins[i]];
                } else {
                    if (memo[j - allCoins[i]] != -1) memo[j] = Integer.min(memo[j], memo[j - allCoins[i]] + 1);
                }
            }
        }
        return memo[amount];
    }
}
