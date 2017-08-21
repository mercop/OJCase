package LeetCode;

import model.LinkList;
import model.ListNode;

/**
 * Created by mercop on 2017/8/21.
 * 删除链表的所有指定节点
 */

public class LC203 {
    public static void main(String[] args) {
        LinkList list = new LinkList(new int[]{3, 3, 2, 3, 4, 3});
        ListNode node = list.getHead().next;
        System.out.println(removeElements(node, 3));
    }

    public static ListNode removeElements(ListNode<Integer> head, int val) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode<Integer> cur = newHead;

        while (cur.next != null) {
            if (cur.next.val == val) {
                ListNode delNode = cur.next;
                cur.next = delNode.next;
                delNode.next = null;
            } else cur = cur.next;
        }
        return newHead.next;
    }
}
