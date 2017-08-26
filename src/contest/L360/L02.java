package contest.L360;

import java.util.Scanner;

public class L02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] scores = new int[n];

        for(int i = 0; i < n; i++){
            scores[i++] = in.nextInt();
        }
        int i = 0;
        int[] result = new int[n];
        for(i = 1 ; i < scores.length; i++){
            int j = i - 1;
            while(j >= 0){
                if(scores[j] > scores[i]){
                    result[i] += 1;
                } j --;
            }
        }

        for(i = 0; i < result.length -1; i ++)
            System.out.print(result[i] + " ");
        System.out.print(result[result.length -1]);

    }
}
