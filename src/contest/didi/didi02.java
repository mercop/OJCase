package contest.didi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class didi02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        while (in.hasNextInt()) {//注意while处理多个case
            list.add(in.nextInt());
        }
        int len = list.size() -1;
        int k = list.get(len);
        list.remove(len);

        System.out.println(findKth(list,k));
    }

    public static int findKth(List<Integer> arr, int k) {

        if (arr.size() == 1 && k == 1)
            return arr.get(0);
        int p = 0;
        int len = arr.size();
        int q = arr.size() - 1;
        int m;

        while (p <= q) {

            m = partition(arr, p, q);
            int count = m + 1 - p;
            if (count == k)//个数
                return arr.get(m);
            if (count > k)
                q = m - 1;
            else {
                p = m + 1;
                k -= count;
            }
        }
        return -1;
    }

    //return arr[start]的位置
    public static int partition(List<Integer> arr, int start, int end) {
        int val = arr.get(start);
        int k = start;//k记录当前小于val的序列，从k+1开始存储
        for (int i = start + 1; i <= end; i++) {
            if (val < arr.get(i))
                swap(arr, i, ++k);
        }
        swap(arr, k, start);
        return k;
    }

    public static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
    }
}
