package contest.baidu;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by mercop on 2017/9/11.
 */
public class baidu02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int nums[] = new int[n];
        int res[] = new int[n - k + 1];
        int sum = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0, j = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            if (i < k) {
                priorityQueue.offer(nums[i]);
                sum += nums[i];
                if(i == k -1) res[j++] = sum;
            } else if (priorityQueue.peek() < nums[i]) {
                sum-=priorityQueue.poll();
                priorityQueue.offer(nums[i]);
                sum+=nums[i];
                res[j++] = sum;
            } else{
                res[j++] = sum;
            }

        }
        System.out.println(Arrays.toString(res));
    }
}
