package LeetCode;

/**
 * Created by mercop on 2017/8/31.
 * 水域岛屿问题 FloodFill算法问题
 */
public class LC200 {

    public static void main(String[] args) {
        String[] strs = {
                "11000",
                "11000",
                "00100",
                "00001"};
        char[][] grid = new char[4][5];
        for (int i = 0; i < strs.length; i++) {
            grid[i] = strs[i].toCharArray();
        }
        System.out.println(numIslands(grid));
    }

    static int pos[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int m, n;

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    static boolean[][] visited;

    //FloodFill
    public static void dfs(char[][] grid, int x, int y) {

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int mx = pos[i][0] + x;
            int my = pos[i][1] + y;
            if (mx >= 0 && mx < m && my >= 0 && my < n && !visited[mx][my] && grid[mx][my] == '1')
                dfs(grid, mx, my);
        }
    }
}
