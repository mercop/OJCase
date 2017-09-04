package LeetCode;

/**
 * Created by mercop on 2017/9/4.
 * 动态规划求解棋盘最短路径
 */
public class LC64 {

    public static void main(String[] args) {
        int [][] grid = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] pathLen = new int[m][n];

        pathLen[0][0] = grid[0][0];
        for(int i = 1; i < m; i ++){
            pathLen[i][0] = pathLen[i - 1][0] + grid[i][0];
        }
        for(int j = 1; j < n; j ++){
            pathLen[0][j] = pathLen[0][j -1] + grid[0][j];
        }
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++){
                pathLen[i][j] = Integer.min(pathLen[i -1][j], pathLen[i][j - 1]) + grid[i][j];
            }
        return pathLen[m -1][n -1];
    }
}
