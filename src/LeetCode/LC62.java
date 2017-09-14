package LeetCode;

/**
 * Created by mercop on 2017/9/5.
 * 动态规划-机器人从左上角到右下角的所有路径可能
 */
public class LC62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(7,5));
    }

    public static int uniquePaths(int m, int n) {
        return uniquePaths(1,1,m, n);
    }

    public static int uniquePaths(int currentRow, int currentColumn, int m, int n){
        if(currentRow==m || currentColumn==n){
            return 1;
        }
        return uniquePaths(currentRow+1, currentColumn, m ,n ) + uniquePaths(currentRow, currentColumn+1, m, n);
    }

    //dp
    public int uniquePaths2(int m, int n) {
        int[][] grids = new int[m][n];
        for(int i = 0; i < n; i++){
            grids[0][i] = 1;
        }
        for(int i = 1; i < m; i++){
            grids[i][0] = 1;
        }
        for(int i = 1; i < m ; i++){
            for(int j = 1; j < n; j++){
                grids[i][j] = grids[i-1][j] + grids[i][j-1];
            }
        }
        return grids[m-1][n-1];
    }
}
