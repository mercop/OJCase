package basement;

import java.util.BitSet;

/**
 * Created by mercop on 2017/9/3.
 */
public class bitset {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet(3);
        bitSet.flip(1,4);
        System.out.println(bitSet.cardinality());
        System.out.println(bitSet.length());
        System.out.println(bitSet.get(0));
        System.out.println(bitSet.get(1));
        System.out.println(bitSet.get(3));
    }
}
