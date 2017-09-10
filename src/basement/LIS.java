package basement;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mercop on 2017/9/9.
 * 最长上升子序列问题
 */
public class LIS {

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18,19};
        System.out.println(lengthOfLIS(nums));
    }
    //获得其个数
    //动态规划解法 O(n^2)
    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] meno = new int[n];
        int max = 1;
        for(int i =0; i < n; i ++) meno[i] = 1;

        for(int i =1; i < n; i ++){
            for(int j = 0; j < i;j ++){
                if(nums[j] < nums[i]) meno[i] = Integer.max(meno[i], meno[j] + 1);
            }
            if(meno[i] > max) max = meno[i];
        }
        return max;
    }


    @Test
    public void test(){
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(getAllLIS(nums));
    }

    //获得所有的LIS
    public static List<List<Integer>> getAllLIS(int[] nums) {

        if(nums == null || nums.length == 0) return null;
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int[] meno = new int[n];
        int max = 1;
        for(int i =0; i < n; i ++) meno[i] = 1;

        for(int i =1; i < n; i ++){
            for(int j = 0; j < i;j ++){
                if(nums[j] < nums[i]) meno[i] = Integer.max(meno[i], meno[j] + 1);
            }
            if(meno[i] > max) max = meno[i];
        }
        for(int i = n -1; i >= 0; i --){
           if(meno[i] == max){
               Deque<Integer>  deque = new LinkedList<>();
               deque.push(nums[i]);
               int cur = max;
               for(int j = i; cur > 1  && j >=0;j --){
                   if(cur - 1 == meno[j]){
                       deque.push(nums[j]);
                       cur --;
                   }
               }
               List<Integer> list = new ArrayList<>();
               while(!deque.isEmpty()) list.add(deque.pop());


               res.add(list);
           }
        }
        return res;
    }

}
