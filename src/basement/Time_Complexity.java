package basement;

import org.junit.Test;

import java.util.Random;

/**
 * Created by mercop on 2017/8/13.
 */

public class Time_Complexity {

    // O(logN)
    public static int binarySearch(int arr[], int n, int target) {

        int l = 0, r = n - 1;
        while (l <= r) {

            int mid = l + (r - l) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] > target) r = mid - 1;
            else l = mid + 1;
        }

        return -1;
    }

    // O(N)
    int findMax( int arr[], int n ){

        assert( n > 0 );

        int res = arr[0];
        for( int i = 1 ; i < n ; i ++ )
            if( arr[i] > res )
                res = arr[i];

        return res;
    }

    // O(NlogN)
    void __merge(int arr[], int l, int mid, int r, int aux[]){

        int i = l, j = mid+1;
        for( int k = l ; k <= r; k ++ ){

            if( i > mid )   { arr[k] = aux[j]; j ++;}
            else if( j > r ){ arr[k] = aux[i]; i ++;}
            else if( aux[i] < aux[j] ){ arr[k] = aux[i]; i ++;}
            else                      { arr[k] = aux[j]; j ++;}
        }
    }

    void mergeSort( int arr[], int n ){

        int[] aux = new int[n];
        for( int i = 0 ; i < n ; i ++ )
            aux[i] = arr[i];

        for( int sz = 1; sz < n ; sz += sz )
            for( int i = 0 ; i < n ; i += sz+sz )
                __merge(arr, i, i+sz-1, Integer.min(i+sz+sz-1,n-1), aux );

        aux = null;
        return;
    }

    // O(N^2)
    void selectionSort( int arr[], int n ){

        for(int i = 0 ; i < n ; i ++){
            int minIndex = i;
            for( int j = i + 1 ; j < n ; j ++ )
                if( arr[j] < arr[minIndex] )
                    minIndex = j;

            swap(arr,i, minIndex);
        }
        return;
    }

    void swap(int arr[],int i, int j){
        arr[i] = arr[i] ^arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    @Test
    public void test(){
        for( int i = 10 ; i <= 16 ; i ++ ){

            int n = (int)Math.pow(2.0,(double) i);
            int[] arr = MyUtil.generateRandomArray(n, 0, 100000000);

            long startTime = System.currentTimeMillis();
            selectionSort(arr,n);
            long endTime = System.currentTimeMillis();

            System.out.print("data size 2^" + i + " = " + n + "\t");
            System.out.println("Time cost: " + (endTime - startTime) + "ms");
        }
    }

    @Test
    public void test2(){

        Random ra = new Random();
        for( int i = 10 ; i <= 28 ; i ++ ){

            int n = (int)Math.pow(2.0,(double) i);


            int[] arr = MyUtil.generateOrderedArray(n);

            long startTime = System.currentTimeMillis();
            int x = binarySearch(arr,n,ra.nextInt(1000));
            long endTime = System.currentTimeMillis();

            System.out.print("data size 2^" + i + " = " + n + "\t");
            System.out.println("Time cost: " + (endTime - startTime) + "ms");
        }
    }


}
