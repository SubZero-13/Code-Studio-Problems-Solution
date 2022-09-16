import java.util.* ;
import java.io.*; 

public class Solution {
    
//     DP Tabulation
    public static int getMaxPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(m == 0) {
            return 0;
        }
        int dp[][] = new int[m][n];
        for(int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }
        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int up = matrix[i][j] + dp[i-1][j];
                int rdgu = ((-1)*((int)1e9));
                int ldgu = ((-1)*((int)1e9));
                if(j < n-1) rdgu = matrix[i][j] + dp[i-1][j+1];
                if(j > 0) ldgu = matrix[i][j] + dp[i-1][j-1];
                dp[i][j] = Math.max(up, Math.max(ldgu, rdgu));
            }
        }
        int res = dp[m-1][0];
        for(int j = 1; j < n; j++) {
            res = Math.max(dp[m-1][j], res);
        }
        return res;
    }
            
//     Recursion with Memoized DP
//     static int dp[][];
// 	public static int getMaxPathSum(int[][] matrix) {
// 		int res = Integer.MIN_VALUE;
//         int m = matrix.length;
//         int n = matrix[0].length;
//         dp = new int[m][n];
//         for(int[] row: dp) {
//             Arrays.fill(row, -1);
//         }
//         for(int j = 0; j < n; j++) {
//             int temp = helper(matrix.length-1, j, matrix);
//             res = Math.max(res, temp);
//         }
//         return res;
// 	}
//     private static int helper(int i, int j, int[][] mat) {
//         if(j < 0 || j >= mat[0].length) {
//             return ((-1) * ((int)1e9));
//         }
//         if(i == 0) {
//             return mat[i][j];
//         }
//         if(dp[i][j] != -1) {
//              return dp[i][j];
//         }
//         int up = mat[i][j] + helper(i-1, j, mat);
//         int rdgu = mat[i][j] + helper(i-1, j+1, mat);
//         int ldgu = mat[i][j] + helper(i-1, j-1, mat);
//         return dp[i][j] = Math.max(up, Math.max(ldgu, rdgu));
//     }
}