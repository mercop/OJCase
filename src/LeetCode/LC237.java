package LeetCode;

import model.LinkList;
import model.ListNode;

/**
 * Created by mercop on 2017/8/21.
 * 给定链表的一个节点，删除该节点
 */

public class LC237 {
    public static void main(String[] args) {
        LinkList linkList = new LinkList(new int[]{1,2,5});
        ListNode node = linkList.getHead().next.next;
        deleteNode(node);
        System.out.println(linkList.getHead().next);
    }

    public static void deleteNode(ListNode node) {
        if(node == null) return;
        if(node.next == null) {
            node = null;
            return;
        }
        ListNode delNode = node.next;
        node.val = delNode.val;
        node.next = delNode.next;
    }
}
