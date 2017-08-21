package LeetCode;

import model.LinkList;
import model.ListNode;

/**
 * Created by mercop on 2017/8/21.
 * 删除倒数第N个节点
 */

public class LC19 {

    public static void main(String[] args) {
        LinkList linkList = new LinkList(new int[]{1});
        System.out.println(removeNthFromEnd(linkList.getHead().next,5));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode q = dummyHead.next;
        while(q != null&& n-- > 0){
            q = q.next;
        }
        while(q != null){
            q = q.next;
            p = p.next;
        }
        ListNode delNode = p.next;
        p.next = delNode.next;
        return dummyHead.next;
    }
}
