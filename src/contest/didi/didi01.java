package contest.didi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class didi01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (in.hasNextInt()) {//注意while处理多个case
            list.add(in.nextInt());
        }
        if(list.size() == 0) return;
        int len = list.size();
        int currentSum = 0;
        int maxSum = list.get(0);

        for(int i = 0; i < len; i++){
            if(currentSum > 0){
                currentSum += list.get(i);
            } else currentSum = list.get(i);

            if(currentSum > maxSum){
                maxSum = currentSum;
            }
        }
        System.out.println(maxSum);
    }
}