package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mercop on 2017/8/29.
 * 给定一个数组(数组元素不同)，求所有排列
 */
public class LC46 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(permute(nums));
    }
    static boolean[] used;
    static void generatePermutation(int[] nums , int index, List<Integer>  res){
        if(nums.length == index) {
            lists.add(res);
            return;
        }

        for(int i = 0; i < nums.length;i++){
            if(!used[i]){
                res.add(nums[i]);
                used[i] = true;

                generatePermutation(nums,index + 1, new ArrayList<>(res));

                res.remove(res.size() -1 );
                used[i] = false;
            }
        }

    }
    static List<List<Integer>> lists = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {

        if(nums == null || nums.length == 0) return lists;

        used = new boolean[nums.length];
        generatePermutation(nums,0,new ArrayList<>());
        return lists;
    }
}
