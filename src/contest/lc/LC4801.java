package contest.lc;


import model.TreeNode;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by mercop on 2017/9/3.
 */
public class LC4801 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new int[]{2,2,5,-1,-1,5,7});
        System.out.println(findSecondMinimumValue(root));
    }

    public static int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        Deque<TreeNode> deque = new LinkedList<>();
        PriorityQueue<TreeNode> priorityQueue = new PriorityQueue<>(new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return o1.val - o2.val;
            }
        });
        deque.offer(root);
        while(!deque.isEmpty()){
            TreeNode node = deque.poll();
            priorityQueue.offer(node);
            if(node.left !=null) deque.offer(node.left);
            if(node.right != null) deque.offer(node.right);
        }
        int before = priorityQueue.poll().val;
        while(!priorityQueue.isEmpty() && priorityQueue.peek().val == before){
            priorityQueue.poll();
        }
        if(priorityQueue.isEmpty()) return -1;
        else return priorityQueue.poll().val;
    }
}
