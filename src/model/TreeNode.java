package model;

/**
 * Created by mercop on 2017/8/23.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    //递归创建二叉树
    public static TreeNode createTree(int[] nums){
        TreeNode root = new TreeNode(nums[0]);
        createNode(nums,0,root);
        return root;
    }

    private static TreeNode createNode(int[] nums,int current,TreeNode root){
        if(current >= nums.length)
            return root;
        int lIndex = current *2 + 1;
        int rIndex = lIndex + 1;;
        if(lIndex< nums.length && nums[lIndex ] != -1){
            TreeNode treeNode = new TreeNode(nums[lIndex]);
            root.left = createNode(nums,lIndex,treeNode);
        }
        if(rIndex < nums.length && nums[rIndex ] != -1){
            TreeNode treeNode = new TreeNode(nums[rIndex]);
            root.right = createNode(nums,rIndex,treeNode);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = createTree(new int[]{1,-1,2,-1,-1,3,4});
        System.out.println(treeNode.val);
        System.out.println(treeNode.left);
        System.out.println(treeNode.right.val);
        System.out.println(treeNode.right.left.val);
        System.out.println(treeNode.right.right.val);
    }
}
