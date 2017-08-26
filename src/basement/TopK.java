package basement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by mercop on 2017/8/23.
 * Tok 问题
 *
 * 如果 k << n,则维护容量为k的优先队列
 * 如果 k 几乎= n,则维护容量为n-k的优先队列
 */
public class TopK {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4,6,22,3,44,55,9};
        System.out.println(topK(nums,3));
    }

    public static List<Integer> topK(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        if(k >= len){
            for(int num : nums)
                result.add(num);
            return result;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i = 0 ; i < nums.length; i ++){
            priorityQueue.offer(nums[i]);
        }

        while(k -- > 0){
            result.add(priorityQueue.poll());
        }
        return result;
    }
}
