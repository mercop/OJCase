package aliqiyi;

import java.util.Scanner;

/**
 * Created by mercop on 2017/9/10.
 */
public class aqy03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        int count = 0;
        for(int i = 0; i < chars.length;i ++){
            for(int j = i + 1; j < chars.length;j ++){
                if(chars[i] == chars[j]) {
                    count +=2;
                }
            }
        }
        System.out.println(count);
    }
}
