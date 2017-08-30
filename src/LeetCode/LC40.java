package LeetCode;

import java.util.*;

/**
 * Created by mercop on 2017/8/30.
 * 元素(可以相同)组合，每个数只能取一次其和为T
 */
public class LC40 {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(nums,8));
    }

    static List<List<Integer>> lists = new ArrayList<>();

    public static void getNumsCombinations(int[] nums,int index, int target, List<Integer> res){
        if(target == 0){
            lists.add(res);

            return;
        }
        if(target < 0 || index == nums.length) return;

        for(int i = index ; i < nums.length; i++){
            //每次只取相同元素的第一个进行循环
            if( i != index && nums[i] == nums[i - 1]) continue;
            int num = nums[i];
            if (target >= num) {
                res.add(num);
                //递归时候，相同的元素又成为可行解
                getNumsCombinations(nums, i + 1, target - num, new ArrayList<>(res));
                res.remove(res.size() - 1);
            }
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        getNumsCombinations(candidates,0,target, new ArrayList<>());
        return lists;
    }
}
