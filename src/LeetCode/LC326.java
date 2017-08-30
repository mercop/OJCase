package LeetCode;

public class LC326 {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(81));
    }

    public static boolean isPowerOfThree(int n) {
        double des = Math.log10(n) / Math.log10(3);
        return ((des) - (int)des) ==0 ? true:false;
    }
}
