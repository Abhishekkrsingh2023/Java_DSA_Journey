import java.util.Arrays;

public class MinCostCount {
    // Brute force (recursive)
    public static int getCount(int target, int[] nums) {
        if (target == 0)
            return 0;
        if (target < 0)
            return Integer.MAX_VALUE;
        // finding the min count in each level
        int minVal = Integer.MAX_VALUE;
        for (int ele : nums) {
            int res = getCount(target - ele, nums);
            if (res != Integer.MAX_VALUE) {
                minVal = Math.min(minVal, 1 + res);
            }
        }
        return minVal;
    }

    // Memoization
    public static int getCount(int target, int[] nums, int[] memo) {
        if (target == 0)
            return 0;
        if (target < 0)
            return Integer.MAX_VALUE;
        if (memo[target] != -1)
            return memo[target];

        int minVal = Integer.MAX_VALUE;
        for (int ele : nums) {
            int res = getCount(target - ele, nums, memo);
            if (res != Integer.MAX_VALUE) {
                minVal = Math.min(minVal, 1 + res);
            }
        }
        return memo[target] = minVal;
    }

    // bottom -> up approach coins = { 2, 5, 3 }; target = 7
    public static int getMinCoins(int target, int[] coins) {
        int[] memo = new int[target + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        // for amt = 0, we need 0 coins
        memo[0] = 0;
        // from 0 -> target amt
        for (int amt = 0; amt <= target; amt++) {
            for (int coin : coins) {
                // checking for viable amt
                if (amt >= coin && memo[amt-coin] != Integer.MAX_VALUE)
                    memo[amt] = Math.min(memo[amt], 1 + memo[amt - coin]);
            }
        }
        // no answer
        if (memo[target] == Integer.MAX_VALUE)
            return -1;
        return memo[target];
    }

    public static void main(String[] args) {
        int n = 300;
        int[] nums = { 2, 5, 3 };
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        System.out.println(getCount(52, nums));
        System.out.println(getCount(300, nums, memo));
        System.out.println(getMinCoins(300, nums));
    }
}
