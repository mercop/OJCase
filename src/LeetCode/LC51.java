package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mercop on 2017/9/2.
 * N-Queues
 */
public class LC51 {
    public static void main(String[] args) {
        int n = 14;
        List<List<String >> lists = solveNQueens(n);
        int len = lists.size();

        for(int i = 0; i < len ;i++) {
            for (String str : lists.get(i)) {
                System.out.println(str);
            }
            System.out.println();
        }
        System.out.println("个数：" + lists.size());
    }
    static boolean[] col,dia1,dia2;
    static List<List<String>> results = new ArrayList<>();
    public static void putQueue(int n,int index,List<Integer> res){
        if(index == n){
            results.add(getBoard(res,n));
            return;
        }

        for(int i = 0; i < n; i ++){
            if(!col[i] && !dia1[index + i] &&!dia2[index - i + n - 1]){
                res.add(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                putQueue(n,index + 1, new ArrayList<>(res));
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                res.remove(res.size() -1);
            }
        }

    }

    private static List<String> getBoard(List<Integer> res, int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i ++){
            sb.append(".");
        }
        for(int i = 0; i < n; i ++){
            sb.setCharAt(res.get(i),'Q');
            list.add(new String(sb.toString()));
            sb.setCharAt(res.get(i),'.');
        }
        return list;
    }

    public static List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        dia1 = new boolean[2*n -1];
        dia2 = new boolean[2*n -1];
        putQueue(n,0,new ArrayList<>());

        return results;
    }
}
