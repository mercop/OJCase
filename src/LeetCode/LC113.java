package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mercop on 2017/8/28.

 */
public class LC113 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        System.out.println(pathSum(node));
    }

    public static int pathSum(TreeNode root) {
        List<Integer> temp = new ArrayList<Integer>();

        if (root == null) return result;
        DFS(temp, root, 0);
        return result;
    }
    static int result;
    static void DFS(List<Integer> temp, TreeNode root, int sum) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            result += sum + root.val;
            return;
        } else {
            temp.add(root.val);
            DFS(temp, root.left, sum + root.val);
            DFS(temp, root.right, sum + root.val);
            temp.remove(temp.size() - 1);
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
