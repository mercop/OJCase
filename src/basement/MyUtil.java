package basement;

import java.util.Random;

/**
 * Created by mercop on 2017/8/13.
 */

public class MyUtil {

    static int[] generateRandomArray(int n, int rangeL, int rangeR) {

        assert( n > 0 && rangeL <= rangeR );

        int[] arr = new int[n];
        Random ra = new Random();
        for (int i = 0; i < n; i++)
            arr[i] = ra.nextInt() % (rangeR - rangeL + 1) + rangeL;
        return arr;
    }

    static int[] generateOrderedArray(int n) {

        assert( n > 0 );
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = i;
        return arr;
    }
}
