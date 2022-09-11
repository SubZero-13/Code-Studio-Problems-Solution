import java.util.*;
import java.lang.*;
public class Solution {
    
//     DP with Tabulation
    public static int minSumPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                }
                else {
                    int up = grid[i][j];
                    int left = grid[i][j];
                    if(i > 0) up += dp[i-1][j];
                    else up += (int)Math.pow(10,9);
                    if(j > 0) left += dp[i][j-1];
                    else left += (int)Math.pow(10,9);
                    dp[i][j] = Math.min(up, left);
                }
            }
        }
         return dp[m-1][n-1];
    }
    
    
//     Recurssion with Memoization 
//     public static int minSumPath(int[][] grid) {
//     	// Write your code here.
//         int m = grid.length;
//         int n = grid[0].length;
//         int dp[][] = new int[m][n];
//         for(int[] row: dp) {
//             Arrays.fill(row, -1);
//         }
//         return min(grid, m-1, n-1, dp);
//     }
//     private static int min(int[][] grid, int i , int j, int dp[][]) {
//         if(i == 0 && j == 0) {
//             return grid[0][0];
//         }
//         if(i < 0 || j < 0) {
//             return (int)Math.pow(10,9);
//         }
//         if(dp[i][j] != -1) {
//             return dp[i][j];
//         }
//         int up = grid[i][j] + min(grid, i, j-1, dp);
//         int left = grid[i][j] + min(grid, i-1, j, dp);
//         return dp[i][j] = Math.min(up, left);
//     }
}