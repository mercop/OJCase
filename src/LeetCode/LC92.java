package LeetCode;

import model.LinkList;
import model.ListNode;

/**
 * Created by mercop on 2017/8/18.
 * 从M,到N反转链表
 */

public class LC92 {
    public static void main(String[] args) {
        LinkList list = new LinkList(new int[]{1,2,3});
        ListNode node = list.getHead().next;
        System.out.println(reverseBetween(node,1,2));
    }

    public static ListNode reverseBetween(ListNode<Integer> head, int m, int n) {
        if(head == null ||head.next == null || m == n){
            return head;
        }
        ListNode<Integer> pre = null;
        ListNode<Integer> cur = head;
        ListNode<Integer> next = null;
        ListNode<Integer> mBefore = head;

        int between = n - m + 1;
        while(cur != null && -- m > 0){
            pre = cur;
            cur = cur.next;
        }
        if(cur ==null)
            return head;
        if(pre != null) mBefore = pre;

        while(cur != null && between -- > 0){
            next =cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if(mBefore.next == null){
            head.next = cur;
            head = pre;
        }
        else {
            mBefore.next.next = cur;
            mBefore.next = pre;
        }

        return head;
    }
}
