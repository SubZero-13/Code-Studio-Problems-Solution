public class Solution {
    
    // DP Solution
    public static long houseRobber(int[] valueInHouse) {
        int n = valueInHouse.length;
        if(n == 1) {
            return valueInHouse[0];
        }
        int arr1[] = new int[n-1];
        int arr2[] = new int[n-1];
        int j = 0;
        int k = 0;
        for(int i = 0; i < n; i++) {
            if(i != 0) {
                    arr1[j++] = valueInHouse[i];
                }
            if(i != n-1) {
                arr2[k++] = valueInHouse[i];
            }
        }
        return Math.max(helper(arr1), helper(arr2));
    }
    
    private static long  helper(int[] arr) {
        long dp[] = new long[arr.length];
        dp[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            long pick = arr[i];
            if(i > 1) {
                pick += dp[i-2];
            }
            long notPick = 0 + dp[i-1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[arr.length-1];
    }
    
    
    
    // Recursive Solution
// 	public static long houseRobber(int[] valueInHouse) {
//         int n = valueInHouse.length;
//         if(n == 1) {
//             return valueInHouse[0];
//         }
//         int arr1[] = new int[n-1];
//         int arr2[] = new int[n-1];
//         int j = 0;
//         int k = 0;
//         for(int i = 0; i < n; i++) {
//             if(i != 0) {
//                     arr1[j++] = valueInHouse[i];
//                 }
//             if(i != n-1) {
//                 arr2[k++] = valueInHouse[i];
//             }
//         }
//         return Math.max(helper(arr1, 0), helper(arr2, 0));
// 	}	
//     private static long helper(int[] arr, int idx) {
//         if(idx >= arr.length) {
//              return 0;
//         }
//         long pick = arr[idx] + helper(arr, idx+2);
//         long notPick = 0 + helper(arr, idx+1);
//         return Math.max(pick, notPick);
//     }
}