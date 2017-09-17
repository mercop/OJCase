package contest.haoweilai;

/**
 * Created by mercop on 2017/9/15.
 */
public class hwl04 {

    public static void main(String[] args) {

    }
    public static Node merge_links(Node[] nodes ,int n){
        if(nodes == null || nodes.length == 0) return null;
        Node head  = new Node(-1);
        Node p = head;
        int countOfNode = nodes.length;
        Node[] curNodes = new Node[countOfNode];
        for(int j  = 0; j < countOfNode; j ++){
            curNodes[j] = nodes[j];
        }
        for(int i = 0; i < n; i ++){
            int minIndex = 0;
            int minVal = Integer.MAX_VALUE;
            for(int j  = 0; j < countOfNode; j ++){
                if(curNodes[j] !=null &&curNodes[j].value < minVal){
                    minIndex = j;
                    minVal = curNodes[j].value;
                }

            }
            p.next = nodes[minIndex];
            nodes[minIndex].pre = p;
            p = p.next;
            curNodes[minIndex] = curNodes[minIndex].next;

        }
        return head.next;
    }
    static class Node{
        int value;
        Node pre;
        Node next;
        public Node(int val){
            this.value = val;
        }
    }

}
