package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by mercop on 2017/8/23.
 * 简化路径
 * /../ -> /
 * //home -> /home
 */
public class LC71 {
    public static void main(String[] args) {
        String str = "/.";
        System.out.println(simplifyPath(str));
    }

    public static String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<>();
        String strs[] = path.split("/");
        for (String str : strs) {
            if (str == null || str.equals("")||str.equals("."))
                continue;
            if (str.equals("..")) {
                if (!deque.isEmpty()) deque.pop();
            } else deque.push(str);
        }

        if(deque.isEmpty())
            return "/";
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append("/");
            sb.append(deque.pollLast());
        }
        return sb.toString();
    }
}
