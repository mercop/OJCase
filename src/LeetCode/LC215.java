package LeetCode;


/**
 * Created by mercop on 2017/8/14.
 * 找到第K大的元素
 */

public class LC215 {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 5 ,8,9,1,2,3,4};
        //System.out.println(partition(arr,0,arr.length-1));
        //System.out.println(Arrays.toString(arr));
        System.out.println(findKth(arr,5));
    }

    public static int findKth(int[] arr,int k){

        if(arr.length == 1 && k == 1)
            return arr[0];
        int p = 0;
        int len = arr.length;
        int q = arr.length -1;
        int m;

        while(p <=q){

            m =partition(arr,p,q) ;
            int count = m + 1 -p;
            if(count == k)//个数
                return arr[m];
            if(count > k)
                q = m - 1;
            else{
                p = m + 1;
                k -= count;
            }
        }
        return -1;
    }
    //return arr[start]的位置
    public static int partition(int[] arr,int start,int end){
        int val = arr[start];
        int k = start;//k记录当前小于val的序列，从k+1开始存储
        for(int i = start +1 ; i <= end;i ++){
            if(val < arr[i])
                swap(arr,i,++k);
        }
        swap(arr,k,start);
        return k;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
