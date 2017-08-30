package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mercop on 2017/8/30.
 * 元素组合，其和为T
 */
public class LC39 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 6, 7};
        System.out.println(combinationSum(nums, 7));
    }

    static List<List<Integer>> lists = new ArrayList<>();

    public static void getNumsCombinations(int[] candidates, int index, List<Integer> res, int target) {
        if (target == 0) {
            lists.add(res);
            return;
        }
        if (target < 0 || index == candidates.length) return;

        for (int i = index; i < candidates.length; i++) {
            int num = candidates[i];
            if (target >= num) {
                res.add(num);
                getNumsCombinations(candidates, i, new ArrayList<>(res), target - num);
                res.remove(res.size() - 1);
            }
        }

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        getNumsCombinations(candidates, 0, new ArrayList<>(), target);
        return lists;
    }

}
