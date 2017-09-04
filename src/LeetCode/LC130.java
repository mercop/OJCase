package LeetCode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by mercop on 2017/9/2.
 * 将被X包围的O字符翻转为X
 */
public class LC130 {

    public static void main(String[] args) {
        String[] strs = {"XXXX", "XOOX", "XXOX", "XOXX"};
        char[][] grid = new char[4][4];
        for (int i = 0; i < strs.length; i++) {
            grid[i] = strs[i].toCharArray();
        }
        solve(grid);
        System.out.println(Arrays.deepToString(grid));
    }

    static int[][] pos = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean visited[][];
    static boolean turn[][];
    static int m, n;

    public static void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        Deque<Pair<Integer, Integer>> pointsDeque = new LinkedList<>();
        turn = new boolean[m][n];


        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (board[i][j] == 'O') {
                        turn[i][j] = true;
                        pointsDeque.offer(new Pair(i, j));
                    }
                }
            }
        while (!pointsDeque.isEmpty()) {
            Pair<Integer, Integer> point = pointsDeque.poll();
            visited[point.key][point.value] = true;
            for (int i = 0; i < 4; i++) {
                int mx = pos[i][0] + point.key;
                int my = pos[i][1] + point.value;
                if (mx >= 0 && mx < m && my >= 0 && my < n && !visited[mx][my] && board[mx][my] == 'O') {
                    pointsDeque.offer(new Pair<>(mx, my));
                    turn[mx][my] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!turn[i][j] && board[i][j] == 'O') board[i][j] = 'X';
            }
        }

    }

    static public class Pair<K, V> {
        private K key;

        public K getKey() {
            return key;
        }

        private V value;

        public V getValue() {
            return value;
        }

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
