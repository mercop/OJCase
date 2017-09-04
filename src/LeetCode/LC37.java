package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mercop on 2017/9/3.
 * 数独求解问题
 */
public class LC37 {

    public static void main(String[] args) {
        String[] strs = {
                "..9748...",
                "7........",
                ".2.1.9...",
                "..7...24.",
                ".64.1.59.",
                ".98...3..",
                "...8.3.2.",
                "........6",
                "...2759.."};
        char[][] board = new char[9][9];
        for (int i = 0; i < strs.length; i++) {
            board[i] = strs[i].toCharArray();
        }
        solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            System.out.println(board[i]);
        }
    }

    static boolean visited[][];
    static boolean col[][];//col[i][x] 第i列是否有x
    static boolean row[][];
    static int blankCount = 0;
    static List<Pair<Integer,Integer>> blanksList = new ArrayList<>();

    static public class Pair<K,V> {
        public K key;
        public V value;
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        col = new boolean[9][10];
        row = new boolean[9][10];
        visited = new boolean[9][9];

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    col[j][c - '0'] = true;
                    row[i][c - '0'] = true;

                } else {
                    blankCount++;
                    blanksList.add(new Pair<>(i,j));

                }
            }

        putNums(board, 0, new ArrayList<>());
    }

    public static void putNums(char[][] board, int index, List<Integer> res) {

        if (index == blankCount) {
            getBoard(res, board);
            return;
        }
        for(int m = 0; m < blanksList.size(); m ++){
            Pair<Integer,Integer> pair = blanksList.get(m);
            int i = pair.key;
            int j = pair.value;
            for (int k = 1; k <= 9; k++) {
                if (!col[j][k] && !row[i][k]) {
                    col[j][k] = true;
                    row[i][k] = true;
                    res.add(k);
                    putNums(board, index + 1, new ArrayList<>(res));
                    col[j][k] = false;
                    row[i][k] = false;
                    res.remove(res.size() - 1);
                }
            }
        }
    }

    private static void getBoard(List<Integer> res, char[][] board) {
        for (int i = 0, k = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    board[i][j] = (char) (res.get(k++) + '0');
                }
            }
    }
}
