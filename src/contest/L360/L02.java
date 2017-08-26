package contest.L360;

import java.util.Arrays;
import java.util.Scanner;

public class L02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] scores = new int[n];
        int i = 0;
        while (in.hasNextInt()) {//注意while处理多个case
            scores[i++] = in.nextInt();
        }
        int[] result = new int[n];
        for(i = 1 ; i < scores.length; i++){
            int j = i - 1;
            while(j >= 0){
                if(scores[j] > scores[i]){
                    result[i] += 1;
                } j --;
            }
        }

        System.out.println(Arrays.toString(result));
    }
}
