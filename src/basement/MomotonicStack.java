package basement;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by mercop on 2017/9/6.
 * <p>
 * 单调栈，保证不重复
 * 解决问题： 找到x左边/右边离他最近的比他小的/大的数
 * 实现：找小的：维持栈底到头 从小到大，谁让X弹出，则x是其右边最近的最小数
 * 弹出时候，x的小面的数为左边最近的比他最小的数。
 * 如果全部结束，栈中仍有数，则这些数右边没有比其小的
 *
 * 出现重复数case: A <= C,C 弹出
 * case:4,5,3,4,5,3,4,5,后面3能正确算出值
 */
public class MomotonicStack {


    static  int[] left;
    static int[] right;

    //找小的
    public static void getMinScope(int[] nums){
        left = new int[nums.length];
        right = new int[nums.length];
        Deque<Integer> deque = new LinkedList<>();
        deque.push(-1); //压入index
        int index;
        for (int i = 0; i < nums.length; i++) {
            while(!deque.isEmpty() &&
                    (index = deque.peek()) != -1 &&
                    nums[index] >= nums[i]){
                right[index] = i;
                deque.pop();
                left[index] = deque.peek();
            }
            deque.push(i);
        }
        while(!deque.isEmpty() &&(index = deque.peek()) != -1 ){
            deque.pop();
            right[index] = -1;
            left[index] = deque.peek();
        }
    }
    //找大的
    public static void getMaxScope(int[] nums){
        left = new int[nums.length];
        right = new int[nums.length];
        Deque<Integer> deque = new LinkedList<>();
        deque.push(-1); //压入index
        int index;
        for (int i = 0; i < nums.length; i++) {
            while(!deque.isEmpty() &&
                    (index = deque.peek()) != -1 &&
                    nums[index] <= nums[i]){
                right[index] = i;
                deque.pop();
                left[index] = deque.peek();
            }
            deque.push(i);
        }
        while(!deque.isEmpty() &&(index = deque.peek()) != -1 ){
            deque.pop();
            right[index] = -1;
            left[index] = deque.peek();
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 4, 3, 8};
        //getMinScope(nums);
        getMaxScope(nums);
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
    }

}
