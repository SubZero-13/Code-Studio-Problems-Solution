import java.util.* ;
import java.io.*; 
public class Solution {
    
    // DP Tabulation
    public static boolean subsetSumToK(int n, int k, int arr[]){
        boolean dp[][] = new boolean[n][k+1];
        if(arr[0] <= k) {
            dp[0][arr[0]] = true;
        }
        for(int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        
        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= k; j++) {
                boolean notTake = dp[i-1][j];
                boolean take = false;
                if(arr[i] <= j) {
                    take = dp[i-1][j-arr[i]];
                }
                dp[i][j] = take || notTake;
            }
        }
        return dp[n-1][k];
    }
    
//     DP Memoization      
//     public static boolean subsetSumToK(int n, int k, int arr[]){
//         // Write your code here.
//         Boolean dp[][] = new Boolean[n+1][k+1];
//         return helper(arr, n-1, k, dp);
        
//     }
//     private static boolean helper(int arr[], int idx, int k, Boolean dp[][]) {
//         if(k==0) return true;
//         if(idx == 0) return arr[0] == k;
        
//         if(dp[idx][k] != null) {
//             return dp[idx][k];
//         }
//         boolean notTake = helper(arr, idx-1, k, dp);
//         boolean take = false;
//         if(arr[idx] <= k) {
//             take = helper(arr, idx-1, k-arr[idx], dp);
//         }
//         return dp[idx][k] = take || notTake;
//     }
}