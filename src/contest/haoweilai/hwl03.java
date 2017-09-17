package contest.haoweilai;

public class hwl03 {

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);//头结点
        ListNode p = head;
        p.next = new ListNode(1);
        p = p.next;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);

        ListNode res = reverseFirstAndEnd(head);
        while(res!= null){
            System.out.println(res.val + " ");
            res = res.next;
        }

    }
    public static ListNode reverseFirstAndEnd(ListNode head){
        ListNode firstNode =head.next;
        ListNode q = head;
        ListNode p = firstNode;
        while(p.next!=null){
            p=p.next;
            q = q.next;
        }

        head.next = p;
        p.next = firstNode.next;
        firstNode.next = null;
        q.next = firstNode;

        return p;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}