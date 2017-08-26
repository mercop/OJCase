package LeetCode;


import model.TreeNode;

/**
 * Created by mercop on 2017/8/23.
 * 求出二叉树的深度
 */
public class LC104 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTree(new int[]{1,-1,2,-1,-1,3,4});
        System.out.println(maxDepth(treeNode));
    }

    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int maxLeftDepth = maxDepth(root.left);
        int maxRightDepth = maxDepth(root.right);
        return maxLeftDepth>maxRightDepth ? maxLeftDepth+1:maxRightDepth+1;
    }
}
