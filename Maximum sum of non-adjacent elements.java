import java.util.*;
public class Solution {
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// DP Tabulation
//         int n = nums.size();
//         int dp[] = new int[n];
//         dp[0] = nums.get(0);
//         for(int i = 1; i < n; i++) {
//             int pick = nums.get(i);
//             if(i > 1) {
//                 pick += dp[i-2];
//             }
//             int notPick = 0+dp[i-1];
//             dp[i] = Math.max(pick, notPick);
//         }
//         return dp[n-1];
        
        // DP with Space Optimization
                int n = nums.size();
        int prev  = nums.get(0);
        int prev2 = 0;
        for(int i = 1; i < n; i++) {
            int pick  = nums.get(i);
            if(i > 1) {
                 pick += prev2;
            }
            int notPick = 0+prev;
            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
	}
    
//     DP With Memoization and Recurssion
//     private static int solve(ArrayList<Integer> nums, int i, int[] dp) {
//         if(i >= nums.size()) {
//             return 0;
//         }
//         if(dp[i] != -1) {
//             return dp[i];
//         }
//         int sum1  = nums.get(i) + solve(nums, i+2, dp);
//         int sum2  = Integer.MIN_VALUE;
//         if(i < nums.size()-1) {
//             sum2 = nums.get(i+1) + solve(nums, i+3, dp);
//            }
//         return dp[i] = Math.max(sum1, sum2);
//     }
}