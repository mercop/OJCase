package contest.aliqiyi;

import java.util.Scanner;

/**
 * Created by mercop on 2017/9/10.
 */
public class aqy01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int res = 0;
        int max = 0;
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] =='(') {
                res ++;
                if(max < res) max =res;
            } else if(chars[i] == ')') res --;
        }
        System.out.println(max);
    }
}
