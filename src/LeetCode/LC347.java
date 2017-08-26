package LeetCode;

import java.util.*;

/**
 * Created by mercop on 2017/8/23.
 * 获得出现频率最高的K的元素
 */
public class LC347 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 2, 4, 5, 6, 6, 6, 7};
        System.out.println(topKFrequent(nums, 3));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        int len = nums.length;

        Integer count;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if ((count = map.get(num)) == null)
                map.put(num, 1);
            else
                map.put(num, count + 1);
        }
        //k > map.size()

        PriorityQueue<Pair<Integer>> priorityQueue = new PriorityQueue<>();
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer, Integer> entry = (Map.Entry) iter.next();
            if (priorityQueue.size() < k)
                priorityQueue.offer(new Pair<>(entry.getKey(), entry.getValue()));
            else {
                int minCount = priorityQueue.peek().getValue();
                if (entry.getValue() > minCount) {
                    priorityQueue.poll();
                    priorityQueue.offer(new Pair<>(entry.getKey(), entry.getValue()));
                }
            }
        }
        /* Deque<Integer> deque = new LinkedList<>();
        while(!priorityQueue.isEmpty()){
            deque.push(priorityQueue.poll().getKey());
        }
        while(k -- > 0){
            result.add(deque.pop());
        }*/
        while (!priorityQueue.isEmpty()) {
            result.add(priorityQueue.poll().getKey());
        }
        return result;
    }

    static class Pair<K> implements Comparable<Pair> {
        private K key;

        public K getKey() {
            return key;
        }

        private Integer value;

        public Integer getValue() {
            return value;
        }

        public Pair(K key, Integer value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            return this.getValue() - o.getValue();
        }
    }
}
