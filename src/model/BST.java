package model;

/**
 * Created by mercop on 2017/8/30.
 * 有序数组->BST
 */
public class BST {

    public static TreeNode sortedArray2BST(int[] nums){
        return createTreeNode(nums,0,nums.length - 1);
    }
    public static TreeNode createTreeNode(int[] nums, int i, int j){
        if(i > j) return null;
        else if( i == j) return new TreeNode(nums[i]);
        else{
            int mid = (j + i + 1) /2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = createTreeNode(nums,i,mid - 1);
            node.right = createTreeNode(nums,mid + 1, j);
            return node;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        TreeNode root = sortedArray2BST(nums);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }
}
