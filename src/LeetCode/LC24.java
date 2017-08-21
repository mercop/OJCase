package LeetCode;

import model.LinkList;
import model.ListNode;

/**
 * Created by mercop on 2017/8/21.
 * 交换链表的节点对
 */

public class LC24 {

    public static void main(String[] args) {
        LinkList list = new LinkList(new int[]{1,2,3,4,5});
        System.out.println(swapPairs(list.getHead().next));
    }

    public static ListNode swapPairs(ListNode head) {

        ListNode<Integer> dummyNode = new ListNode<>(-1);
        dummyNode.next = head;
        ListNode<Integer> p = dummyNode;

        while(p.next != null && p.next.next != null){
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            node2.next = node1;
            node1.next = next;
            p.next = node2;

            p = node1;
        }
        return dummyNode.next;
    }
}
