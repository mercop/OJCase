package LeetCode;


import model.TreeNode;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mercop on 2017/8/23.
 * 二叉树后序遍历
 */
public class LC145 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTree(new int[]{1,-1,2,-1,-1,6,5});
        System.out.println(postorderTraversal(treeNode));
    }
    //递归方式
    static List<Integer> result  = new LinkedList<>();
    public static List<Integer> postorderTraversal(TreeNode root) {

        if(root != null) {

            postorderTraversal(root.left);
            postorderTraversal(root.right);
            result.add(root.val);
        }
        return result;
    }

    //非递归方式 --  未实现
    @Test
    public void test(){
        TreeNode treeNode = TreeNode.createTree(new int[]{1,2,3,4,5,6,7,8});
        System.out.println(postorderTraversal2(treeNode));
    }
    public List<Integer> postorderTraversal2(TreeNode root) {
       return null;
    }


    //通用方式
    @Test
    public void test2(){
        TreeNode treeNode = TreeNode.createTree(new int[]{1,2,3,4,5,6,7,8});
        System.out.println(postorderTraversal3(treeNode));
    }


    enum Operation{go,add}
    static class Command{
        TreeNode treeNode;
        Operation oper;
        public Command(TreeNode treeNode,Operation oper){
            this.treeNode = treeNode;
            this.oper = oper;
        }
    }

    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> list  = new LinkedList<>();
        if(root == null) return list;
        Deque<Command> deque = new LinkedList<>();
        deque.push(new Command(root,Operation.go));
        while(!deque.isEmpty()){
            Command command = deque.pop();
            TreeNode node = command.treeNode;
            if(command.oper == Operation.add){
                list.add(node.val);
            } else{
                deque.push(new Command(node,Operation.add));
                //注意这里压栈顺序
                if(node.right != null) deque.push(new Command(node.right,Operation.go));
                if(node.left != null) deque.push(new Command(node.left,Operation.go));
            }
        }
        return list;
    }

}
