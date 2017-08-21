package LeetCode;

import model.LinkList;
import model.ListNode;

/**
 * Created by mercop on 2017/8/21.
 * 两个有序链表的归并
 */

public class LC21 {

    public static void main(String[] args) {
        LinkList<Integer> l1 = new LinkList(new int[]{});
        LinkList<Integer> l2 = new LinkList(new int[]{2,3,4,9});
        System.out.println(mergeTwoLists(l1.getHead().next,l2.getHead().next));
    }
    public static ListNode mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2) {

        ListNode<Integer> result = new ListNode<>(-1);
        ListNode<Integer>  p = result;
        while(l1 !=null && l2 != null){
            if(l1.val > l2.val){
                p.next = new ListNode(l2.val);
                l2 = l2.next;
            } else{
                p.next = new ListNode<>(l1.val);
                l1 = l1.next;
            }
            p = p.next;
        }
        while(l1 != null){
            p.next = new ListNode(l1.val);
            l1 = l1.next;
            p = p.next;
        }
        while(l2 != null){
            p.next = new ListNode(l2.val);
            l2 = l2.next;
            p = p.next;
        }
        return result.next;
    }

}
