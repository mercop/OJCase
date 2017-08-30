package LeetCode;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mercop on 2017/8/28.
 * 获得二叉树所有路径
 */
public class LC257 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTree(new int[]{1,-1,2,-1,-1,3,4,-1,-1,-1,-1,5});
        System.out.println(binaryTreePaths(treeNode));
    }
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null) return result;
        if(root.left == null && root.right ==null){
            result.add(String.valueOf(root.val));
        }

        List<String> leftList = binaryTreePaths(root.left);
        for(int i = 0; i < leftList.size();i++){
            String str = leftList.get(i);
            result.add(root.val +"->" + str);
        }
        List<String> rightList = binaryTreePaths(root.right);
        for(int i = 0; i < rightList.size();i++){
            String str = rightList.get(i);
            result.add(root.val +"->" + str);
        }
        return result;
    }
}
