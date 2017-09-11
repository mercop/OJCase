package contest.LC;

import model.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by mercop on 2017/8/20.
 *
 * 获得节点最大宽度
 * 超时
 */

public class LC4602 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode t = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(6);
        root.left = t;
        root.right = t2;
        t.left = t3;
        t.right = t4;
        t2. right = t5;

        System.out.println(widthOfBinaryTree(root));
    }

    public static int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        if(root == null)
            return 0;
        deque.offer(root);
        int curLevel = 1;
        int maxWidth = -1;
        int startIndex = -1;
        int endIndex = -1;
        while(!deque.isEmpty()){
            int count = (int)Math.pow(2,curLevel - 1);

            for(int i =0 ; i< count; i++){
                TreeNode treeNode = deque.poll();

                if(treeNode == null){
                    deque.offer(null);
                    deque.offer(null);
                }else {
                    deque.offer(treeNode.left);
                    deque.offer(treeNode.right);
                    if(startIndex == -1){
                        startIndex = i;
                        endIndex = i;
                    }else{
                        endIndex = i;
                    }
                }
            }
            if(startIndex == -1)
                break;
            if(maxWidth < endIndex - startIndex + 1){
                maxWidth = endIndex - startIndex + 1;
            }
            startIndex = -1;
            endIndex = -1;
            curLevel ++;
        }
        return maxWidth;
    }
}