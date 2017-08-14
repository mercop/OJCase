package basement;

/**
 * Created by mercop on 2017/8/14.
 */

public class baseUtilFunction {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
