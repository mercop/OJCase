package contest.L360;

import java.util.Scanner;

/**
 * Created by mercop on 2017/8/31.
 */
public class L01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        double value1 = (x * 1.0) / (a + b);
        double value2 = (y * 1.0)/c;
        double value3 = (z * 1.0) /d;

        int sum = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        if(value1 > value2){
            if(value1 > value3){
                count1 = Integer.min(n/a,m/b);
                n -= count1 * a;
                m -= count1 * b;
                sum += count1 * x;
                sum += m/c * y;
                sum += n/d * z;
            }else{
                count3 = n/d;
                sum += count3 *z;
                n -= count3 * d;
                count1 = Integer.min(n/a,m/b);
                sum += count1 * x;
                n -= count1 * a;
                m -= count1 * b;

                count2 = m/c;
                sum += count2 * y;
                m -= count2 * c;
            }
        } else{
            if(value1 > value3){
                count2 = m/c;
                sum += count2 * y;
                m -= count2 * c;
                count1 = Integer.min(n/a,m/b);
                sum += count1 * x;
                n -= count1 * a;
                m -= count1 * b;
                count3 = n/d;
                sum += count3 *z;
                n -= count3 * d;

            }else{
                count3 = n/d;
                sum += count3 *z;
                n -= count3 * d;
                count2 = m/c;
                sum += count2 * y;
                m -= count2 * c;
                count1 = Integer.min(n/a,m/b);
                sum += count1 * x;
            }
        }
        System.out.println(sum);
    }
}
