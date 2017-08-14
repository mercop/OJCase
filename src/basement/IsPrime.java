package basement;

/**
 * Created by mercop on 2017/8/13.
 * 判断一个数是否是素数
 */

public class IsPrime {


    public static void main(String[] args) {
        System.out.println(isPrime(6));
    }

    public static boolean isPrime(int n){
        if(n == 1 || n ==0)
            return false;
        for(int i = 2; i * i < n; i ++){
            if(n % i == 0)
                return false;
        }
        return true;
    }
}
