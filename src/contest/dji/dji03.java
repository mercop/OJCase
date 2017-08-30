package contest.dji;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 找到字符串中的dji组合，要求顺序
 * 1
 * ddiajiji
 */
public class dji03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++)
            strs[i] = sc.next();
        int count = 0;

        List<Integer> dList = new ArrayList<>();
        List<Integer> jList = new ArrayList<>();
        List<Integer> iList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == 'd') dList.add(j);
                else if (chars[j] == 'j') jList.add(j);
                else if (chars[j] == 'i') iList.add(j);
            }
            int ji = 0;
            for (int m = 0; m < dList.size(); m++) {
                int di = dList.get(m);
                int p = 0;
                while (p < jList.size() && jList.get(p) < di) p++;
                for (; p < jList.size(); p++) {
                    ji = jList.get(p);
                    int q = 0;
                    while (q < iList.size() && iList.get(q) < ji) q++;
                    for (; q < iList.size(); q++) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
