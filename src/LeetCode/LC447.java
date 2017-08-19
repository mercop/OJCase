package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mercop on 2017/8/16.
 * 找到平面三个点的组合个数,使得i,j 的距离与i,k的距离相等
 */

public class LC447 {

    public static void main(String[] args) {
        int[][] points = new int[][]{{0,0},{1,0},{-1,0},{0,1},{0,-1}};
        System.out.println(numberOfBoomerangs(points));
    }

    public static int numberOfBoomerangs(int[][] points) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(1024);
        int len = points.length;
        int[] pointx,pointy;
        Integer count;
        int distance = 0;
        int result = 0;

        for(int i = 0; i < len; i ++){
            pointx = points[i];
            for(int j = 0; j < len; j ++){
                if(i == j) continue;
                pointy = points[j];
                distance = (int)(Math.pow(pointy[1] - pointx[1],2) + Math.pow(pointy[0] - pointx[0],2));

                if((count = map.get(distance)) != null){
                    map.put(distance,count + 1);
                }else
                    map.put(distance,1);
            }
            for(int c : map.values()){
                if(c > 1) result += c * (c -1);//c个数中，选2个的所有排列AC2
            }
            map.clear();
        }
        return result;
    }
}
