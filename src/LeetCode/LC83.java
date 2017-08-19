package LeetCode;

import model.LinkList;
import model.ListNode;

/**
 * Created by mercop on 2017/8/18.
 * 链表去重
 */

public class LC83 {
    public static void main(String[] args) {
        int nums[] = new int[]{1,1};
        LinkList linkList = new LinkList(nums);
        ListNode listNode = linkList.getHead().next;
        System.out.println(deleteDuplicates(listNode));
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null ) return head;
        ListNode cur = head;
        ListNode next = head.next;
        while(next != null){
            if (cur.val == next.val){
                cur.next= next.next;
            } else cur = next;
            next = next.next;
        }
        return head;
    }

}
