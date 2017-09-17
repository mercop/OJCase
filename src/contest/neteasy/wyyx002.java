package contest.neteasy;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by mercop on 2017/9/16.
 */
public class wyyx002 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        nonquickSort(nums,0,n-1);
        for(int i =0; i < n - 1; i++)
            System.out.print(nums[i] + " ");
        System.out.print(nums[n -1]);
    }

    private static void nonquickSort(int[] a,int start,int end) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        if(start < end) {
            stack.push(end);
            stack.push(start);
            while(!stack.isEmpty()) {
                int l = stack.pop();
                int r = stack.pop();
                int index = partition(a, l, r);
                if(l < index - 1) {
                    stack.push(index-1);
                    stack.push(l);
                }
                if(r > index + 1) {
                    stack.push(r);
                    stack.push(index+1);
                }
            }
        }
    }

    private static int partition(int[] a, int start, int end) {
        int pivot = a[start];
        while(start < end) {
            while(start < end && a[end] >= pivot)
                end--;
            a[start] = a[end];
            while(start < end && a[start] <= pivot)
                start++;
            a[end] = a[start];
        }
        a[start] = pivot;
        return start;
    }
}
