package LeetCode;

/**
 * Created by mercop on 2017/8/14.
 * 找到一组数a1,a2,a3,a4,a5的两个数，数字的值为墙的高度，使得与x轴构成的容器，盛水最多
 * 对撞指针思路
 */

public class LC11 {

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,6,9,1,4};
        System.out.println(maxArea(arr));
    }

    public static int maxArea(int[] height) {
        int p = 0;
        int q = height.length -1;
        int max = -1;
        int area = 0;
        while(p < q){
            area = Integer.min(height[p],height[q]) * (q - p);
            if(area > max)
                max = area;
            else if(height[p] > height[q])
                q--;
            else
                p++;
        }
        return max;
    }
}
