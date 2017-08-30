package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mercop on 2017/8/30.
 * 集合子集 元素可能重复
 */
public class LC90 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,4,4,1,4};
        System.out.println(subsetsWithDup(nums));
    }

    static List<List<Integer>> lists = new ArrayList<>();

    static void getAllSubSets(int[] nums, int index, List<Integer> res){
        for(int i = index; i < nums.length; i ++){
            if(i != index && nums[i] == nums[i - 1]) continue;
            res.add(nums[i]);
            getAllSubSets(nums, i + 1,new ArrayList<>(res));
            res.remove(res.size() - 1);
        }
        lists.add(res);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null || nums.length == 0) return lists;
        //注意需要排序
        Arrays.sort(nums);
        getAllSubSets(nums,0,new ArrayList<>());
        return lists;
    }
}
