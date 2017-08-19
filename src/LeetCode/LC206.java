package LeetCode;

import model.LinkList;
import model.ListNode;
import org.junit.Test;

/**
 * Created by mercop on 2017/8/18.
 * 反转链表
 */

public class LC206 {
    public static void main(String[] args) {
        LinkList list = new LinkList(new int[]{1,2});
        ListNode node = list.getHead().next;
        //System.out.println(node);
        System.out.println(reverseList(node));
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next ==null)
            return head;
        ListNode p = head;
        ListNode newHead = head;
        ListNode q;
        ListNode k = p.next;
        p.next = null;
        p = k;
        while(p!= null){
            k = p.next;
            q = newHead;
            newHead = p;
            p.next = q;
            p = k;
        }
        return newHead;
    }

    //更清晰的算法
    @Test
    public void test(){
        LinkList list = new LinkList(new int[]{1,2,3});
        ListNode node = list.getHead().next;
        System.out.println(reverseList2(node));
    }
    public static ListNode reverseList2(ListNode head) {
        if(head == null || head.next ==null)
            return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while(cur!= null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
