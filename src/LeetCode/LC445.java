package LeetCode;

import model.LinkList;
import model.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mercop on 2017/8/21.
 * Add Two Numbers II
 * 两个链表位数 相加
 */

public class LC445 {
    public static void main(String[] args) {
        LinkList<Integer> l1 = new LinkList<>(new int[]{1,8,2});
        LinkList<Integer> l2 = new LinkList(new int[]{3,5,1});
        System.out.println(addTwoNumbers(l1.getHead().next,l2.getHead().next));
    }

    public static ListNode addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {

        ListNode<Integer> result =new ListNode<>(-1);
        ListNode<Integer> p = result;
        Deque<Integer> deque1 = new LinkedList<Integer>();
        Deque<Integer> deque2 = new LinkedList<Integer>();

        Deque<Integer> deque3 = new LinkedList<Integer>();

        int carryNum = 0;

        while(l1 != null) {
            deque1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            deque2.push(l2.val);
            l2 = l2.next;
        }

        while(!deque1.isEmpty() || !deque2.isEmpty()){
            int num1 = deque1.isEmpty() ? 0 : deque1.pop();
            int num2 = deque2.isEmpty() ? 0 : deque2.pop();
            int sum = carryNum + num1 + num2;
            carryNum = sum / 10;
            deque3.push(sum % 10);
        }

        if(carryNum > 0)
            deque3.push(carryNum);
        while(!deque3.isEmpty()){
            p.next = new ListNode(deque3.pop());
            p = p.next;
        }

        return result.next;
    }
}
