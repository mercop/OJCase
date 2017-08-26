package LeetCode;

import model.LinkList;
import model.ListNode;
import org.junit.Test;

import java.util.*;

/**
 * Created by mercop on 2017/8/23.
 * K个有序数组归并为一个有序数组
 * 优先队列、堆排序
 */
public class LC23 {
    public static void main(String[] args) {
        LinkList linkList1 = new LinkList(new int[]{1,3,5,7,9});
        LinkList linkList2 = new LinkList(new int[]{2,4,6,8,10,12,15});
        System.out.println(mergeKLists(new ListNode[]{linkList1.getHead().next,linkList2.getHead().next}));
    }

    //超时 -- 优先级队列很耗时
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode(-1);
        PriorityQueue<ListNode<Integer>> priorityQueue = new PriorityQueue<>(new Comparator<ListNode<Integer>>() {
            @Override
            public int compare(ListNode<Integer> o1, ListNode<Integer> o2) {
                return o1.val - o2.val;
            }
        });
        for(int i = 0 ; i < lists.length; i ++){
            ListNode head = lists[i];
            while(head!=null){
                priorityQueue.offer(head);
                head = head.next;
            }
        }
        ListNode p = dummyHead;
        while(!priorityQueue.isEmpty()){
            p.next = priorityQueue.poll();
            p = p.next;
        }
        p.next = null;

        return dummyHead.next;
    }

    @Test
    public void test(){
        LinkList linkList1 = new LinkList(new int[]{1,2});
        LinkList linkList2 = new LinkList(new int[]{3,4});
        System.out.println(mergeKLists2(new ListNode[]{linkList1.getHead().next,linkList2.getHead().next}));

    }

    //采用双端队列替代 -- 超时
    public static ListNode mergeKLists2(ListNode<Integer>[] lists) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        Deque<ListNode> deque = new LinkedList<>();
        int len = lists.length;
        LinkedList<ListNode<Integer>> currentPos = new LinkedList<>();
        for(int i = 0 ; i < len; i ++) {
            if(lists[i] != null)
                currentPos.add(lists[i]);
        }

        while(currentPos.size() > 1){
            int minIndex = -1;
            ListNode<Integer> listNode = new ListNode(Integer.MAX_VALUE);
            //int minVal = Integer.MAX_VALUE;
            for(int i = 0 ; i < currentPos.size(); i ++){
                if(listNode.val > currentPos.get(i).val){
                    listNode = currentPos.get(i);
                    minIndex = i;
                }
            }
            if(listNode.val == Integer.MAX_VALUE) break;
            p.next = listNode;
            p = p.next;
            if(listNode.next == null){
                currentPos.remove(listNode);
            }
            else {
                currentPos.set(minIndex,currentPos.get(minIndex).next);
            }
        }
        if(currentPos.size() > 0)
            //最后一个直接添加
            p.next = currentPos.getFirst();
        return dummyHead.next;
    }
}
