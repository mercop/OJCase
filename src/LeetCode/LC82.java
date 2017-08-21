package LeetCode;

import model.LinkList;
import model.ListNode;

/**
 * Created by mercop on 2017/8/21.
 *
 * Remove Duplicates from Sorted List II
 * 链表去除为重复的元素例如：1，2，2，3 return ： 1->3
 */

public class LC82 {

    public static void main(String[] args) {
        LinkList list = new LinkList(new int[]{1,1});
        ListNode node = list.getHead().next;
        System.out.println(deleteDuplicates(node));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode<Integer> dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode<Integer> cur = dummyHead.next;
        ListNode<Integer> pre = dummyHead;
        while(cur.next != null){
            if(cur.val != cur.next.val){
                if(pre.next == cur)// 只有确保pre.next = cur时候保证，cur这个数不存在重复
                    pre = cur;
                else pre.next = cur.next; // pre的next动态去指向当前不等元素，但是不挪动。
            }
            cur = cur.next;
        }
        if(pre.next != cur) pre.next = cur.next;
        return dummyHead.next;
    }
}
