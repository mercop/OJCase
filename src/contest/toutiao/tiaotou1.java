package contest.toutiao;

/**
 * Created by mercop on 2017/8/22.
 * 超时
 *
 * https://www.nowcoder.com/discuss/34191
 *
 * 思路 先排序x，在从后向前对外进行操作，如果当前点大于当前集合最大点y，则属于，否则，不属于
 */
import java.util.Scanner;

public class tiaotou1 {

    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();

        int[][] point = new int[n][2];
        if(n > 500000 || n < 1)
            return ;
        for(int i = 0; i < n; i ++){

            point[i][0] = cin.nextInt();
            point[i][1] = cin.nextInt();
        }
        boolean macthed = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n;j++) {
                macthed = true;
                if (point[i][0] < point[j][0] && point[i][1] < point[j][1]){
                    macthed = false;
                    break;
                }
            }
            if(macthed)
                System.out.println(point[i][0] +" " + point[i][1]);
        }
    }
}


