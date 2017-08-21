package LeetCode;

import model.LinkList;
import model.ListNode;


/**
 * Created by mercop on 2017/8/21.
 * Add Two Numbers 两个链表位数相加生成新的链表
 * 逆序
 */

public class LC2 {

    public static void main(String[] args) {
        LinkList<Integer> l1 = new LinkList<>(new int[]{1,8});
        LinkList<Integer> l2 = new LinkList(new int[]{0});
        System.out.println(addTwoNumbers(l1.getHead().next,l2.getHead().next));
    }

    public static ListNode addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> result = new ListNode<Integer>(-1);
        ListNode<Integer> p = result;
        int carryNum = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int sum = num1 + num2 + carryNum;
            carryNum = sum/10;
            p.next = new ListNode(sum % 10);
            p = p.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carryNum > 0)
            p.next = new ListNode(carryNum);
        return result.next;
    }
}
