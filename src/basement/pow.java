package basement;

import java.util.ArrayList;

/**
 * Created by mercop on 2017/8/13.
 * 递归求解幂运算
 */

public class pow {
    public static void main(String[] args) {
        System.out.println(pow(0,-1));
        System.out.println(pow(2.0,5));
        System.out.println(pow(2.0,4));
    }

    public static double pow(double x, int n){
        if(n == 0)
            return 1;
        double t = pow(x,n/2);
        if(n % 2 == 1)
            return t * t * x;
        else
            return t * t;
    }
}
