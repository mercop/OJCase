package aliqiyi;

import java.util.*;

/**
 * Created by mercop on 2017/9/10.
 */
public class aqy02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            if(nums[i] > max) max = nums[i];
        }
        visited = new boolean[max + 1];

        Arrays.sort(nums);
        getSelections(nums,0,new StringBuilder());
        System.out.println(list.size());
    }

    static boolean visited[];

    static Set<String> list = new HashSet<>();

    public static void getSelections(int[] nums, int index, StringBuilder sb) {
        if (nums.length == index){
            list.add(sb.toString());
            return;
        }
        for (int i = index; i < nums.length; i++) {
            int x = nums[i];
            while (x > 0) {
                if (!visited[x]) {
                    visited[x] = true;
                    sb.append(x);
                    getSelections(nums, index + 1,new StringBuilder(sb));
                    visited[x] = false;
                    sb.deleteCharAt(sb.length() -1);
                }
                x --;
            }
        }
    }
}
