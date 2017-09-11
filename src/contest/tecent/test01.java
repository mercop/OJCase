package contest.tecent;

import model.BST;
import model.BinaryUtils;
import model.CallBack;
import model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mercop on 2017/8/29.
 * 顺序数构成BST,找到三数节点的共同祖先
 */

public class test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int len = (int) Math.pow(2, K) - 1;
        int[] nodes = new int[len];
        for (int i = 0; i < len; i++) {
            nodes[i] = i + 1;
        }
        TreeNode node = BST.sortedArray2BST(nodes);
        List<Integer> list = new ArrayList<>();
        BinaryUtils.traverseOfLevel(node, new CallBack() {
            @Override
            public void handleData(Integer data) {
                list.add(data);
            }
        });
        int[] nums = new int[len];
        for(int i = 0 ; i < list.size(); i++){
            nums[i] = list.get(i);
        }

        System.out.println(Arrays.toString(nums));

        int p = sc.nextInt();
        int q = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(lowestCommonAncestor(nums, 0, p, q, r));
    }

    public static int lowestCommonAncestor(int[] nodes, int index, int p, int q, int r) {
        if (nodes.length <= index) return 0;
        int val = nodes[index];
        if (val < p && val < q && val < r)
            return lowestCommonAncestor(nodes, index * 2 + 2, p, q, r);
        if (val > p && val > q && val > r)
            return lowestCommonAncestor(nodes, index * 2 + 1, p, q, r);
        return nodes[index];
    }

}
