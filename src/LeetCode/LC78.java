package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mercop on 2017/8/30.
 * 所有子集
 */
public class LC78 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(subsets(nums));
    }

    static List<List<Integer>> lists = new ArrayList<>();

    static void getAllSubSets(int[] nums, int index, List<Integer> res){
        for(int i = index; i < nums.length; i ++){
            res.add(nums[i]);
            getAllSubSets(nums, i + 1,new ArrayList<>(res));
            res.remove(res.size() - 1);
        }
        lists.add(res);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return lists;
        getAllSubSets(nums,0,new ArrayList<>());
        return lists;
    }

}
