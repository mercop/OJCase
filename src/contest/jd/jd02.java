package contest.jd;

import java.util.Scanner;

/**
 * Created by mercop on 2017/9/8.
 */
public class jd02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            int n = in.nextInt();
            long res = (long)Math.pow(n,2);
            int k = Math.abs(n);
            int l = n;
            boolean[][] visied = new boolean[n + 1][n + 1];
            for(int i = 1 ; i <= k ; i++){
                int count = 0;

                for (int j = l; j >= 1; j --){
                    if(visied[i][j]) continue;
                    if(i!= j){
                        int newI = i * i;
                        if(newI < n){
                            count++;
                        }
                        visied[i][j] =true;
                    }

                }
                res += process(count) * 2;
            }
            System.out.println(res);
        }
    }

    public static int process(int n){
        int res = 1;
        while(n-- > 1){
            res *= n;
        }
        return res;
    }
}
