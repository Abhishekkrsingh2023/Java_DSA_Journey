import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class longestIncSeq {
    // Function to find the length of the longest increasing subsequence
    public static int getCount(int[] nums, int i, int prev) {
        // no elements left
        if (i == nums.length)
            return 0;
        int take = 0;
        if (prev == -1 || nums[i] > nums[prev])
            take = 1 + getCount(nums, i + 1, i);
        int notTake = getCount(nums, i + 1, prev);
        return Math.max(take, notTake);
    }

    // memoized recursion
    public static int getCount(int[] nums, int i, int prev, int[][] memo) {
        // no elements left
        if (i == nums.length)
            return 0;
        if (memo[i][prev + 1] != -1)
            return memo[i][prev + 1];
        int take = 0;
        if (prev == -1 || nums[i] > nums[prev])
            take = 1 + getCount(nums, i + 1, i, memo);
        int notTake = getCount(nums, i + 1, prev, memo);
        return memo[i][prev + 1] = Math.max(take, notTake);
    }

    // Tabulation
    public static int getCount(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int prev = i - 1; prev >= -1; prev--) {
                int take = 0;
                if (prev == -1 || nums[i] > nums[prev]) {
                    take = 1 + dp[i + 1][i + 1]; // prev = i
                }
                int notTake = dp[i + 1][prev + 1];
                dp[i][prev + 1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }

    // space optimized + path retracing
    public static List<Integer> getTheSequence(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int prev = 0; prev < i; prev++) {
                if (nums[prev] < nums[i] && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
        }
        int max = 1, idx = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max) {
                max = dp[i];
                idx = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (hash[idx] != idx) {
            ans.add(nums[idx]);
            idx = hash[idx];
        }
        ans.add(nums[idx]);
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        int n = nums.length;
        int[][] memo = new int[n][n + 1];
        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i], -1);
        System.out.println(getCount(nums, 0, -1));
        System.out.println(getCount(nums, 0, -1, memo));
        System.out.println(getCount(nums));
        System.out.println(getTheSequence(nums));

    }
}