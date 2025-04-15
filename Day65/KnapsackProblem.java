import java.util.Arrays;
import java.util.Random;

public class KnapsackProblem {
    // Brute force
    public static int knapsack(int[] w, int[] p, int cap, int idx) {
        if (idx < 0 || cap <= 0)
            return 0;
        int include = 0;
        if (w[idx] <= cap)
            include = p[idx] + knapsack(w, p, cap - w[idx], idx - 1);
        int exclude = knapsack(w, p, cap, idx - 1);

        return Math.max(include, exclude);
    }

    // recursion + memoization
    public static int knapsackMemo(int[] w, int[] p, int cap, int idx, int[][] memo) {
        if (idx < 0 || cap <= 0)
            return 0;
        if (memo[idx][cap] != -1)
            return memo[idx][cap];
        // include
        int include = 0;
        if (w[idx] <= cap)
            include = p[idx] + knapsackMemo(w, p, cap - w[idx], idx - 1, memo);
        // exclude
        int exclude = knapsackMemo(w, p, cap, idx - 1, memo);
        return memo[idx][cap] = Math.max(include, exclude);
    }

    // Tabulation
    public static int knapsackTab(int[] w, int[] p, int cap) {
        int n = w.length;
        int[][] dp = new int[n + 1][cap + 1]; // extra row for 0 items

        for (int i = 1; i <= n; i++)
            for (int j = 0; j <= cap; j++) {
                int include = 0;
                if (w[i - 1] <= j)
                    include = p[i - 1] + dp[i - 1][j - w[i - 1]];
                int exclude = dp[i - 1][j];
                dp[i][j] = Math.max(include, exclude);
            }
        return dp[n][cap];
    }

    public static void main(String[] args) {
        int[] w = { 1, 5, 2, 7, 3 };
        int[] p = { 5, 3, 8, 4, 6 };
        int cap = 10;

        // for checking TLE
        int n = 35;
        int[] w1 = new int[n];
        int[] p1 = new int[n];
        int cap1 = 100;
        Random rand = new Random();
        int[][] memo = new int[n][cap1 + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        for (int i = 0; i < n; i++) {
            w1[i] = rand.nextInt(10) + 1; // weights between 1–10
            p1[i] = rand.nextInt(20) + 1; // profits between 1–20
        }

        // // Brute-force (will likely TLE or be very slow)
        // long start1 = System.currentTimeMillis();
        // System.out.println("Brute-force result: " + knapsack(w1, p1, cap1, n - 1));
        // long end1 = System.currentTimeMillis();
        // System.out.println("Brute-force time: " + (end1 - start1) + "ms");
        // // memoized code
        // long start2 = System.currentTimeMillis();
        // System.out.println("Memoized result: " + knapsackMemo(w1, p1, cap1, n - 1,
        // memo));
        // long end2 = System.currentTimeMillis();
        // System.out.println("Memoized time: " + (end2 - start2) + "ms");
        System.out.println(knapsackTab(w1, p1, cap1));
    }
}
