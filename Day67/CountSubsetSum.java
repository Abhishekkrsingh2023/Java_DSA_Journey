import java.util.Random;

public class CountSubsetSum {

    public static int countSum(int[] arr, int sum, int idx) {
        if (sum == 0)
            return 1;
        if (idx == 0) {
            if (arr[idx] == sum)
                return 1;
            else
                return 0;
        }
        int pick = 0;
        int notPick = 0;

        if (arr[idx] <= sum)
            pick = countSum(arr, sum - arr[idx], idx - 1);
        notPick = countSum(arr, sum, idx - 1);
        return pick + notPick;
    }
    public static int countSumTabulation(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n][target + 1];
        // Base case: There is 1 way to make sum = 0 (empty subset)
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        // Handle first element separately
        if (arr[0] <= target) {
            dp[0][arr[0]] = 1;
        }
    
        // Fill the table
        for (int i = 1; i < n; i++) {
            for (int sum = 0; sum <= target; sum++) {
                int notPick = dp[i - 1][sum];
                int pick = 0;
                if (arr[i] <= sum) {
                    pick = dp[i - 1][sum - arr[i]];
                }
                dp[i][sum] = pick + notPick;
            }
        }
        return dp[n - 1][target];
    }
    
    public static void main(String[] args) {
        int[] arr = { 1, 5, 3, 6, 8 };
        int n = arr.length;
        int n2 = 30;
        Random r = new Random();
        int[] arr2 = new int[30];
        for (int i = 0; i < n; i++) {
            arr2[i] = r.nextInt(30);
        }
        int sum = 8;
        System.out.println(countSum(arr, sum, n - 1));
        System.out.println(countSumTabulation(arr, 8));
    }
}
