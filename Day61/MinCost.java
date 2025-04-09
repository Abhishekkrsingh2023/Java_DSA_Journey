import java.util.Arrays;

public class MinCost {
    // Brute force
    public static int getMinCost(int n, int[] cost) {
        if (n <= 1) return 0;
        int cost1 = getMinCost(n - 1, cost) + cost[n - 1];
        int cost2 = getMinCost(n - 2, cost) + cost[n - 2];
        return Math.min(cost1, cost2);
    }

    // dp + memoization(top - down)
    public static int getMinCost(int n, int[] cost, int[] memo) {
        if (n <= 1) return 0;
        if (memo[n] != -1) return memo[n];
        int cost1 = getMinCost(n - 1, cost, memo) + cost[n - 1];
        int cost2 = getMinCost(n - 2, cost, memo) + cost[n - 2];
        return memo[n] = Math.min(cost1, cost2);
    }

    // bottom-up
    public static int getCost(int n, int[] cost) {
        if (n <= 0) return 0;
        int[] memo = new int[n + 1];
        memo[0] = memo[1] = 0;
        for (int i = 2; i <= n; i++) {
            memo[i] = Math.min(cost[i - 1] + memo[i - 1], cost[i - 2] + memo[i - 2]);
        }
        return memo[n];
    }

    // optimized space complexity
    public static int getCostOpt(int n, int[] cost) {
        if (n <= 0) return 0;
        int prev2 = 0, prev1 = 0, curr = 0;
        for (int i = 2; i <= n; i++) {
            curr = Math.min(cost[i - 1] + prev1, cost[i - 2] + prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }


    public static void main(String[] args) {
        int n = 3;
        int n2 = 4;
        int[] cost = {10, 15, 20};
        int[] cost2 = {10, 2, 6, 11};
        int[] memo = new int[n2 + 1];
        Arrays.fill(memo, -1);
        System.out.println(getMinCost(n, cost));
        System.out.println(getMinCost(n2, cost2, memo));
        System.out.println(getCost(n2, cost2));
        System.out.println(getCostOpt(n2, cost2));
    }
}
