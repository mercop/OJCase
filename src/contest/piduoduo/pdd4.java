package contest.piduoduo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mercop on 2017/9/2.
 */
public class pdd4 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        int m = 3;
        int k = 2;
        int n = 2;
        int l = 1; int r = 2;
        values = new int[r - l + 1];
        for(int i = l, j = 0; i <= r; i ++,j ++)
            values[j] = i;


//        int[] negitive = new int[100];
//        int zero = 0;

        for(int i =0; i < n; i++){
            positive[nums[i]]++;
        }


        process(nums,0,new ArrayList<>(),k,m);
        System.out.println(result);
    }
    static int[] values;
    static int[] positive = new int[100];
    static List<List<Integer>> result = new ArrayList<>();
    public static void process(int[] nums, int index, List<Integer> res,int k, int m){
        if(k == 0 && m == 0){
            result.add(res);
            return;
        }
        if(index == nums.length || m < 0 || k < 0) return;
        for(int i = 0; i < values.length; i++) {
            res.add(values[i]);
            if(--positive[i] == 0){
                process(nums,index + 1,new ArrayList<>(res),k-1,m -1);
            } else process(nums, index + 1,new ArrayList<>(res),k -1,m -1);
            res.remove(res.size() -1);
        }

    }
}
