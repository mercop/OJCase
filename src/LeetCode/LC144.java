package LeetCode;

import model.TreeNode;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mercop on 2017/8/23.
 * 二叉树前序遍历
 */
public class LC144 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTree(new int[]{1,-1,2,-1,-1,6,5});
        System.out.println(preorderTraversal(treeNode));
    }
    //递归方式
    static List<Integer> result  = new LinkedList<>();
    public static List<Integer> preorderTraversal(TreeNode root) {

        if(root != null) {
            result.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return result;
    }


    @Test
    public void test(){
        TreeNode treeNode = TreeNode.createTree(new int[]{1,2,3,4,5,6,7,8});
        System.out.println(preorderTraversal2(treeNode));
    }
    //非递归方式
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list  = new LinkedList<>();
        if(root == null) return list;
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode leftEnd;
        TreeNode node = root;
        while(node != null ||!deque.isEmpty()){
            while(node != null){
                list.add(node.val);
                deque.push(node);
                node = node.left;
            }
            leftEnd = deque.pop();
            node = leftEnd.right;
        }
        return list;
    }


    @Test
    public void  test2(){
        TreeNode treeNode = TreeNode.createTree(new int[]{1,2,3,4,5,6,7,8});
        System.out.println(preorderTraversal3(treeNode));
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
    //通用模式 - 设一个访问/遍历 动作控制操作
    //缺点 耗时
    public static List<Integer> preorderTraversal3(TreeNode root) {
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
                //注意这里压栈顺序
                if(node.right != null) deque.push(new Command(node.right,Operation.go));
                if(node.left != null) deque.push(new Command(node.left,Operation.go));
                deque.push(new Command(node,Operation.add));
            }
        }
        return list;
    }
}



