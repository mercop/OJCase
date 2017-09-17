package contest.stkj;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by mercop on 2017/9/17.
 */
public class stkj01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[][] nums = new int[k][n];
        HashSet<Integer>[] memo = new HashSet[k];
        for(int i = 0; i < k;i ++){
            HashSet hi = new HashSet();
            for(int j = 0; j < n; j++){
                nums[i][j] = sc.nextInt();
                hi.add(nums[i][j]);
            }
            memo[i] = hi;
        }
        int min = Integer.MAX_VALUE;
        int max = -1;
        for(int i = 0; i < k ; i++){
            if(nums[i][0] > max) max = nums[i][0];
            if(nums[i][0] < min) min = nums[i][0];
        }
        int diff = max - min;

        for(int j = 0; j < n;j ++){
            int x = nums[0][j];
            int minVal = Integer.MAX_VALUE;
            int maxVal = -1;
            for(int i = 0; i < k ; i++){
                boolean found = false;

                for(int z = x - diff > 0 ? x-diff : 0; z <= x + diff; z ++){
                    HashSet<Integer> set = memo[j];
                    if(set.contains(z)) {
                        if(z > maxVal) maxVal = z;
                        if(z < minVal) minVal = z;
                        found = true;
                    }
                }
                if(!found) break;
                if(diff > maxVal - minVal) {
                    diff = maxVal - minVal;
                    min = minVal;
                    max = maxVal;
                }
            }
        }
        System.out.println(min + " " + max);

    }
}
