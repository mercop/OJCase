package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by mercop on 2017/8/23.
 * 括号匹配
 */

public class LC20 {

    public static void main(String[] args) {
        String str = "]";
        System.out.println(isValid(str));
    }

    public static boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        char[] chars = s.toCharArray();
        for(char c : chars){
            if(c == '(' || c == '[' || c == '{')
                deque.push(c);
            else if(!deque.isEmpty()){
                Character current = deque.peek();
                if((c == ')' && current.equals('('))
                        ||(c == ']' && current.equals('['))
                        ||(c == '}' && current.equals('{'))){
                    deque.pop();
                } else return false;
            } else return false;
        }
        if(deque.isEmpty())
            return true;
        return false;
    }
}
