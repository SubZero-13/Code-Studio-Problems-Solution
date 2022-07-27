import  java.util.*;
import java.lang.*;
public class Solution {
    // Recursion and Memoization solution
//     public static int frogJump(int n, int heights[]) {
//         int dp[] = new int[n+1];
//         for(int i = 0; i < n+1; i++) {
//             dp[i] = -1;
//         }
//         return helper(n-1, heights, dp);
//     }
//     private static int helper(int idx, int arr[], int dp[]) {
//         if(idx == 0) {
//             return 0;
//         }
//         if(dp[idx] != -1) {
//             return dp[idx];
//         }
//         int left = helper(idx-1, arr, dp) + Math.abs(arr[idx]-arr[idx-1]);
//         int right = Integer.MAX_VALUE;
//         if(idx > 1) {
//             right = helper(idx-2, arr, dp) + Math.abs(arr[idx]- arr[idx-2]);
//         }
//         dp[idx] = Math.min(left, right);
//          return Math.min(left, right);
//       }
    
  //      Tabulation DP (Bottom-Up Approach)
//      public static int frogJump(int n, int heights[]) {
//          int dp[] = new int[n];
//          dp[0] = 0;
//          for(int i = 1; i < n; i++) {
//              int fs = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
//              int ss = Integer.MAX_VALUE;
//              if(i > 1) {
//                  ss = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
//              }
//              dp[i] = Math.min(fs, ss);
//          }
//          return dp[n-1];
//      }
    
    // Tabulation DP with Space Optimization
    public static int frogJump(int n, int heights[]) {
         int prev = 0;
        int prev2 = 0;
         for(int i = 1; i < n; i++) {
             int fs = prev + Math.abs(heights[i] - heights[i-1]);
             int ss = Integer.MAX_VALUE;
             if(i > 1) {
                 ss = prev2 + Math.abs(heights[i] - heights[i-2]);
             }
             int curri = Math.min(fs, ss);
             prev2 = prev;
             prev = curri;
         }
         return prev;
     }
}