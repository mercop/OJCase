package contest.jd;

import java.util.*;

/**
 * Created by mercop on 2017/9/8.
 */
public class jd01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            String s = in.nextLine();
            char[] chars = s.toCharArray();
            int res = 1;
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(') deque.push(i);
                if(chars[i] == ')') {
                    int count = deque.size();
                    res *= count;
                    deque.pop();
                }
            }
            System.out.println(res);
        }
    }
}
