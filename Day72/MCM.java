// package Day72;

public class MCM {
    // Dynamic Programming
    public static int getSteps(int[] arr, int n) {
        int[][] dp = new int[n][n];
        // filling the array
        for (int d = 1; d < n - 1; d++) {
            for (int i = 1; i < n - d; i++) {
                int j = i + d;
                dp[i][j] = Integer.MAX_VALUE;
                // exploring all the partitions
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + 
                    arr[i - 1] * arr[k] * arr[j]);
                }
            }
        }
        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int[] arr = { 20, 30, 40, 45, 50 }; // dimensions of the Matrix (n-1) matrices
        int n = arr.length;

        System.out.println(getSteps(arr, n));
    }
}
