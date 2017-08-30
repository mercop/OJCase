package basement;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mercop on 2017/8/28.
 * 从根节点到叶子结点所有路径组成的数的和
 */
public class PathSum {

    public static void main(String[] args) {

        TreeNode root = TreeNode.createTree(new int[]{1,2,3,4,-1,5,6});
        System.out.println(sumNumbers(root));
    }
    public static List<Integer> binaryTreePaths(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        if(root.left == null && root.right ==null){
            result.add(root.val);
            return result;
        }

        List<Integer> leftList = binaryTreePaths(root.left);
        for(int i = 0; i < leftList.size();i++){
            int val = leftList.get(i);
            result.add(val + root.val);
        }
        List<Integer> rightList = binaryTreePaths(root.right);
        for(int i = 0; i < rightList.size();i++){
            int val= rightList.get(i);
            result.add(val + root.val);
        }
        return result;
    }
    public static int sumNumbers(TreeNode root) {
        List<Integer> list = binaryTreePaths(root);
        int sum = 0;
        for(int i : list){
            sum += i;
        }
        return sum;
    }
}
