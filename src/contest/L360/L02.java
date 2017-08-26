package contest.L360;

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
        for(i = 0; i < scores.length; i++){
            int sum = 0;
            for(int j = 0; j < i; j ++){
                if(scores[i] < scores[j])
                    sum ++;
            }
            System.out.print(sum + " ");
        }
    }
}
