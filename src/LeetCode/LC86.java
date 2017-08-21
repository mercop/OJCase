package LeetCode;

import model.LinkList;
import model.ListNode;

/**
 * Created by mercop on 2017/8/18.
 * 对链表进行Partition
 */

public class LC86 {
    public static void main(String[] args) {
        int nums[] = new int[]{1, 1};
        LinkList linkList = new LinkList(nums);
        ListNode listNode = linkList.getHead().next;
        System.out.println(partition(listNode, 0));
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        ListNode<Integer> pre = null;
        ListNode<Integer> cur = head;
        ListNode<Integer> g = null;//大于x的节点链表
        ListNode<Integer> gcur = g;
        while (cur != null) {
            if (cur.val >= x) {
                if (g == null) {
                    g = cur;
                    gcur = g;
                } else {
                    gcur.next = cur;
                    gcur = gcur.next;
                }
                if (pre == null)
                    head = cur.next;
                else
                    pre.next = cur.next;
                //cur.next = null;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        if (g != null) {
            gcur.next = null;
            if(pre != null)
                pre.next = g;
            else
                head = g;
        }
        return head;
    }
}
