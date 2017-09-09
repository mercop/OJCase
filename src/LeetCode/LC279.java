package LeetCode;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by mercop on 2017/8/23.
 * 寻找最少的完全平方数，是他们的和为n,转为有向图层次遍历
 */
public class LC279 {

    public static void main(String[] args) {
        int n = 13;
        System.out.println(numSquares(n));
        System.out.println(numSquares(7168));
    }

    public static int numSquares(int n) {
        Deque<Pair<Integer,Integer>> deque = new LinkedList<>();
        //加入一个数组判断节点是否已被访问
        boolean[] visited = new boolean[n + 1];
        deque.offer(new Pair<>(n,0));
        visited[n] = true;
        while(!deque.isEmpty()){
            Pair<Integer,Integer> p = deque.poll();
            int num = p.getKey();
            int count = p.getValue();
            //性能问题，重复推入很多数字
            for(int i = 1; ; i ++){
                int a = num - i*i;
                if(a < 0) break;
                if(a == 0) return count + 1;
                if(!visited[a]){
                    deque.offer(new Pair<>(a,count + 1));
                    visited[a] = true;
                }

            }
        }
        return -1;
    }

    static class Pair<K,V> {
        private K key;
        public K getKey() {
            return key;
        }
        private V value;
        public V getValue() {
            return value;
        }
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    //动态规划思路
    public static int numSquares2(int n) {
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for(int i= 2; i < nums.length; i++)
            nums[i] = Integer.MAX_VALUE;
        for(int i = 2; i < n + 1; i++){
            for(int j = 1;; j++){
                int k = j * j;
                if(k > i) break;
                if (k == i) {
                    nums[i] = 1;
                    break;
                }
                else nums[i] = Integer.min(nums[i],nums[i - k] + 1);
            }
        }
        return nums[n];
    }

    @Test
    public void test(){
        int n = 7168;
        System.out.println(numSquares(n));
        System.out.println(numSquares2(n));
        //System.out.println(numSquares(7168));
    }
}
