package LeetCode;

import model.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by mercop on 2017/8/23.
 * 求二叉树的最低深度，从根节点到叶子的最短路径
 */
public class LC111 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTree(new int[]{1,-1,2,-1,-1,3,4,-1,-1,-1,-1,5});
        System.out.println(minDepth(treeNode));
    }
    public static int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        Deque<Pair<TreeNode,Integer>> deque = new LinkedList<>();
        deque.offer(new Pair<>(root,1));
        while(!deque.isEmpty()){
            Pair<TreeNode,Integer> pair = deque.poll();
            TreeNode node = pair.getKey();
            int level = pair.getValue();
            //叶子结点判断
            if(node.left == null && node.right == null)
                return level;
            else {
                if (node.left != null) deque.offer(new Pair<>(node.left, level + 1));
                if (node.right != null) deque.offer(new Pair<>(node.right, level + 1));
            }
        }
        return -1;
    }

    static class Pair<K,V> {
        private K key;
        public K getKey() {
            return key;
        }
        private V value;
        public V getValue() {
            return value;
        }
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
