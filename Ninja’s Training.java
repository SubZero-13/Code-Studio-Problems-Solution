import java.util.Arrays;
public class Solution {

    // DP Tabulation(Bottom up)
    public static int ninjaTraining(int n, int[][] points) {
        int dp[][] = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        
        for(int day = 1; day < n; day++) {
            for(int last = 0; last < 4; last++) {
                 int max = 0;
                for(int task = 0; task <= 2; task++) {
                    if(task != last) {
                        int activity = points[day][task] + dp[day-1][task];
                        max = Math.max(activity, max);
                    }
                }
                dp[day][last] = max;
            }
        }
        return dp[n-1][3];
    }
    
    
 //   Recursion with Memoization (Top Down Approach)
//     static int f(int day, int last, int[][] points, int[][] dp) {

//         if (dp[day][last] != -1) return dp[day][last];

//         if (day == 0) {
//             int maxi = 0;
//             for (int i = 0; i <= 2; i++) {
//                 if (i != last)
//                     maxi = Math.max(maxi, points[0][i]);
//             }
//             return dp[day][last] = maxi;
//         }

//         int maxi = 0;
//         for (int i = 0; i <= 2; i++) {
//             if (i != last) {
//                 int activity = points[day][i] + f(day - 1, i, points, dp);
//                 maxi = Math.max(maxi, activity);
//             }

//         }

//         return dp[day][last] = maxi;
//     }

//     public static int ninjaTraining(int n, int[][] points) {

//         int dp[][] = new int[n][4];
//         for (int[] row: dp)
//             Arrays.fill(row, -1);

//         return f(n - 1, 3, points, dp);
//     }

}