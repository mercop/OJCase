package LeetCode;

import model.TreeNode;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by mercop on 2017/9/6.
 * 动态规划-偷取最大值，保证不相邻 街区结构为二叉树
 */
public class LC337 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTree(new int[]{3,2,3,-1,3,-1,1});
        System.out.println(rob(treeNode));
    }
    //暴力递归
    public static int rob(TreeNode root) {
        if(root == null) return 0;
        return tryRob(root);
    }

    public static int tryRob(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;

        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        int res = Integer.max(tryRob(leftNode) + tryRob(rightNode),
                (leftNode == null ? 0 :tryRob(leftNode.left) + tryRob(leftNode.right))
                +( rightNode == null ? 0 :tryRob(rightNode.left) + tryRob(rightNode.right))
                + root.val
        );
        return res;
    }

    static class MemoTreeNode{
        public int val;
        public int memo;
        public MemoTreeNode left;
        public MemoTreeNode right;
        MemoTreeNode(int val,int memo){
            this.val = val;
            this.memo = memo;
        }
    }

    //记忆搜索
    public static int rob2(TreeNode root) {

        if(root == null) return 0;
        Deque<TreeNode> deque = new LinkedList<>();
        Deque<MemoTreeNode> memoTreeNodeDeque = new LinkedList<>();
        MemoTreeNode memoTreeNode = new MemoTreeNode(root.val,-1);
        deque.offer(root);
        memoTreeNodeDeque.offer(memoTreeNode);
        while(!deque.isEmpty()){
            TreeNode node = deque.poll();
            MemoTreeNode memoNode = memoTreeNodeDeque.poll();
            if(node.left != null) {
                deque.offer(node.left);
                MemoTreeNode leftNode = new MemoTreeNode(node.left.val, -1);
                memoNode.left = leftNode;
                memoTreeNodeDeque.offer(leftNode);
            }
            if(node.right != null) {
                deque.offer(node.right);
                MemoTreeNode rightNode = new MemoTreeNode(node.right.val, -1);
                memoNode.right = rightNode;
                memoTreeNodeDeque.offer(rightNode);
            }
        }
        return tryRob(memoTreeNode);
    }

    public static int tryRob(MemoTreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;

        if(root.memo != -1) return root.memo;
        MemoTreeNode leftNode = root.left;
        MemoTreeNode rightNode = root.right;
        int res = Integer.max(tryRob(leftNode) + tryRob(rightNode),
                (leftNode == null ? 0 :tryRob(leftNode.left) + tryRob(leftNode.right))
                        +( rightNode == null ? 0 :tryRob(rightNode.left) + tryRob(rightNode.right))
                        + root.val
        );
        root.memo = res;
        return res;
    }

    @Test
    public void test(){
        TreeNode treeNode = TreeNode.createTree(new int[]{3,4,5,1,3,-1,1});
        System.out.println(rob2(treeNode));
    }
}
