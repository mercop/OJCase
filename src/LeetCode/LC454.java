package LeetCode;

import java.util.HashMap;

/**
 * Created by mercop on 2017/8/16.
 * 四元组相加，四个整形数组，求A[i] +B[j] + C[k] + D[L] = 0;
 */

public class LC454 {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4};
        int[] b = new int[]{-1,2,3,4};
        int[] c = new int[]{-1,-2,3,4};
        int[] d = new int[]{1,-2,3,4};
        System.out.println(fourSumCount(a,b,c,d));
    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(4096);
        int len1 = A.length;
        int len2 = B.length;
        int len3 = C.length;
        int len4 = D.length;
        Integer foundCount;
        int result = 0;
        int totalAB;
        for(int i = 0; i < len1 ; i ++)
            for(int j = 0;j < len2; j ++){
                totalAB = A[i] + B[j];
                if((foundCount = map.get(totalAB)) != null)
                    map.put(totalAB,foundCount + 1);
                else
                    map.put(totalAB,1);
            }


        for(int i = 0; i < len3; i++)
            for(int j = 0; j < len4; j ++){
                if((foundCount = map.get(- C[i] - D[j])) != null)
                    result += foundCount;
            }

        return result;
    }
}
