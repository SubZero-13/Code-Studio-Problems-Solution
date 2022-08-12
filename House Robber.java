
public class Solution {

	public static int maxMoneyLooted(int[] houses) {
        // DP Solution
        int n = houses.length;
        int dp[]  = new int[n];
        dp[0] = houses[0];
        for(int i = 1; i < houses.length; i++) {
            int left = houses[i];
            if(i > 1) {
                left += dp[i-2];
            }
            int right = dp[i-1] + 0;
            dp[i] = Math.max(left, right);
        }
        return dp[n-1];
	}
    // Recursive solution 
//     private static int helper(int arr[], int idx) {
//         if(idx >= arr.length) {
//             return 0;
//         }
//         int left = arr[idx] + helper(arr, idx+2);
//         int right = 0+helper(arr, idx+1);
//         return Math.max(left, right);
//     }
}