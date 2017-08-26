package LeetCode;

import model.TreeNode;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mercop on 2017/8/23.
 * 二叉树中序遍历
 */
public class LC94 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTree(new int[]{1,2,3,4,5,6,7,8});
        System.out.println(inorderTraversal(treeNode));
    }

    //递归方式
    static List<Integer> list = new LinkedList<>();
    public static List<Integer> inorderTraversal(TreeNode root) {
        if(root != null){
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }

        return list;
    }

    //非递归方式
    @Test
    public void test(){
        TreeNode treeNode = TreeNode.createTree(new int[]{1,2,3,4,5,6,7,8});
        System.out.println(inorderTraversal2(treeNode));
    }

    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root == null) return result;

        TreeNode leftEnd;
        Deque<TreeNode> deque = new LinkedList<>();

        while(root != null||!deque.isEmpty()){

            while(root != null){
                deque.push(root);
                root = root.left;
            }

            leftEnd = deque.pop();
            //与非递归前序遍历类似
            result.add(leftEnd.val);
            root = leftEnd.right;
        }
        return result;
    }



    //通用模式
    @Test
    public void test2(){
        TreeNode treeNode = TreeNode.createTree(new int[]{1,2,3,4,5,6,7,8});
        System.out.println(inorderTraversal3(treeNode));
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

    public List<Integer> inorderTraversal3(TreeNode root) {
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
                deque.push(new Command(node,Operation.add));
                if(node.left != null) deque.push(new Command(node.left,Operation.go));
            }
        }
        return list;
    }
}
