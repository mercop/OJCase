package LeetCode;

import model.TreeNode;

/**
 * Created by mercop on 2017/8/28.
 * 求所有左叶子之和
 */
public class LC404 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTree(new int[]{1,-1,2,-1,-1,3,4,-1,-1,-1,-1,5});
        System.out.println(sumOfLeftLeaves(treeNode));
    }
    public static int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;

        if(root.left != null){
            TreeNode treeNode = root.left;
            if(treeNode.left == null && treeNode.right == null)
                return treeNode.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
