package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mercop on 2017/8/30.
 * 1-9 数字，选出K个，每个数字只能使用一次，使其和为n
 */
public class LC216 {
    public static void main(String[] args) {
        int k = 2;
        int n = 9;
        System.out.println(combinationSum3(k,n));
    }

    static List<List<Integer>> lists = new ArrayList<>();

    public static void getNumsCombinations(int num,int target,int k, List<Integer> res){
        if(target == 0){
            if(k == res.size()) lists.add(res);
            return;
        }
        if(target < 0 || k == res.size()) return;

        //剪枝 n -> target
        for(int i = num; i <= Integer.min(target,9); i ++){
            if(target  >= num ){
                res.add(i);
                getNumsCombinations(i + 1, target - i, k,new ArrayList<>(res));
                res.remove(res.size() - 1);
            }
        }
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        getNumsCombinations(1,n,k,new ArrayList<>());
        return lists;
    }
}
