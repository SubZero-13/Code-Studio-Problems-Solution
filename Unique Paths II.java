import java.util.*;
import java.lang.*;
public class Solution {
    
//  DP Tabulation - Bottom-Up     
    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int dp[][] = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i >= 0 && j >= 0 && mat.get(i).get(j) == -1) dp[i][j] = 0;
                else {
                    if(i == 0 && j == 0) dp[i][j] = 1;
                    else {
                        int up = 0, left  = 0;
                        if(i > 0) up = dp[i-1][j];
                        if(j > 0) left = dp[i][j-1];
                        dp[i][j] = (up + left) % (int)(1e9 + 7);
                    }
                }
            }
        }
        return dp[n-1][m-1];
    }
    
    
//     DP Memoization - Top Down
//     static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
//         int dp[][] = new int[n][m];
//         for(int i = 0; i < n; i++) {
//             for(int j = 0; j < m; j++) {
//                 dp[i][j] = -1;
//             }
//         }
//         return helper(n-1, m-1, mat, dp)%(int)(1e9 + 7);
//     }
//     private static int helper(int i, int j, ArrayList<ArrayList<Integer>> mat, int dp[][]) {
//         if(i >= 0 && j >=0 && mat.get(i).get(j) == -1) {
//             return 0;
//         }
//         if(i == 0 && j == 0) {
//             return 1;
//         }
//         if(i < 0 || j < 0) {
//             return 0;
//         }
//         if(dp[i][j] != -1) {
//             return dp[i][j];
//         }
//         int up = helper(i-1, j, mat, dp);
//         int left = helper(i, j-1, mat, dp);
//         return dp[i][j] = (up + left)%(int)(1e9 + 7);
//     }
    
//     Recursion Solution 
//     static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
//         return helper(n-1, m-1, mat)%(int)(1e9 + 7);
//     }
//     private static int helper(int i, int j, ArrayList<ArrayList<Integer>> mat) {
//         if(i >= 0 && j >=0 && mat.get(i).get(j) == -1) {
//             return 0;
//         }
//         if(i == 0 && j == 0) {
//             return 1;
//         }
//         if(i < 0 || j < 0) {
//             return 0;
//         }
//         int up = helper(i-1, j, mat);
//         int left = helper(i, j-1, mat);
//         return (up + left)%(int)(1e9 + 7);
//     }

}