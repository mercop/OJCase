package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mercop on 2017/8/29.
 * n-k 组合问题
 */
public class LC77 {

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    static List<List<Integer>> lists = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        if(n <= 0 || k <=0 || k > n) return lists;
        getCombinations(n, k, 1, new ArrayList<>());
        return lists;
    }

    public static void getCombinations(int n, int k, int index, List<Integer> res) {
        if(res.size() == k){
            lists.add(res);
            return;
        }
        //减枝优化
        // n- (k - res.size()) + 1
        for (int i = index; i <= n; i++) {
            res.add(i);
            getCombinations(n, k, i + 1, new ArrayList<>(res));
            res.remove(res.size() - 1 );
        }
    }


}
