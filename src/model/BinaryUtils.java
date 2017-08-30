package model;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * @title: 二叉树静态方法工具类
 * @author: Marvin Guo
 * @create time: 2017年1月3日
 */
public class BinaryUtils {
	/**
	 * 获取树节点数目
	 * 
	 * @param root
	 */
	public static int getSize(TreeNode root) {
		if (root == null)
			return 0;
		else
			return 1 + getSize(root.left) + getSize(root.right);
	}

	/**
	 * 获取树节点层数
	 * 
	 * @param root
	 * @return
	 */
	public static  int getLevel(TreeNode root) {
		if (root == null)
			return 0;
		int left = getLevel(root.left);
		int right = getLevel(root.right);
		return left > right ? left + 1 : right + 1;
	}

	/**
	 * 先序遍历
	 * 
	 * @param root
	 */
	public static void traverseOfPre(TreeNode root) {
		if (root == null )
			return;
		System.out.print(root.val + " ");
		if (root.left != null)
			traverseOfPre(root.left);
		if (root.right != null)
			traverseOfPre(root.right);
	}

	/**
	 * 中序遍历
	 * 
	 * @param root
	 */
	public static void traverseOfIn(TreeNode root) {
		if (root == null)
			return;
		if (root.left != null)
			traverseOfIn(root.left);
		System.out.print(root.val + " ");
		if (root.right != null)
			traverseOfIn(root.right);
	}

	/**
	 * 后序遍历
	 * 
	 * @param root
	 */
	public static  void traverseOfPost(TreeNode root) {
		if (root == null)
			return;
		if (root.left != null)
			traverseOfPost(root.left);
		if (root.right != null)
			traverseOfPost(root.right);
		System.out.print(root.val + " ");
	}

	/**
	 * 先序遍历CallBack
	 * 
	 * @param root
	 */
	public static void traverseOfPre(TreeNode root, CallBack callback) {
		if (root == null )
			return;
		callback.handleData(root.val);
		if (root.left != null)
			traverseOfPre(root.left, callback);
		if (root.right != null)
			traverseOfPre(root.right, callback);
	}

	/**
	 * 中序遍历CallBack
	 * 
	 * @param root
	 */
	public static void traverseOfIn(TreeNode root, CallBack callback) {
		if (root == null )
			return;
		if (root.left != null)
			traverseOfIn(root.left, callback);
		callback.handleData(root.val);
		if (root.right != null)
			traverseOfIn(root.right, callback);
	}

	/**
	 * 后序遍历CallBack
	 * 
	 * @param root
	 */
	public static void traverseOfPost(TreeNode root, CallBack callback) {
		if (root == null)
			return;
		if (root.left != null)
			traverseOfPost(root.left, callback);
		if (root.right != null)
			traverseOfPost(root.right, callback);
		callback.handleData(root.val);
	}

    /**
     * 层次遍历CallBack
     *
     * @param root
     */
    public static void traverseOfLevel(TreeNode root, CallBack callback) {

        if (root == null)
            return;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            TreeNode node = deque.pop();
            callback.handleData(node.val);
            if(node.left != null) deque.offer(node.left);
            if(node.right != null) deque.offer(node.right);
        }
    }

	/**
	 * 深度优先搜索
	 * 
	 * @param root
	 * @param k
	 * @return
	 */
	public static TreeNode deepFirstSearch(TreeNode root, Integer k) {

		if (k == null | root == null)
			return null;
		if (root.val == k)
			return root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node;
		stack.push(root);
		while (!stack.isEmpty()) {
			node = stack.pop();
			if (node.val == k)
				return node;
			if (node.left != null) {
				stack.push(node.right);
			}
			if (node.right != null)
				stack.push(node.left);
		}
		return null;
	}

	/**
	 * 广度优先搜索
	 * 
	 * @param root
	 * @param k
	 * @return
	 */
	public static TreeNode broadFirstSearch(TreeNode root, Integer k) {

		if (k == null || root == null)
			return null;
		if (root.val == k)
			return root;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode node;
		queue.offer(root);
		while (queue.peek() != null) {
			// 节点出队
			node = queue.poll();
			if (node.val == k)
				return node;
			// 左孩子入队
			if (node.left != null) {
				queue.offer(node.left);
			}
			// 右孩子入队
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
		return null;
	}

	public static TreeNode createTreeByPreAndIn(int[] pre, int[] in) {
		return createTreeByPreAndInRe(pre, in, 0, pre.length - 1, 0, in.length - 1);
	}

	public static TreeNode createTreeByPreAndInRe(int[] pre, int[] in, int pi, int pj, int ii, int ij) {
		if (pi > pj || ii > ij)
			return null;
		int rootNum = pre[pi];
		TreeNode node = new TreeNode(rootNum);
		int mid = findNodeFromMid(in, rootNum, ii, ij);

		int leftLen = mid - ii;
		//int rightLen = ij - mid;
		node.left = createTreeByPreAndInRe(pre, in, pi + 1, pi + leftLen, ii, mid - 1);
		node.right = createTreeByPreAndInRe(pre, in, pi + leftLen + 1, pj, mid + 1, ij);

		return node;
	}

	private static int findNodeFromMid(int[] in, int value, int ii, int ij) {
		for (int i = ii; i <= ij; i++) {
			if (in[i] == value)
				return i;
		}
		return -1;

	}

	public static void main(String[] args) {
		Integer[] a = { 1, 2, null, 3, 4 };
		
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
/*		BinaryTree<Integer> btree = TreeFactory.generateTree(a);
		BinaryUtils.traverseOfIn(btree.root);
		BinaryUtils.traverseOfPre(btree.root);
		System.out.println();
		System.out.println(BinaryUtils.getLevel(btree.root));
		System.out.println(BinaryUtils.getSize(btree.root));

		System.out.println(BinaryUtils.broadFirstSearch(btree.root, 2));
		System.out.println(BinaryUtils.deepFirstSearch(btree.root, 5));*/


        TreeNode node = createTreeByPreAndIn(pre, in);
		traverseOfPre(node);
		System.out.println();
		traverseOfPost(node);
		System.out.println();
		traverseOfIn(node);
		
		
	}
}
