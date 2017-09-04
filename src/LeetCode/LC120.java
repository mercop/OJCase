package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mercop on 2017/9/4.
 *
 [
     [2],
     [3,4],
     [6,5,7],
     [4,1,8,3]
 ]
 找到自上向下的最短路径
 */
public class LC120 {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();

        int[][] nums = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};

        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int j = 0; j < nums[i].length; j++) {
                arrayList.add(nums[i][j]);
            }
            triangle.add(arrayList);
        }
        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        return selectNums(triangle, 0, 0);
    }

    public static int selectNums(List<List<Integer>> triangle, int index, int cur) {
        if (index == triangle.size()) {
            return 0;
        }
        List<Integer> lines = triangle.get(index);
        int maxValue = lines.get(cur) +
                Integer.min(selectNums(triangle, index + 1, cur),
                        selectNums(triangle, index + 1, cur + 1));

        return maxValue;
    }

    //动态规划方法
    @Test
    public void test(){
        List<List<Integer>> triangle = new ArrayList<>();

        int[][] nums = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};

        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int j = 0; j < nums[i].length; j++) {
                arrayList.add(nums[i][j]);
            }
            triangle.add(arrayList);
        }
        System.out.println(minimumTotal2(triangle));
    }

    public static int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] pathLen = new int[n][n];
        List<Integer> lastLine = triangle.get(n -1);
        for(int i =0; i < n; i++){
            pathLen[n-1][i] = lastLine.get(i);
        }
        for(int i = n -2; i >= 0; i--){
            List<Integer> line = triangle.get(i);
            for(int j = 0; j < line.size();j ++){
                pathLen[i][j] = Integer.min(pathLen[i + 1][j],pathLen[i + 1][j + 1]) + line.get(j);
            }
        }


        return pathLen[0][0];
    }
}
