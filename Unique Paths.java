import java.util.* ;
import java.io.*; 
public class Solution {
    
// DP Tabulation - Bottom Up 
    public static int uniquePaths(int m, int n) {
        // Write your code here.
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    dp[0][0] = 1;
                }
                else {
                    int up = 0, left = 0;
                    if(i > 0) {
                        up = dp[i-1][j];
                    }
                    if(j > 0) {
                        left = dp[i][j-1];
                    }
                    dp[i][j] = left + up;
                }
            }
        }
        return dp[m-1][n-1];
    }
    
    
    // DP Memoization
//     public static int uniquePaths(int m, int n) {
//         // Write your code here.
//         int[][] dp = new int[m][n];
//         for(int i = 0; i < m; i++) {
//             for(int j = 0; j < n; j++) {
//                 dp[i][j] = -1;
//             }
//         }
//         return helper(m-1, n-1, dp);
//     }
//     private static int helper(int i, int j, int[][] dp) {
//         if(i == 0 && j == 0) {
//             return 1;
//         }
//         if(i < 0 || j < 0) {
//             return 0;
//         }
//         if(dp[i][j] != -1) {
//             return dp[i][j];
//         }
//         int up = helper(i-1, j, dp);
//         int left = helper(i, j-1, dp);
//         return dp[i][j] = (up + left);
//     }
    
    
//     Recursion Solution
// 	public static int uniquePaths(int m, int n) {
// 		// Write your code here.
//         return helper(m-1, n-1);
// 	}
//     private static int helper(int i, int j) {
//         if(i == 0 && j == 0) {
//             return 1;
//         }
//         if(i < 0 || j < 0) {
//             return 0;
//         }
//         int up = helper(i-1, j);
//         int left = helper(i, j-1);
//         return (up + left);
//     }
}