import java.util.Arrays;
import java.util.Random;

public class UBKnapsack {
    // recursion
    public static int getProfit(int[] w, int[] p, int cap, int idx) {
        if (cap <= 0)
            return 0;
        if (idx == 0) {
            return (cap / w[idx]) * p[idx];
        }
        int take = 0;
        int notTake = 0;
        // take
        if (cap >= w[idx])
            take = p[idx] + getProfit(w, p, cap - w[idx], idx);
        notTake = getProfit(w, p, cap, idx - 1);

        return Math.max(take, notTake);
    }
    // memoization
    public static int getProfit(int[] w, int[] p, int cap, int idx, int[][] memo) {
        if (cap <= 0)
            return 0;
        if (idx == 0) {
            return (cap / w[idx]) * p[idx];
        }
        if (memo[idx][cap] != -1)
            return memo[idx][cap];
        int take = 0;
        int notTake = 0;
        // take
        if (cap >= w[idx])
            take = p[idx] + getProfit(w, p, cap - w[idx], idx, memo);
        notTake = getProfit(w, p, cap, idx - 1, memo);

        return memo[idx][cap] = Math.max(take, notTake);
    }

    // memoization
    public static int getProfitTab(int[] w, int[] p, int cap) {
        int n = w.length;
        int[][] dp = new int[n][cap + 1];
        // filling the base case
        for (int c = 0; c <= cap; c++) 
            if (c >= w[0]) 
                dp[0][c] = (c / w[0]) * p[0];
        // 2nd index onwards
        for (int i = 1; i < n; i++) {
            for (int c = 0; c <= cap; c++) {
                int take = 0;
                int notTake = 0;
                if (c >= w[i])
                    take = p[i] + dp[i][c - w[i]];
                notTake = dp[i - 1][c];
                dp[i][c] = Math.max(take, notTake);
            }
        }
        return dp[n - 1][cap];
    }
    
    public static void main(String[] args) {
        int[] w = { 5, 2, 2, 6 };
        int[] p = { 10, 5, 3, 11 };
        int cap = 15;
        int idx = w.length;
        int[][] memo1 = new int[idx][cap + 1];
        for (int i = 0; i < idx; i++)
            Arrays.fill(memo1[i], -1);

        // Random inputs
        int n = 100;
        Random rd = new Random();
        int[] wr = new int[n];
        int[] pr = new int[n];
        int cap2 = 20;
        for (int i = 0; i < n; i++) {
            wr[i] = rd.nextInt(10) + 1;
            pr[i] = rd.nextInt(20) + 1;
        }
        int[][] memo2 = new int[n][cap2 + 1];
        for (int i = 0; i < n; i++)
            Arrays.fill(memo2[i], -1);

        // System.out.println(getProfit(w, p, cap, idx - 1));
        // System.out.println(getProfit(w, p, cap, idx - 1, memo1));

        // // for more inputs
        // System.out.println(getProfit(wr, pr, cap2, n - 1, memo2));
        // System.out.println(getProfit(wr, pr, cap2, n - 1));
        System.out.println(getProfitTab(w, p, cap));
    }
}