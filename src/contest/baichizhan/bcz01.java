package contest.baichizhan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mercop on 2017/9/1.
 */
public class bcz01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();
        int[] nums= new int[m];
        for(int i = 0; i < m;i ++){
            nums[i] = sc.nextInt();
        }
        //getCountOfOptions(new int[]{10,3,5,12},10,2,4);
        System.out.println(getCountOfOptions(nums,n,k,m));
    }
    public static int getCountOfOptions(int[] nums,int n,int k,int m){
        if(n <= 0 || k <= 0 || k > m || m < 0) return 0;
        Arrays.sort(nums);
        getAllCombinations(nums,0,k,n,new ArrayList<>());
        //System.out.println(results);
        return results.size();
    }


    static List<List<Integer>> results = new ArrayList<>();
    public static void getAllCombinations(int[] nums, int index, int k ,int restBudget, List<Integer> res){

        if(k == res.size()){
            if(restBudget >= 0) {
                results.add(res);
            }
            return;
        }
        if(restBudget < 0 || nums.length == index ) return ;

        //剪枝操作，从[index, len)到[index,len - (k - res.size()) + 1)
        //一些分支是无效的，例如最开始index 取最后一个节点，因为我们的总是从index开始选取，则无法在取到第二个节点
        for(int i = index; i < nums.length - (k - res.size()) + 1; i ++){
            if(nums[i] <= restBudget){
                res.add(nums[i]);
                getAllCombinations(nums,i + 1,k ,restBudget - nums[i],new ArrayList<>(res));
                res.remove(res.size() -1);
            }
            //减枝操作，在保证nums为有序数组情况下，如果当前元素大于剩余的预算，则说明后面的都不可能满足条件直接跳出
            else break;
        }
    }

}
