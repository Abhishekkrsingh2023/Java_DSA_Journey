import java.util.Arrays;

public class StairClimbingProblem {
    // brute force O(2^n)
    public static int ways(int n, int step) {
        // base case
        if (step == n) return 1;
        if (step > n) return 0;
        // 1 and 2 steps
        return ways(n, step + 1) + ways(n, step + 2);
    }
    // optimized top-down approach
    public static int climWays(int n, int step, int[] memo) {
        // base case
        if (step == n) return 1;
        if (step > n) return 0;
        // memoization
        if (memo[step] != -1) return memo[step];
        // storing the value
        return memo[step] = climWays(n, step + 1, memo) + climWays(n, step + 2, memo);
    }

    public static void main(String[] args) {
        int n = 5;
        int[] memo = new int[n + 2];
        Arrays.fill(memo, -1);
        System.out.println(climWays(n, 0, memo));
    }
}
