import java.util.Arrays;
import java.util.Random;

public class NonAdjacentMaxSum {
    static final int MIN = Integer.MIN_VALUE;

    // brute force (recursion only)
    public static int getSum(int[] nums, int idx) {
        // base case
        if (idx >= nums.length)
            return 0;
        if (idx == nums.length - 1)
            return nums[idx];
        int include = nums[idx] + getSum(nums, idx + 2);
        int exclude = 0 + getSum(nums, idx + 1);
        return Math.max(include, exclude);
    }

    // recursion + memoization
    public static int getSum(int[] nums, int idx, int[] memo) {
        // base case
        if (idx >= nums.length)
            return 0;
        if (idx == nums.length - 1)
            return nums[idx];
        if (memo[idx] != MIN)
            return memo[idx];
        int include = nums[idx] + getSum(nums, idx + 2, memo);
        int exclude = 0 + getSum(nums, idx + 1, memo);
        return memo[idx] = Math.max(include, exclude);
    }

    // tabulation
    public static int getSum(int[] num) {
        int n = num.length;
        if (n == 0)
            return MIN;
        if (n == 1)
            return num[0];
        // memo
        int[] memo = new int[n];
        memo[0] = num[0];
        memo[1] = Math.max(num[0], num[1]);
        for (int i = 2; i < n; i++) {
            // include
            int include = num[i] + memo[i - 2];
            // exclude
            int exclude = 0 + memo[i - 1];
            memo[i] = Math.max(include, exclude);
        }
        return memo[n - 1];
    }

    // tabulation(O(1) space complexity)
    public static int getSumOpt(int[] num) {
        int n = num.length;
        if (n == 0)
            return MIN;
        if (n == 1)
            return num[0];
        // memo
        int curr = 0;
        int prev2 = num[0];
        int prev1 = Math.max(num[0], num[1]);
        for (int i = 2; i < n; i++) {
            curr = Math.max(prev2 + num[i], prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }

    public static void main(String[] args) {
        int[] nums = { 9, 8, 3, 9 };
        int[] memo = new int[nums.length + 1];
        Arrays.fill(memo, MIN);
        int n = 50;
        int[] arr = new int[n];

        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rd.nextInt(101) - 100; // -100 to 100
        }

        System.out.println(getSumOpt(arr));
        System.out.println(getSum(arr));
        // System.out.println(getSum(nums, 0));
        // System.out.println(getSum(nums));
    }
}
