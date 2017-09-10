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
        int maxRight = 0;
        boolean visited[] = new boolean[str.length()];
        for(int i = 0; i < chars.length;i ++){
            int curCount = 1;
            if(visited[i]) continue;
            for(int j = i + 1; j < chars.length;j ++){
                if(chars[i] == chars[j] && j > maxRight) {
                    if(!visited[j]){
                        count +=2;
                        curCount ++;
                        maxRight = j;
                        visited[j] = true;
                        if(curCount == 2) break;
                    }

                }
            }
        }
        System.out.println(count);
    }
}
