package LeetCode;

import model.LinkList;
import model.ListNode;

/**
 * Created by mercop on 2017/8/21.
 * 链表向右旋转K位
 */

public class LC61 {

    public static void main(String[] args) {
        LinkList linkList = new LinkList(new int[]{1,2,3});
        System.out.println(rotateRight(linkList.getHead().next,6));
    }

    //Time Limit Exceeded
    public static ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null || k <= 0)
            return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode q = dummyHead;
        int len = 0;
        while(p.next!=null){
            p = p.next;
            len ++;
        }
        p = dummyHead;
        if(len < k) k %= len;

        for(int i = 0 ; i < k + 1; i ++){
            if(q.next ==null) q = dummyHead.next;
            else q = q.next;
        }

        while(q != null){
            if(p.next == null) p = dummyHead.next;
            else p = p.next;
            q = q.next;
        }
        dummyHead.next = p.next;
        p.next = null;
        p = dummyHead;
        while(p.next != null){
            p = p.next;
        }
        p.next = head;
        return dummyHead.next;
    }
}
