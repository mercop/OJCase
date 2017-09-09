package basement;

import org.junit.Test;

/**
 * Created by mercop on 2017/9/6.
 */
public class Knapsack {

    public static void main(String[] args) {
        int[] w = new int[]{1, 2, 3};
        int[] v = new int[]{6, 12, 10};
        System.out.println(knapsack01(w, v, 5));
    }

    //背包问题01 空间复杂度O(n*C)
    public static int knapsack01(int[] weight, int[] values, int w) {
        int n = weight.length;
        int[][] memo = new int[n][w + 1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < w + 1; j++) {
                memo[i][j] = -1;
            }

        for (int j = 0; j < w + 1; j++) {
            memo[0][j] = j >= weight[0] ? values[0] : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < w + 1; j++) {
                memo[i][j] = memo[i - 1][j];
                if (j >= weight[i]) {
                    memo[i][j] = Integer.max(memo[i][j], values[i] + memo[i - 1][j - weight[i]]);
                }
            }
        }
        return memo[n - 1][w];
    }

    //背包问题02 - 空间复杂度优化O(2 * C)
    //用两行空间交替存储memo值,0，2，4...存储在第0行，1，3，5...存储在第1行
    public static int knapsack02(int[] weight, int[] values, int w) {
        int n = weight.length;
        int[][] memo = new int[2][w + 1];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < w + 1; j++) {
                memo[i][j] = -1;
            }

        for (int j = 0; j < w + 1; j++) {
            memo[0][j] = j >= weight[0] ? values[0] : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < w + 1; j++) {
                memo[i % 2][j] = memo[(i - 1) % 2][j];
                if (j >= weight[i]) {
                    memo[i % 2][j] = Integer.max(memo[i % 2][j], values[i] + memo[(i - 1) % 2][j - weight[i]]);
                }
            }
        }
        return memo[(n - 1) % 2][w];
    }

    //背包问题03 - 空间复杂度优化O(1 * C)
    public static int knapsack03(int[] weight, int[] values, int w) {
        int n = weight.length;
        int[] memo = new int[w + 1];
            for (int j = 0; j < w + 1; j++) {
                memo[j] = -1;
            }
        for (int j = 0; j < w + 1; j++) {
            memo[j] = j >= weight[0] ? values[0] : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = w; j >= weight[i]; j--) {
                memo[j] = Integer.max(memo[j], memo[j - weight[i]] + values[i]);
            }
        }
        return memo[w];
    }

    @Test
    public void test(){
        int[] w = new int[]{1, 2, 3};
        int[] v = new int[]{6, 12, 10};
        System.out.println(knapsack01(w, v, 5));
        System.out.println(knapsack02(w, v, 5));
        System.out.println(knapsack03(w, v, 5));
    }
}
