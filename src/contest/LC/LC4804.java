package contest.LC;

import java.util.BitSet;
import java.util.HashSet;

/**
 * Created by mercop on 2017/9/3.
 * <p>
 * Operation:
 * Flip all the lights.
 * Flip lights with even numbers.
 * Flip lights with odd numbers.
 * Flip lights with (3k + 1) numbers, k = 0, 1, 2, ..
 * <p>
 * Example 1:
 * Input: n = 1, m = 1.
 * Output: 2
 * Explanation: Status can be: [on], [off]
 * <p>
 * Example 2:
 * Input: n = 2, m = 1.
 * Output: 3
 * Explanation: Status can be: [on, off], [off, on], [off, off]
 */
public class LC4804 {
    // 超时--
    public static void main(String[] args) {
        System.out.println(flipLights(4, 100));
    }

    static HashSet<BitSet> result = new HashSet<>();

    public static int flipLights(int n, int m) {
        bitSet = new BitSet(n);
        count = m;
        bitSet.flip(1, n + 1);
        getAllPossible(n, m, 0, 0, 0);
        return result.size();
    }

    static BitSet bitSet;
    static int count;

    public static boolean isOdd(int a) {
        if ((a & 1) != 1) {   //是奇数
            return true;
        }
        return false;
    }

    public static void getAllPossible(int n, int m, int f1, int f2, int f3) {
        if (m == 0 ) {
            BitSet bit = new BitSet(n);
            bit.or(bitSet);
            int f4 = m - f1 -f2 -f3;
            if (isOdd(f1)) filpWithAll(bit, n);
            if (isOdd(f2)) filpWithEven(bit, n);
            if (isOdd(f3)) filpWithOld(bit, n);
            if (isOdd(f4)) filpWith3K(bit, n);
            result.add(bit);
            return;
        }

        getAllPossible(n, m - 1, f1 + 1, f2, f3);
        getAllPossible(n, m - 1, f1, f2 + 1, f3);
        getAllPossible(n, m - 1, f1, f2, f3 + 1);

    }

    static void filpWithAll(BitSet bitSet, int n) {
        for (int i = 1; i <= n; i++) {
            bitSet.flip(i);
        }
    }

    static void filpWithEven(BitSet bitSet, int n) {
        for (int i = 2; i <= n; i += 2) {
            bitSet.flip(i);
        }
    }

    static void filpWithOld(BitSet bitSet, int n) {
        for (int i = 1; i <= n; i += 2) {
            bitSet.flip(i);
        }
    }

    static void filpWith3K(BitSet bitSet, int n) {
        for (int k = 0; k <= n; k++) {
            int i = 3 * k + 1;
            if (i < n) bitSet.flip(i);
        }
    }

    //改进--超时
    public static void getAllPossible2(int n, int m, int f1, int f2, int f3) {
        if (m == 0) {
            BitSet bit = new BitSet(n);
            bit.or(bitSet);
            int f4 = m - f1 -f2 -f3;
            if (isOdd(f1)) filpWithAll(bit, n);
            if (isOdd(f2)) filpWithEven(bit, n);
            if (isOdd(f3)) filpWithOld(bit, n);
            if (isOdd(f4)) filpWith3K(bit, n);
            result.add(bit);
            return;
        }

    }
}
