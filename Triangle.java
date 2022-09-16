import java.util.* ;
import java.io.*; 
public class Solution {
//     DP Tabulation
        public static int minimumPathSum(int[][] triangle, int n) {
            int dp[][] = new int[n][n];
            for(int j = 0; j <= n-1; j++) {
                dp[n-1][j] = triangle[n-1][j];
            }
            for(int i = n-2; i >= 0; i--) {
                for(int j = 0; j <= i; j++) {
                    dp[i][j] = triangle[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1]);
                }
            }
            return dp[0][0];
        }
    
    
//     Recursion with Memoization
//     public static int minimumPathSum(int[][] triangle, int n) {
//         // Write your code here.
//         int dp[][] = new int[n][n];
//         for(int[] row: dp) {
//             Arrays.fill(row, -1);
//         }
//         return helper(triangle, 0, 0, dp);
//     }
    
//     private static int helper(int[][] triangle, int i, int j, int[][] dp) {
//         if(i == triangle.length-1) {
//             return triangle[i][j];
//         }
//         if(dp[i][j] != -1) {
//             return dp[i][j];
//         }
//         int d = triangle[i][j] + helper(triangle, i+1, j, dp);
//         int dg = triangle[i][j] + helper(triangle, i+1, j+1, dp);
        
//         return dp[i][j] = Math.min(d, dg);
//     }
}