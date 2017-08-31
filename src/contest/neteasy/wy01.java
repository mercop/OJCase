package contest.neteasy;

import java.util.Scanner;

/**
 * Created by mercop on 2017/8/12.
 * 独立的小易
 */

public class wy01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int x = in.nextInt();
            int f = in.nextInt();
            int d = in.nextInt();
            int p = in.nextInt();

            if(d <= x * f){
                System.out.println(d/x);
            } else{
                int days = f + (d - x * f)/(x + p);
                System.out.println(days);
            }
        }
    }
}
