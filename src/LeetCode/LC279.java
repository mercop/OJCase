package LeetCode;

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
}
