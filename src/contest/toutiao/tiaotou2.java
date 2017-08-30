package contest.toutiao;

import org.junit.Test;

import java.util.*;

/**
 * Created by mercop on 2017/8/22.
 *
 * 超时
 * https://www.nowcoder.com/discuss/34193
 *
 */

public class tiaotou2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextInt()){
            int n = cin.nextInt();
            int[] nums = new int[n];
            int max = -1;
            for(int i = 0 ; i < n ; i++){
                int val = cin.nextInt();
                nums[i] = val;
                val = val * val;
                if(val > max) max = val;
            }
            Arrays.sort(nums);
            int[] sum = new int[n];
            sum[0] = nums[0];
            for(int i = 1 ; i < n; i ++)
                sum[i] = nums[i] + sum[i -1];

            for(int i = 0; i < n; i ++)
                for(int j = i + 1; j < n; j ++){
                    int val = (sum[j] - sum[i] + nums[i]) * nums[i];
                    if(val > max) max = val;
                }
            System.out.println(max);
        }

    }




    //解法

    public static int solution(int n, int[] nums) {

        //preSum[i] 表示 sum[0]~sum[i]的和
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }

        int retMax = 0;
        //range length is L
        for (int L = 1; L <= n; L++) {
            //滑动窗口，保持最小
            Deque<Integer> Q = new ArrayDeque<Integer>();

            for (int j = 0; j < n; j++) {
                //remove numbers out of range
                while( !Q.isEmpty() && Q.peekFirst() < j - L + 1) {
                    Q.pollFirst();
                }

                //remove smaller numbers which are unuseless.
                while( !Q.isEmpty() && nums[Q.peekLast()] >= nums[j] ) {
                    Q.pollLast();
                }
                Q.offerLast(j);

                if (j >= L - 1) {
                    retMax = Math.max( retMax, nums[Q.peekFirst()] * getSumInRange(preSum, j - L + 1, j) );
                }
            }
        }
        return retMax;
    }

    /*
    * 单调栈法
    以第nums[i]为最小数，找到nums[left]，nums[right],
    使得min( nums[left]~nums[right] ) = nums[i], 且区间[left, right]最大, 其中left < i < right
    */
    public static int solution2(int n, int[] nums) {
        //preSum[i] 表示 sum[0]~sum[i]的和
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }

        int retMax = 0;
        //单增栈
        Stack<Integer> stIdx = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            // System.out.printf("==i:%d==\n", i);
            while( !stIdx.empty() && nums[stIdx.peek()] >= nums[i] ) {
                int curIndex = stIdx.pop();
                int curMinNum = nums[curIndex];
                int preIndex = stIdx.empty() ? -1 : stIdx.peek();

                retMax = Math.max( retMax, curMinNum * getSumInRange(preSum, preIndex + 1, i - 1) );
                // System.out.printf("retMax:%d stSize:%d curIndex:%d curMinNum:%d [left,right]:[%d,%d]\n",
                // 	retMax, stIdx.size(), curIndex, curMinNum, preIndex + 1, i - 1);
            }
            stIdx.push(i);
        }

        if ( !stIdx.empty() ) {
            int Rindex = stIdx.peek() + 1;
            while( !stIdx.empty() ) {
                int curIndex = stIdx.pop();
                int curMinNum = nums[curIndex];
                int preIndex = stIdx.empty() ? -1 : stIdx.peek();

                retMax = Math.max( retMax, curMinNum * getSumInRange(preSum, preIndex + 1, Rindex - 1) );
                // System.out.printf("retMax:%d stSize:%d curIndex:%d curMinNum:%d [left,right]:[%d,%d]\n",
                // 	retMax, stIdx.size(), curIndex, curMinNum, preIndex + 1, Rindex - 1);
            }
        }

        return retMax;
    }

    public static int getSumInRange(int[] preSum, int leftIdx, int rightIdx) {
        if (leftIdx == 0)
            return preSum[rightIdx];
        else
            return preSum[rightIdx] - preSum[leftIdx - 1];
    }

    @Test
    public void test() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println( solution2(n, nums) );
    }
}
