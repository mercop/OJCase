package contest.LC;

/**
 *  Input: [113, 215, 221]
    Output: 12
    Explanation:
    The tree that the list represents is:
      3
     / \
    5   1
 * The path sum is (3 + 5) + (3 + 1) = 12.
 * 根据数字百位为层数，十位为节点在该层的位置，个位表示节点的值。
 * 求所有路径的和
 */
public class LC4702 {
    public static void main(String[] args) {
        int nums[] = new int[]{113,229,330,466};
        System.out.println(pathSum(nums));
    }

    public static int pathSum(int[] nums) {
        int[] treeNode = new int[32];
        for(int i =0; i < treeNode.length;i++)
            treeNode[i] = -1;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int j = 2;
            int[] digits = new int[3];
            while (num > 0) {
                digits[j--] = num % 10;
                num /= 10;
            }
            index = (int) (Math.pow(2, digits[0] - 1) - 1) + digits[1] - 1;
            treeNode[index] = digits[2];
        }

        sumOfPath(treeNode,0,0,index + 1);
        return sum;
    }

    static int sum = 0;

    public static void sumOfPath(int[] treeNode, int currentSum, int index,int len) {
        if (index >= len)
            return;
        if(treeNode[index] == -1 && treeNode[index * 2 + 1] == -1&&treeNode[index * 2 + 2]==-1 )
            return;
        currentSum += treeNode[index];
        if ((treeNode[index * 2 + 1] == -1&&treeNode[index * 2 + 2]==-1 )) {
            sum += currentSum;
        } else {
            sumOfPath(treeNode,currentSum,index * 2 + 1,len);
            sumOfPath(treeNode,currentSum,index * 2 + 2,len);
        }
    }
}
