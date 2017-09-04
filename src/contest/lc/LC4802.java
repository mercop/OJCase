package contest.lc;

import model.BinaryUtils;
import model.TreeNode;

/**
 * Created by mercop on 2017/9/3.
 * Input:
     1
     / \
     0   2

     L = 1
     R = 2

     Output:
     1
     \
     2
 *
 */
public class LC4802 {

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new int[]{3,0,4,-1,2,-1,-1,-1,-1,1});
        TreeNode node = trimBST(root,1,3);
        BinaryUtils.traverseOfPre(node);
        BinaryUtils.traverseOfIn(node);
    }

    public static TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;

        if (root.val >= L && root.val <= R) {
            TreeNode node = new TreeNode(root.val);
            node.left = trimBST(root.left, L, R);
            node.right = trimBST(root.right, L, R);
            return node;
        } else if (root.val < L) return trimBST(root.right, L, R);
        else return trimBST(root.left, L, R);
    }

}
