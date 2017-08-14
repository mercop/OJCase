package LeetCode;

import org.junit.Test;


/**
 * Created by mercop on 2017/8/14.
 * 题目：给定一个有序数组，和一个整数target，找到两个元素，使其等于target，返回索引(索引从1开始)
 */

public class LC167 {

    //基本方法，双重循环 求解// O(N^2)
    @Test
    public void test(){
        int[] arr = new int[]{2,5,11,15,18,24};
        int target = 29;
        for(int i = 0; i < arr.length;i++)
            for(int j = i;j < arr.length;j++)
                if(arr[i] + arr[j] == target)
                    System.out.println((i+1) + " " + (j+1));
    }

    //剩余数组二分查找法 O(NlogN)
    @Test
    public void test2(){

        int[] arr = new int[]{2,5,11,15,18,24};
        int target = 29;
        for(int i = 0; i < arr.length;i++){
            int needed = target - arr[i];
            int founded = binarySearch(arr,i+1,arr.length,needed);
            if(founded!=-1)
                System.out.println((i+1) + " " + (founded+1));
        }
    }

    public static int binarySearch(int arr[], int l,int n, int target){
        int r = n-1;
        while( l <= r ){

            int mid = l + (r-l)/2;
            if( arr[mid] == target ) return mid;
            if( arr[mid] > target ) r = mid - 1;
            else l = mid + 1;
        }

        return -1;
    }


    //O(N)
    @Test
    public void test3(){
        int[] arr = new int[]{2,5,11,15,18,24};
        int target = 29;
        int p = 0;
        int q = arr.length -1;
        int total;
        while(p < q){
            total = arr[p] + arr[q];
            if(target == total)
                System.out.println((p + 1) + " " +(q + 1));
            if(total > target)
                q--;
            else
                p++;
        }
    }
}
