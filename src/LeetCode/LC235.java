package LeetCode;

import model.TreeNode;

/**
 * Created by mercop on 2017/8/29.
 * 二分搜索树 给定一节点，求其最近公共祖先
 */
public class LC235 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTree(new int[]{5, 2, 9, 1, 3, 7, 10});
        System.out.println(lowestCommonAncestor(treeNode,treeNode.left.right,treeNode.right.left).val);

    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root  == null) return null;

        if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right,p,q);
        if(root.val > p.val & root.val > q.val)
            return lowestCommonAncestor(root.left,p,q);
        return root;
    }
}
