package LeetCode;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mercop on 2017/8/28.
 * 从根节点到叶子结点所有路径组成的数的和
 */
public class LC129 {

    public static void main(String[] args) {

        TreeNode root = TreeNode.createTree(new int[]{5,3,2,7,0,6,-1,-1,-1,0});
        System.out.println(sumNumbers(root));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null) return result;
        if(root.left == null && root.right ==null){
            result.add(String.valueOf(root.val));
            return result;
        }

        List<String > leftList = binaryTreePaths(root.left);
        for(int i = 0; i < leftList.size();i++){
            String val = leftList.get(i);
            result.add(root.val + val);
        }
        List<String> rightList = binaryTreePaths(root.right);
        for(int i = 0; i < rightList.size();i++){
            String val= rightList.get(i);
            result.add(root.val + val);
        }
        return result;
    }
    public static int sumNumbers(TreeNode root) {
        List<String> list = binaryTreePaths(root);
        int sum = 0;
        for(String stri : list){
            sum += Integer.parseInt(stri);
        }
        return sum;
    }
}
