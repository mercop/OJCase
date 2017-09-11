package contest.LC;


/**
 * 修改至多一个元素变为不减序列，true
 */
public class LC4701 {
    public static void main(String[] args) {
        int nums[] = new int[]{3,4,2,3};
        System.out.println(checkPossibility(nums));
    }

    public static boolean checkPossibility(int[] nums) {
        if(nums.length == 1 || nums.length == 2)return true;
        int len = nums.length;
        int before = nums[1];
        int min = nums[0];
        int count = 0;
        if(nums[0] > nums[1]){
            min = nums[1];
            count ++;
        }
        int i = 2;
        while(i < len){
            if(nums[i] < before){
                count ++;
                if(min <= nums[i] && nums[i-2] <= nums[i])before = nums[i];
                else min = nums[i];

            } else before = nums[i];

            if(count >=2) return false;
            i++;
        }
        return true;
    }
}
