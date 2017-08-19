package basement;

import org.junit.Test;

/**
 * Created by mercop on 2017/8/16.
 */

public class MoveOperation {
    @Test
    public void test(){
        int n = 21;
        System.out.println(n <<1);
    }

    @Test
    public void test2(){
        //8 * 10^8 在int范围内
        boolean x = Math.pow(10,9) * 8 > Integer.MAX_VALUE;
        System.out.println(x);
    }
}
