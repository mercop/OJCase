package LeetCode;

import model.TreeNode;

/**
 * Created by mercop on 2017/8/29.
 * 二分搜索树中找到第K小的节点
 */
public class LC230 {

    public static void main(String[] args) {
        TreeNode treeNode =TreeNode.createTree(new int[]{5, 2, 9, 1, 3, 7, 10});
        System.out.println(kthSmallest(treeNode,7));
    }

    public static int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        int count = getCount(root.left);
        if(count == k -1) return root.val;
        else if (count > k -1 ) return kthSmallest(root.left,k);
        else return kthSmallest(root.right,k - count - 1);
    }
    public static int getCount(TreeNode node){
        if(node == null) return 0;
        return 1 + getCount(node.left) + getCount(node.right);
    }
}
