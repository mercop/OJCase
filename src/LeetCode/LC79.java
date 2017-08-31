package LeetCode;

/**
 * Created by mercop on 2017/8/31.
 * 二维平面单词搜索
 * <p>
 * Given board =
 * <p>
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
public class LC79 {

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board,"ABCCED"));
        System.out.println(exist(board,"SEE"));
        System.out.println(exist(board,"ABCB"));
    }
    //二维数组 移动 偏移数组
    static int[][] pos = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static boolean[][] visited;

    static int m, n;

    static boolean inAreas(int x, int y) {
        if (x >= 0 && x < m && y >= 0 && y < n) return true;
        else return false;
    }

    static boolean searchWord(char[][] board, String word, int index, int startx, int starty) {
        if (index == word.length() - 1) return board[startx][starty] == word.charAt(index);

        if (board[startx][starty] == word.charAt(index)) {
            visited[startx][starty] = true;
            for (int i = 0; i < 4; i++) {
                int newX = startx + pos[i][0];
                int newY = starty + pos[i][1];
                if(inAreas(newX, newY) && !visited[newX][newY] &&
                        searchWord(board, word, index + 1, newX, newY))
                    return true;
            }
            visited[startx][starty] = false;
        }
        return false;

    }

    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length <= 0) return false;
        m = board.length;
        n = board[0].length;

        visited = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (searchWord(board, word, 0, i, j)) return true;
            }
        return false;
    }
}
