package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by mercop on 2017/8/31.
 * IPO,满足起始资金则启动项目，求最后的captical
 */
public class LC502 {
    public static void main(String[] args) {
       int p[] = new int[]{1,2,3};
       int c[] = new int[]{1,1,2};
        System.out.println(findMaximizedCapital(1,2,p,c));
     }

    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {

        int totalProfits = W;

        PriorityQueue<Work> capitalQueue = new PriorityQueue<>(new Comparator<Work>() {
            @Override
            public int compare(Work o1, Work o2) {
                return o1.capital - o2.capital;
            }
        });

        PriorityQueue<Work> profitQueue = new PriorityQueue<>(new Comparator<Work>() {
            @Override
            public int compare(Work o1, Work o2) {
                return o2.profit - o1.profit;
            }
        });

        for(int i =0; i < Profits.length; i ++){
            capitalQueue.offer( new Work(Profits[i],Capital[i]));
        }
        while(k > 0){
            while(!capitalQueue.isEmpty() && capitalQueue.peek().capital <= W){
                profitQueue.offer(capitalQueue.poll());
            }
            if(!profitQueue.isEmpty()){
                Work work = profitQueue.poll();
                W +=work.profit;
                k --;
                totalProfits += work.profit;
            } else return totalProfits;
        }
        return totalProfits;
    }

    static class Work{
        int profit;
        int capital;
        public Work(int profit,int capital){
            this.capital = capital;
            this.profit = profit;
        }
    }
}
