package basement;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by mercop on 2017/8/23.
 * 优先级队列测试例子
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        //默认为小根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Random ra = new Random();
        for(int i =0; i < 10; i++){
            int num = ra.nextInt(100);
            System.out.println("offer num : " + num);
            priorityQueue.offer(num);
        }

        while(!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }

        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i =0; i < 10; i++){
            int num = ra.nextInt(100);
            System.out.println("offer num : " + num);
            priorityQueue2.offer(num);
        }

        while(!priorityQueue2.isEmpty()){
            System.out.println(priorityQueue2.poll());
        }
    }
}
