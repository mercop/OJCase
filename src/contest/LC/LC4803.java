package contest.LC;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by mercop on 2017/9/3.
 *
 *   Input: 2736
     Output: 7236
     Explanation: Swap the number 2 and the number 7.

 */
public class LC4803 {
    public static void main(String[] args) {
        //int x = 98368;
        int x = 99088;
        System.out.println(maximumSwap(x));
    }
    final static int [] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE };
    static int stringSize(int x) {
        for (int i=0; ; i++)
            if (x <= sizeTable[i])
                return i+1;
    }

    public static int maximumSwap(int num) {
        int size = stringSize(num);
        int[] nums = new int[size];
        int[] maxPos = new int[10];
        int i = size -1;
        PriorityQueue<Pair<Integer,Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                if(o1.key == o2.key) return o2.value - o1.value;
                else return o2.key - o1.key;
            }
        });

        while(num > 0){
            int digit =  num % 10;
            priorityQueue.offer(new Pair<>(digit,i));
            if(maxPos[digit] == 0) maxPos[digit] = i;
            nums[i--] = digit;
            num /= 10;
        }
        for(i =0; i < size; i++){
            if(nums[i] == priorityQueue.peek().key){
                priorityQueue.poll();
            }else {
                Pair<Integer,Integer> pair = priorityQueue.poll();
                int temp = nums[i];
                nums[i] = pair.key;
                nums[maxPos[pair.key]] = temp;
                break;
            }
        }
        String result = "";
        for(i = 0 ; i < size; i++){
            result += String.valueOf(nums[i]);
        }
        return Integer.parseInt(result);
    }

    static class Pair<K,V> {
        private K key;
        private V value;
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
